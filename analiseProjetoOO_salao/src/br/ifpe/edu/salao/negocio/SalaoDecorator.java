package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;

public class SalaoDecorator extends Servico {
    protected Servico servico;

    public SalaoDecorator(Servico servico) {
        super(servico.getId(), servico.getNome(), servico.getPreco(), servico.getDescricao());
        this.servico = servico;
    }

    @Override
    public int getId() {
        return servico.getId();
    }
    
    @Override
    public double getPreco() {
        return servico.getPreco();
    }

    @Override
    public String getDescricao() {
        return servico.getDescricao();
    }
}
