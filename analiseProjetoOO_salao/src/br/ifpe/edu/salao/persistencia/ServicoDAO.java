package br.ifpe.edu.salao.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.ifpe.edu.salao.Servico;



public class ServicoDAO implements GenericDAO<Servico> {
    private List<Servico> servicos = new ArrayList<>();

    @Override
    public void criar(Servico servico) {
        servicos.add(servico);
    }

    @Override
    public void atualizar(Servico servico) {
        int index = servicos.indexOf(servico);
        if (index != -1) {
            servicos.set(index, servico);
        }
    }

    @Override
    public void deletar(Servico servico) {
        servicos.remove(servico);
    }

    @Override
    public Servico buscar(int id) {
        return servicos.get(id);
    }

    @Override
    public List<Servico> listarTudo() {
        return servicos;
    }
}
