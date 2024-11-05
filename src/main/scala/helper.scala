object helper {
  val words: Seq[String] = Seq(
    "abacaxi", "abelha", "abismo", "abóbora", "abraço", "absorver", "abundante", "acaso", "acelerar", "acento",
    "acertar", "acontecimento", "acordeão", "acrobata", "adeus", "adiantar", "adivinhar", "administração", "adolescente", "adversário",
    "afastado", "afeto", "afinidade", "aflição", "água", "agulha", "ajuda", "ajustar", "alegria", "alerta",
    "alfabeto", "algodão", "algoritmo", "aliança", "alicate", "alienígena", "alimento", "aliviar", "almofada", "altar",
    "altura", "alucinação", "alvorada", "amado", "amanhã", "amarelo", "amável", "ambição", "amendoim", "amizade",
    "amor", "amostra", "amparar", "análise", "âncora", "anel", "anfitrião", "anjo", "anjos", "anomalia",
    "ansiedade", "antiquado", "ânus", "anzol", "apagar", "aparecer", "apartamento", "apego", "apelido", "apito",
    "aplaudir", "aplicar", "apoio", "aposta", "aproveitar", "aquecer", "aquilo", "aranha", "arbusto", "areia",
    "arma", "armário", "aroma", "arremessar", "arte", "asfalto", "aspiração", "assalto", "assassino", "assemelhar",
    "assinar", "assistir", "astro", "atitude", "atleta", "atmosfera", "atordoar", "atraente", "atual", "audiência",
    "aumento", "aurora", "australiano", "autoridade", "avalanche", "aventura", "aviação", "avisar", "axila", "azar",
    "azeitona", "bacia", "bagagem", "bailarina", "bala", "baleia", "banco", "banheira", "banho", "banquete",
    "barata", "barba", "barco", "barriga", "barulho", "base", "bateria", "batida", "batom", "beijo",
    "beleza", "belga", "benção", "bengala", "bermuda", "besta", "bexiga", "biblioteca", "bicicleta", "bife",
    "bigode", "bilhete", "bilionário", "biografia", "birra", "bisavó", "biscoito", "bisneto", "bloco", "boato",
    "bobagem", "bochecha", "bolha", "bolo", "bolsa", "bombeiro", "bondade", "borboleta", "bordado", "borracha",
    "bota", "boteco", "branco", "brasa", "bravo", "briga", "brilhante", "brincadeira", "brinquedo", "broto",
    "bruxa", "bruto", "bucha", "bueiro", "bufar", "buraco", "burro", "busto", "cabeça", "cabide",
    "cabo", "cabra", "cachimbo", "cachoeira", "cachorro", "cadeado", "cadeira", "café", "caixa", "caju",
    "calendário", "calor", "calvície", "cama", "camarão", "caminho", "camisa", "campanha", "campo", "canal",
    "caneca", "canguru", "canja", "cano", "cantina", "capitão", "cápsula", "caracol", "caravana", "carinho",
    "carneiro", "caroço", "carpinteiro", "carroça", "casa", "casamento", "cascata", "casco", "castanho", "castelo",
    "casulo", "catinga", "cavalo", "cedo", "celular", "cenoura", "cérebro", "certeza", "cessar", "chefe",
    "chicote", "chimarrão", "chinelo", "chip", "choque", "chuva", "ciência", "cilada", "cimento", "cinto",
    "cidade", "cigarro", "cilindro", "cinema", "círculo", "claridade", "classe", "clique", "coelho", "colar",
    "colher", "coluna", "comédia", "comida", "companheiro", "competição", "comunicação", "comunidade", "concha", "conciso",
    "concurso", "confiança", "conquista", "consertar", "consciência", "construção", "conta", "contrato", "coragem", "corda",
    "coração", "corcunda", "cordialidade", "corpo", "corrente", "corretor", "corte", "coruja", "costela", "couve",
    "covardia", "cravo", "creme", "criança", "crime", "cristal", "crítica", "croissant", "cruz", "cuidado",
    "culinária", "cultura", "curiosidade", "cursinho", "curva", "dança", "dardo", "dedal", "dedicar", "defesa",
    "defunto", "degrau", "delicioso", "dentista", "depoimento", "depressão", "desafio", "descanso", "desenho", "deserto",
    "desespero", "desgosto", "despertar", "destino", "deter", "detrás", "devagar", "dever", "dezembro", "diabo",
    "diagrama", "diamante", "diazepam", "diferença", "difícil", "dignidade", "dinossauro", "diocese", "disciplina", "disfarce",
    "disquete", "divino", "doação", "documento", "domador", "domínio", "doença", "doente", "domínio", "dólar",
    "dono", "dormente", "dossiê", "drama", "ducha", "duelo", "duende", "dulce", "dúvida", "duplo",
    "dureza", "edifício", "educação", "efeito", "elevador", "embrião", "emenda", "emoção", "encanto", "encomenda",
    "energia", "enfermeira", "enigma", "enlace", "enlouquecer", "entrega", "entusiasmo", "enviar", "enxofre", "épico",
    "episódio", "epopeia", "era", "ervilha", "escola", "escorregar", "escova", "escrever", "escultura", "esfera",
    "esmalte", "esperança", "espinafre", "espiritual", "esqueleto", "esquina", "essência", "estádio", "estrela", "estresse",
    "exemplo", "exibir", "exílio", "experiência", "explosão", "exposição", "extremo", "fabricante", "fabricação", "faca",
    "faculdade", "fã", "famoso", "fantasma", "farol", "fartura", "fazenda", "febre", "feixe", "felicidade",
    "feriado", "ferida", "fermento", "festival", "ficha", "figura", "filme", "fino", "firme", "físico",
    "fivela", "flamingo", "floresta", "flutuar", "foca", "foguete", "foice", "folha", "fonte", "força",
    "formiga", "forno", "fotógrafo", "fragância", "framboesa", "frango", "frase", "freira", "frio", "fruta",
    "fugir", "fumaça", "fundo", "furgão", "furto", "galáxia", "galeria", "galo", "gambiarra", "garçom",
    "garganta", "garoa", "gasolina", "gato", "geladeira", "gelo", "gengibre", "gênio", "gesso", "gigante",
    "gira", "globo", "glória", "goiaba", "goleiro", "gota", "governador", "grátis", "gravidade", "gravura",
    "grilo", "grito", "grosso", "guarda", "guerreiro", "guitarra", "habilidade", "harpa", "helicóptero", "herói",
    "hibisco", "hiena", "hino", "hipótese", "história", "horizonte", "horrível", "hortelã", "hospital", "hotel",
    "humano", "humildade", "humor", "ídolo", "igreja", "ilha", "iluminado", "imagem", "imaginação", "imigrante",
    "império", "importante", "incêndio", "incenso", "infância", "informação", "inimigo", "inovação", "instante", "instrumento",
    "inteligência", "intensidade", "interior", "invencível", "invitar", "irônico", "jacaré", "janela", "jardim", "jasmim",
    "jato", "jovem", "juba", "juiz", "jurídico", "ketchup", "lâmpada", "lápis", "laranja", "lágrima",
    "lazer", "legenda", "lembrança", "lentilha", "leopardo", "leque", "ler", "letra", "leveza", "liberdade",
    "lima", "limite", "líquido", "liso", "livro", "lobo", "loção", "locomotiva", "lógica", "longe",
    "lua", "luz", "maçã", "madeira", "magia", "magnético", "maluco", "mamãe", "mancha", "mandíbula",
    "maneira", "manteiga", "mar", "maravilha", "marca", "martelo", "massa", "matador", "medalha", "medo",
    "meia", "melancia", "melodia", "memória", "menino", "menta", "mentira", "mercado", "mesa", "mesquinho",
    "metro", "meu", "milagre", "mineral", "minúsculo", "mochila", "moda", "moleza", "momento", "montanha",
    "moral", "mosca", "música", "museu", "natal", "navio", "neblina", "necessário", "negócio", "neve",
    "noite", "nome", "nuvem", "oceano", "oficina", "óleo", "ônibus", "ontem", "ouro", "ovo",
    "oxigênio", "pá", "padrão", "página", "paisagem", "pancada", "pano", "papel", "parar", "parede",
    "parte", "passagem", "pasta", "patente", "pau", "pausa", "paz", "pedra", "pele", "pena",
    "pêndulo", "pessoa", "pé", "peteca", "pianista", "piano", "picolé", "pilha", "pintura", "pipa",
    "piso", "planeta", "plano", "plástico", "pluma", "pneumático", "poço", "poesia", "pólen", "polícia",
    "porta", "posto", "pousar", "povo", "prato", "prazer", "presente", "prestígio", "primavera", "professor",
    "prova", "psicologia", "pulga", "pular", "puro", "quadrado", "quadro", "queijo", "querer", "químico",
    "quimera", "raio", "ramo", "ranger", "rato", "receita", "recomeço", "recorde", "recreio", "reflexo",
    "região", "relógio", "remo", "renascer", "respeito", "risada", "ritmo", "robô", "rocha", "rosa",
    "rosto", "roubo", "rua", "sábio", "sacada", "sacola", "sangue", "sapo", "sarcófago", "saturado",
    "saudade", "segredo", "seguro", "selva", "senso", "sinal", "sintonia", "siri", "situação", "sol",
    "sombrio", "sorriso", "sorte", "sucesso", "sufoco", "sultão", "sumir", "susto", "tábua", "tarefa",
    "taxa", "teia", "tempo", "terra", "teste", "tigre", "tirar", "tomate", "torre", "touro",
    "tradição", "trama", "transporte", "trapo", "trave", "treino", "triste", "troféu", "truque", "tubulação",
    "turquesa", "universo", "urso", "utopia", "vagalume", "vapor", "varanda", "vazio", "vender", "vento",
    "verão", "verdade", "vermelho", "vidro", "vila", "violino", "vitória", "voar", "vontade", "voto",
    "xícara", "zebra", "zumbido", "zumbi"
  )


  val hangmanStages: Seq[String] = List(
    """
      #   --------
      #   |      |
      #   |
      #   |
      #   |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |
      #   |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |      |
      #   |      |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |     \|
      #   |      |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |     \|/
      #   |      |
      #   |
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |     \|/
      #   |      |
      #   |     /
      #   -
      #""".stripMargin('#'),
    """
      #   --------
      #   |      |
      #   |      0
      #   |     \|/
      #   |      |
      #   |     / \
      #   -
      #""".stripMargin('#')
  )
}
