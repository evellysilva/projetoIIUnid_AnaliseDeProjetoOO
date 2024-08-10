package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;

public class PacoteNoiva extends SalaoDecorator {
	public PacoteNoiva(Servico servico) {
        super(servico);
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 900.00;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Pacote Noiva";
    }

    @Override
    public String toString() {
        return "Pacote Noiva: " + super.toString() + " - Preço atualizado: " + this.getPreco();
    }
}
