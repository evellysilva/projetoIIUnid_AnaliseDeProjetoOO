package br.ifpe.edu.salao.persistencia;

import br.ifpe.edu.salao.Servico;

public class ServicoBuilder {
	private String nome;
    private double preco;
    private String descricao;

    public ServicoBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ServicoBuilder setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public ServicoBuilder setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Servico build() {
        return new Servico(nome, preco, descricao);
    }
}
