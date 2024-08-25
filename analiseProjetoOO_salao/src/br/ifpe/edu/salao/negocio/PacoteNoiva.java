package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;

public class PacoteNoiva extends SalaoDecorator {

    // Construtor que recebe um serviço e o inicializa na classe base
    public PacoteNoiva(Servico servico) {
        super(servico);// Inicializa o decorator com o serviço decorado
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 900.00;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Pacote Noiva";
    }
}
