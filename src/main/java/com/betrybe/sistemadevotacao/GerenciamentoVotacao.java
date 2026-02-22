package com.betrybe.sistemadevotacao;


import java.util.ArrayList;

/**
 * Classe responsável por gerenciar toda a lógica do sistema de votação.
 * <p>
 *  Esta classe centraliza o armazenamento de candidatos e eleitores, além de
 *  controlar a integridade do processo eleitoral, garantindo que os votos sejam computados
 *  corretamente e que cada eleitor vote apenas uma vez.
 * </p>
 *
 * @author Danilo Ferreira Queiroz
 * @see GerenciamentoVotacaoInterface
 */
public class GerenciamentoVotacao implements  GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Inicializa um novo gerenciamento de votação com listas pré-existentes de candidatos,
   * eleitores e registros de votos.
   *
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<PessoaCandidata>();
    this.pessoasEleitoras = new ArrayList<PessoaEleitora>();
    this.cpfsComputados = new ArrayList<String>();
  }

  public ArrayList<PessoaCandidata> getPessoasCandidatas() {
    return pessoasCandidatas;
  }

  public ArrayList<PessoaEleitora> getPessoasEleitoras() {
    return pessoasEleitoras;
  }

  public ArrayList<String> getCpfsComputados() {
    return cpfsComputados;
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean hasPessoaCandidata = this.getPessoasCandidatas().stream()
        .anyMatch(candidato -> candidato.getNumero() == numero);

    if (hasPessoaCandidata) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata candidato = new PessoaCandidata(nome, numero);
      this.pessoasCandidatas.add(candidato);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean hasPessoaEleitora = this.getPessoasEleitoras().stream()
        .anyMatch(eleitor -> cpf.equals(eleitor.getCpf()));

    if (hasPessoaEleitora) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora eleitor = new PessoaEleitora(nome, cpf);
      this.pessoasEleitoras.add(eleitor);
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean isPessoaEleitoraVoted = this.getCpfsComputados().stream()
        .anyMatch(cpfPessoaEleitora::equals);

    if (isPessoaEleitoraVoted) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata candidato : getPessoasCandidatas()) {
        if (candidato.getNumero() == numeroPessoaCandidata) {
          candidato.receberVoto();
          this.cpfsComputados.add(cpfPessoaEleitora);
        }
      }
    }
  }

  @Override
  public void mostrarResultado() {
    boolean isEmptyVotes = this.getCpfsComputados().isEmpty();

    if (isEmptyVotes) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      int totalVotes = this.pessoasCandidatas.stream().mapToInt(PessoaCandidata::getVotos).sum();
      for (PessoaCandidata candidato : this.getPessoasCandidatas()) {
        int porcentagem = (int) Math.round((double) candidato.getVotos() / totalVotes * 100);
        System.out.printf("Nome: %s - %d votos ( %d%% )\n",
            candidato.getNome(),
            candidato.getVotos(),
            porcentagem
        );
      }
      System.out.println("Total de votos: " + totalVotes);
    }
  }
}
