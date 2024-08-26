package br.ifpe.edu.salao;

import java.text.DecimalFormat;

import br.ifpe.edu.salao.negocio.IServicoAdapter;
import br.ifpe.edu.salao.negocio.ServicoAdapter;

public class Servico{

    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private IServicoAdapter precoAdapter = new ServicoAdapter();

    // Construtor da classe Servico
    public Servico(int id, String nome, double preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    // Getters e Setters para os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public IServicoAdapter getPrecoAdapter() {
        return precoAdapter;
    }
    

    // Representação em String do objeto Servico
    @Override
    public String toString() {
    DecimalFormat df = new DecimalFormat("#.00");
        return "ID: " + id +
        ", Nome: " + nome +
        ", Preço: R$ " + df.format(preco) +
        ", Preço em dólar: $ " + df.format(precoAdapter.getPrecoEmDolar(preco)) +
        ", Descrição: " + descricao;
    }

}
