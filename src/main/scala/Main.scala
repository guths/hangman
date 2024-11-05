import zio.*
import zio.Console.printLine

sealed case class Name private(name: String)

object Name {
  def make(name: String): Option[Name] = if (name.nonEmpty) Some(Name(name)) else None
}

sealed abstract case class Guess private (char: Char)
object Guess {
  def make(str: String): Option[Guess] =
    Some(str.toList).collect {
      //search what is this c ::
      case c :: Nil if c.isLetter => new Guess(c.toLower) {}
    }
}

//search what is this private after class name
sealed abstract case class Word private (word: String) {
  def contains(char: Char): Boolean = word.contains(char)
  val length: Int = word.length
  def toList: List[Char] = word.toList
  def toSet: Set[Char] = word.toSet
}

object Word {
  def make(word: String): Option[Word] =
    if (word.nonEmpty && word.forall(_.isLetter)) Some(new Word(word.toLowerCase) {})
    else None
}


sealed abstract case class State private (name: Name, guesses: Set[Guess], word: Word) {
  // -- remove characters present in word set
  // the remain characters are the failures
  // -- right remove elements from the left
  //  val numbers = Set(1, 2, 3, 4, 5)
  //  val toRemove = Set(2, 4)
  //  val result = numbers -- toRemove // Result: Set(1, 3, 5)

  def failuresCount: Int = (guesses.map(_.char) -- word.toSet).size
  //failuresCount is called as a field of a class but is a method
  //this is possible because the method do not have parameters
  def playerLost: Boolean = failuresCount > 5
  def playerWon: Boolean = (word.toSet -- guesses.map(_.char)).isEmpty
  def addGuess(guess: Guess): State = new State(name, guesses + guess, word ){}
}

object State {
  def initial(name: Name, word: Word): State = new State(name, Set.empty, word) {}
}

sealed trait GuessResult

object GuessResult {
  case object Won extends GuessResult
  case object Lost extends GuessResult
  case object Correct extends GuessResult
  case object Incorrect extends GuessResult
  case object Unchanged extends GuessResult
}

//flat map guarantee that the effect of the print line gonna to be passed
//the effect of the printLine is not discarded
def getUserInput(message: String): IO[Throwable, String] =
  Console.printLine(message).flatMap(_ => Console.readLine)

def getUserInputHardWay(message: String): IO[Throwable, String] =
  Console.printLine(message) <*> Console.readLine
  //the <*> combine two effects, returning a tuple (Unit, String), the result of the two effects
  //in ZIO 2 the Unit effect is discarded, this is why (Unit, String) compile here

def getUserInputHardWayTwo(message: String): IO[Throwable, String] =
  Console.printLine(message) *> Console.readLine
  //the effect of printLine can be discarded, so use *> to always discard left side computation

lazy val getName: IO[Throwable, Name] =
  for {
    input <- getUserInput("Whats your name? ")
    name <- Name.make(input) match {
      case Some(name) => ZIO.succeed(name)
      case None => Console.printLine("Invalid input. Please try again...") <*> getName
    }
  } yield name

lazy val chooseWord: UIO[Word] =
  for {
    index <- Random.nextIntBounded(helper.words.length)
    word  <- ZIO.from(helper.words.lift(index).flatMap(Word.make)).orDieWith(_ => new Error("Boom!"))
    //ZIO from -> convert to ZIO effect
  } yield word


def renderState(state: State): IO[Exception, Unit] = {

  /*
      --------
      |      |
      |      0
      |     \|/
      |      |
      |     / \
      -

      f     n  c  t  o
      -  -  -  -  -  -  -
      Guesses: a, z, y, x
  */
  val hangman = ZIO.attempt(helper.hangmanStages(state.failuresCount)).orDie
  val word =
    state.word.toList
      .map(c => if (state.guesses.map(_.char).contains(c)) s" $c " else "   ")
      .mkString

  val line = List.fill(state.word.length)(" - ").mkString
  val guesses = s" Guesses: ${state.guesses.map(_.char).mkString(", ")}"

  hangman.flatMap { hangman =>
    Console.printLine {
      s"""
         #$hangman
         #
         #$word
         #$line
         #
         #$guesses
         #
         #""".stripMargin('#')
    }
  }
}

lazy val getGuess: IO[Throwable, Guess] =
  for {
    input <- getUserInput("What's your next guess? ")
    guess <- ZIO.from(Guess.make(input)) <> (Console.printLine("Invalid input. Please try again...") <*> getGuess)
  } yield guess

def analyzeNewGuess(oldState: State, newState: State, guess: Guess): GuessResult =
  if (oldState.guesses.contains(guess)) GuessResult.Unchanged
  else if (newState.playerWon) GuessResult.Won
  else if (newState.playerLost) GuessResult.Lost
  else if (oldState.word.contains(guess.char)) GuessResult.Correct
  else GuessResult.Incorrect

def gameLoop(oldState: State): IO[Throwable, Unit] =
  for {
    guess       <- renderState(oldState) <*> getGuess
    newState    = oldState.addGuess(guess)
    guessResult = analyzeNewGuess(oldState, newState, guess)
    _ <- guessResult match {
      case GuessResult.Won =>
        Console.printLine(s"Congratulations ${newState.name.name}! You won!") <*> renderState(newState)
      case GuessResult.Lost =>
        Console.printLine(s"Sorry ${newState.name.name}! You Lost! Word was: ${newState.word.word}") <*>
          renderState(newState)
      case GuessResult.Correct =>
        Console.printLine(s"Good guess, ${newState.name.name}!") <*> gameLoop(newState)
      case GuessResult.Incorrect =>
        Console.printLine(s"Bad guess, ${newState.name.name}!") <*> gameLoop(newState)
      case GuessResult.Unchanged =>
        Console.printLine(s"${newState.name.name}, You've already tried that letter!") <*> gameLoop(newState)
    }
  } yield ()

object Main extends ZIOAppDefault:
  override def run: ZIO[Environment & ZIOAppArgs & Scope, Any, Any] =
    for {
      name <- Console.printLine("Welcome to ZIO Hangman!") <*> getName
      word <- chooseWord
      _ <- gameLoop(State.initial(name, word))
    } yield ()

