package br.ifpe.edu.salao.persistencia;

import br.ifpe.edu.salao.Servico;
//Classe para construir objetos Servico usando o padrão de projeto Builder
public class ServicoBuilder {
    private int id;
	private String nome;
    private double preco;
    private String descricao;

    public ServicoBuilder setId(int id) {
        this.id = id;
        return this;
    }

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
        return new Servico(id, nome, preco, descricao);
    }
}
