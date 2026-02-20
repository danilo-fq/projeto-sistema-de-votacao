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

  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {

  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  @Override
  public void mostrarResultado() {

  }
}
