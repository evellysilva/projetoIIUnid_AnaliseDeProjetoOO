package br.ifpe.edu.salao.apresentacao;

import java.util.List;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.persistencia.GenericDAO;

public class SalaoControlador {
    private GenericDAO<Servico> dao;

    public SalaoControlador(GenericDAO<Servico> dao) {
        this.dao = dao;
    }

    public void criarServico(Servico servico) {
        dao.criar(servico);
    }

    public void atualizarServico(Servico servico) {
        dao.atualizar(servico);
    }

    public void removerServico(Servico servico) {
        dao.deletar(servico);
    }

    public Servico buscarServico(int id) {
        return dao.buscar(id);
    }

    public List<Servico> listarTodosServicos() {
        return dao.listarTudo();
    }
}
