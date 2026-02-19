package com.betrybe.sistemadevotacao;

/**
 * Representa uma pessoa que concorre a um cargo no sistema de votação.
 * <p>
 *  Esta classe estende a base comum {@link Pessoa}, adicionando propriedades
 *  específicas para a candidatura, como o número identificador e a contagem
 *  acumulada de votos recebidos.
 * </p>
 *
 * @author Danilo
 * @see Pessoa
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Inicializa uma nova instância de uma pessoa candidata com nome e número identificador.
   * <p>
   *  O total de votos é iniciado automaticamente com o valor zero no momento da criação.
   * </p>
   *
   * @param nome O nome da pessoa candidata.
   * @param numero O número de registro do candidato para votação.
   */
  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
