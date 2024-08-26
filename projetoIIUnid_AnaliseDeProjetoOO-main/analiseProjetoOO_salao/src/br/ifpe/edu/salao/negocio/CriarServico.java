package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.persistencia.GenericDAO;

public class CriarServico extends ServicoTemplate {

    // DAO utilizado para realizar operações de acesso a dados de Servico
    private GenericDAO<Servico> servicoDAO;
    // Construtor que recebe o DAO para realizar operações de criação

    public CriarServico(GenericDAO<Servico> servicoDAO) {
        this.servicoDAO = servicoDAO;
    }

    @Override
    protected void validarDados(int id, String nome, double preco, String descricao) {
        if (id <= 0 || nome == null || nome.isEmpty() || preco <= 0) {
            throw new IllegalArgumentException("Dados inválidos.");
        }
    }

    @Override
    protected Servico criarServico(int id, String nome, double preco, String descricao) {
        return new Servico(id, nome, preco, descricao);
    }

    @Override
    protected void salvarServico(Servico servico) {
        servicoDAO.criar(servico);
    }
}
