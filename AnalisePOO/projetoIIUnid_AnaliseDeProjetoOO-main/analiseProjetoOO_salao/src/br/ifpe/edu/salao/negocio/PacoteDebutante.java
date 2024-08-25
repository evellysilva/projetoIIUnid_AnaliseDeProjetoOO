package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;

public class PacoteDebutante extends SalaoDecorator  {
    // Construtor que recebe um objeto Servico
    public PacoteDebutante(Servico servico) {
        super(servico);// Passa o objeto Servico para o construtor da classe base
    }
    
    @Override
    public double getPreco() {
        return super.getPreco() + 200.00;
    }
    
    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Pacote Debutante";
    }
}
