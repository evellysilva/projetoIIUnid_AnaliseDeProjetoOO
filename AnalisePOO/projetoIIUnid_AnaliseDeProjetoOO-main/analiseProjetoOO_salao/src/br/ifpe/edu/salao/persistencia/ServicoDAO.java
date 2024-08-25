package br.ifpe.edu.salao.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.ifpe.edu.salao.Servico;


//Implementação da interface GenericDAO para a classe Servico
public class ServicoDAO implements GenericDAO<Servico> {
    // Lista interna para armazenar os serviços em memória
    private List<Servico> servicos = new ArrayList<>();

    @Override
    public void criar(Servico servico) {
        if (buscar(servico.getId()) != null) {
            throw new IllegalArgumentException("Já existe um serviço com esse ID.");
        }
        servicos.add(servico);
    }

    @Override
    public void atualizar(Servico servico) {
        for (int i = 0; i < servicos.size(); i++) {
            if (servicos.get(i).getId() == servico.getId()) {
                servicos.set(i, servico);
                return;
            }
        }
    }

    @Override
    public void deletar(Servico servico) {
        servicos.removeIf(s -> s.getId() == servico.getId());
    }

    @Override
    public Servico buscar(int id) {
        return servicos.stream().filter(s -> s.getId() == id).findFirst().orElse(null);

    }

    @Override
    public List<Servico> listarTudo() {
        return new ArrayList<>(servicos);
    }
}
