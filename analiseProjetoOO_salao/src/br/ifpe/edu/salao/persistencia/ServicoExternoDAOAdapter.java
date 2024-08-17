package br.ifpe.edu.salao.persistencia;

import java.util.List;

import br.ifpe.edu.salao.Servico;

public class ServicoExternoDAOAdapter implements GenericDAO<Servico> {
    private GenericDAO<Servico> servicoDAO;
    private ServicoExterno servicoExterno;

    public ServicoExternoDAOAdapter(GenericDAO<Servico> servicoDAO, ServicoExterno servicoExterno) {
        this.servicoDAO = servicoDAO;
        this.servicoExterno = servicoExterno;
    }

    @Override
    public void criar(Servico servico) {
        Servico servicoAdaptado = new Servico(servico.getId(), servico.getNome(),
                servico.getPreco() + servicoExterno.custoAdicional(),
                servico.getDescricao() + " + " + servicoExterno.descricaoAdicional());
        servicoDAO.criar(servicoAdaptado);
    }

    @Override
    public void atualizar(Servico servico) {
        Servico servicoAdaptado = new Servico(servico.getId(), servico.getNome(),
                servico.getPreco() + servicoExterno.custoAdicional(),
                servico.getDescricao() + " + " + servicoExterno.descricaoAdicional());
        servicoDAO.atualizar(servicoAdaptado);
    }

    @Override
    public void deletar(Servico servico) {
        Servico servicoAdaptado = new Servico(servico.getId(), servico.getNome(),
                servico.getPreco() + servicoExterno.custoAdicional(),
                servico.getDescricao() + " + " + servicoExterno.descricaoAdicional());
        servicoDAO.deletar(servicoAdaptado);
    }

    @Override
    public Servico buscar(int id) {
        Servico servico = servicoDAO.buscar(id);
        if (servico != null) {
            return new Servico(servico.getId(), servico.getNome(),
                    servico.getPreco() + servicoExterno.custoAdicional(),
                    servico.getDescricao() + " + " + servicoExterno.descricaoAdicional());
        }
        return null;
    }

    @Override
    public List<Servico> listarTudo() {
        List<Servico> servicos = servicoDAO.listarTudo();
        for (int i = 0; i < servicos.size(); i++) {
            Servico servico = servicos.get(i);
            servicos.set(i, new Servico(servico.getId(), servico.getNome(),
                    servico.getPreco() + servicoExterno.custoAdicional(),
                    servico.getDescricao() + " + " + servicoExterno.descricaoAdicional()));
        }
        return servicos;
    }

}
