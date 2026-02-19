package com.betrybe.sistemadevotacao;

/**
 * Classe abstrata que serve como base para todos os participantes do
 * sistema de votação.
 *
 * <p>
 *  Esta classe define a estrutura comum de identificação para os diferentes papéis
 *  no processo eleitoral, sendo herdada por candidatos e eleitores. Por ser abstrata,
 *  não permite instanciamento direto, funcionando estritamente como um molde.
 * </p>
 *
 * @author Danilo
 * */
public abstract class Pessoa {
  protected String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
