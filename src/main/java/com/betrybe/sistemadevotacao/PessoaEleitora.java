package com.betrybe.sistemadevotacao;

/**
 * Representa uma pessoa apta a exercer o direito de voto no sistema.
 * <p>
 *  Esta classe estende a base comum {@link Pessoa}, adicionando um atributo
 *  {@code cpf} para identificação única da pessoa eleitora.
 * </p>
 *
 * @author Danilo
 * @see Pessoa
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  /**
   * Inicializa uma nova instância de uma pessoa eleitora com nome e CPF.
   *
   * @param nome O nome completo da pessoa eleitora.
   * @param cpf O CPF da pessoa eleitora para validação de voto.
   */
  public PessoaEleitora(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
