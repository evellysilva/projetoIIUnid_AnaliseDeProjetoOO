package br.ifpe.edu.salao.apresentacao;

import java.util.List;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.persistencia.GenericDAO;


public class SalaoControlador {
    // Instância do DAO genérico para manipulação de objetos Servico
    private GenericDAO<Servico> servicoDAO;
    
    // Construtor da classe SalaoControlador
    // Recebe um DAO genérico como parâmetro para realizar operações sobre serviços
    public SalaoControlador(GenericDAO<Servico> servicoDAO) {
        this.servicoDAO = servicoDAO;
    }
    
    public void criarServico(Servico servico) {
        servicoDAO.criar(servico);
    }

    public void atualizarServico(Servico servico) {
        servicoDAO.atualizar(servico);
    }

    public void removerServico(Servico servico) {
        servicoDAO.deletar(servico);
    }

    public Servico buscarServico(int id) {
        return servicoDAO.buscar(id);
    }

    public List<Servico> listarTodosServicos() {
        return servicoDAO.listarTudo();
    }
}
