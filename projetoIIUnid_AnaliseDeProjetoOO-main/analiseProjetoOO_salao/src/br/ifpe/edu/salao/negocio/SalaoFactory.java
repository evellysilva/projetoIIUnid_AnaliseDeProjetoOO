package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;
//Classe SalaoFactory que fornece métodos para criar instâncias de Servico

public class SalaoFactory {

    // Método estático para criar uma nova instância de Servico
    public static Servico criarServico(int id, String nome, double preco, String descricao) {
        return new Servico(id, nome, preco, descricao);
    }
}
