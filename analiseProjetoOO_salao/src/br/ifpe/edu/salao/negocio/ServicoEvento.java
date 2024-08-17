package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.persistencia.ServicoExterno;

public class ServicoEvento implements ServicoExterno {
    @Override
    public double custoAdicional() {
        return 300.00;
    }

    @Override
    public String descricaoAdicional() {
        return "Serviço para um Evento";
    }

}
