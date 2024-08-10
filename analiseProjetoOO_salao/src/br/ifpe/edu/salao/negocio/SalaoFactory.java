package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;

public class SalaoFactory {
	public static Servico criarServico(String nome, double preco, String descricao) {
        return new Servico(nome, preco, descricao);
    }
}
