package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe principal que atua como o ponto de entrada do sistema de votação.
 * */
public class Principal {

  /**
   * Ponto de entrada da aplicação que coordena o fluxo do sistema de votação.
   * <p>
   * O método inicializa o scanner para entrada de dados e o gerenciador de votação,
   * orientando o usuário através das etapas sucessivas de cadastro de candidatos,
   * cadastro de eleitores e a realização do pleito.
   * </p>
   *
   * @param args Argumentos de linha de comando (não utilizados nesta implementação).
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    GerenciamentoVotacao gv = new GerenciamentoVotacao();

    cadastrarPessoaCandidata(sc, gv);
    System.out.println("Continuando o código...");

    cadastrarPessoaEleitora(sc, gv);
    System.out.println("Continuando o código...");
    realizarVotacao(sc, gv);

    sc.close();
    System.out.println("Encerrando o programa!!");
  }

  /**
   * Gerencia o fluxo de cadastro de candidatos via terminal.
   * <p>
   *  Exibe um menu interativo que permite ao usuário cadastrar múltiplas pessoas candidatas
   *  inserindo nome e número, ou encerrar o ciclo de cadastro.
   * </p>
   *
   * @param scanner Instância de Scanner para leitura das entradas do usuário.
   * @param gerenciamentoVotacao Instância do gerenciador onde os dados serão armazenados.
   */
  public static void cadastrarPessoaCandidata(
      Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao
  ) {
    int option;
    do {
      menuInicial("candidata");
      option = lerValidarOpcao(scanner, 2);

      if (option == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.nextLine();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = Integer.parseInt(scanner.nextLine());
        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      }
    } while (option != 2);
  }

  /**
   * Gerencia o fluxo de cadastro de eleitores via terminal.
   * <p>
   *  Permite a entrada repetitiva de nomes e CPFs para o cadastro de pessoas eleitoras
   *  no sistema até que o usuário opte por sair.
   * </p>
   *
   * @param scanner Instância de Scanner para leitura das entradas.
   * @param gerenciamentoVotacao Objeto responsável por processar o cadastro das eleitoras.
   */
  public static void cadastrarPessoaEleitora(
      Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao
  ) {
    int option;
    do {
      menuInicial("eleitora");
      option = lerValidarOpcao(scanner, 2);

      if (option == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scanner.nextLine();
        System.out.println("Entre com o CPF da pessoa eleitora:");
        String cpf = scanner.nextLine();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      }
    } while (option != 2);
  }

  /**
   * Coordena o processo de votação e exibição de resultados.
   * <p>
   *  Oferece um menu com opções para registrar um voto (solicitando CPF do eleitor e
   *  número do candidato), visualizar o resultado parcial ou encerrar o pleito com
   *  a exibição do resultado final.
   * </p>
   *
   * @param scanner Instância de Scanner para capturar os dados da votação.
   * @param gerenciamentoVotacao Gerenciador que computa os votos e gera resultados.
   */
  public static void realizarVotacao(
      Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao
  ) {
    int option;
    do {
      menuInicialVotacao();
      option = lerValidarOpcao(scanner, 3);

      if (option == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.nextLine();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = Integer.parseInt(scanner.nextLine());
        gerenciamentoVotacao.votar(cpf, numeroCandidato);
      } else if (option == 2) {
        gerenciamentoVotacao.mostrarResultado();
      }
    } while (option != 3);
    gerenciamentoVotacao.mostrarResultado();
  }

  /**
   * Exibe no console a pergunta inicial de cadastro personalizada pelo tipo de pessoa.
   *
   * @param tipoDePessoa String indicando se o cadastro é de "candidata" ou "eleitora".
   */
  public static void menuInicial(String tipoDePessoa) {
    System.out.println("Cadastrar pessoa " + tipoDePessoa + "?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
  }

  /**
   * Exibe as opções disponíveis durante a fase ativa de votação no sistema.
   */
  public static void menuInicialVotacao() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar Votação");
  }

  /**
   * Realiza a leitura da entrada do usuário e valida se ela pertence ao intervalo permitido.
   * <p>
   *  O método trata exceções de formato (caso o usuário digite letras em vez de números)
   *  e garante que a opção esteja dentro dos limites do menu apresentado.
   * </p>
   *
   * @param scanner Instância de Scanner para leitura.
   * @param maxOpcoes O limite superior das opções válidas do menu.
   * @return Retorna um integer da opção válida selecionada pelo usuário.
   */
  private static int lerValidarOpcao(Scanner scanner, int maxOpcoes) {
    int option = 0;
    boolean isValid = false;

    while (!isValid) {
      try {
        option = Integer.parseInt(scanner.nextLine());
        if (option >= 1 && option <= maxOpcoes) {
          isValid = true;
        } else {
          System.out.println(
              "Opção inválida! As suas opções são entre 1 e "
              + maxOpcoes
              + ":"
          );

        }
      } catch (NumberFormatException error) {
        System.out.println(
            "Opção inválida! As suas opções são entre 1 e "
            + maxOpcoes
            + ":"
        );
      }
    }
    return option;
  }
}
