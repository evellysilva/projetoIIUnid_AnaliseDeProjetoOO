package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;

public class PacoteDebutante extends SalaoDecorator  {
    public PacoteDebutante(Servico servico) {
        super(servico);
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 200.00;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Pacote Debutante";
    }

    @Override
    public String toString() {
        return "Pacote Debutante: " + super.toString() + " - Preço atualizado: " + this.getPreco();
    }
}
