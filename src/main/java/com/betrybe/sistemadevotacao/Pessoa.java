package com.betrybe.sistemadevotacao;

/**
 * Classe abstrata que serve como base para todos os participantes do
 * sistema de votação.
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
