package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.persistencia.GenericDAO;

public class AtualizarServico extends ServicoTemplate{
    // DAO utilizado para realizar operações de acesso a dados de Servico
	  private GenericDAO<Servico> servicoDAO;
	    // Construtor que recebe o DAO para realizar operações de atualização
	    public AtualizarServico(GenericDAO<Servico> servicoDAO) {
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
        Servico servico = servicoDAO.buscar(id);
        if (servico == null) {
            throw new IllegalArgumentException("Serviço não encontrado.");
        }
        servico.setNome(nome);
        servico.setPreco(preco);
        servico.setDescricao(descricao);
        return servico;
    }
    @Override
    protected void salvarServico(Servico servico) {
        servicoDAO.atualizar(servico);
    }
}
