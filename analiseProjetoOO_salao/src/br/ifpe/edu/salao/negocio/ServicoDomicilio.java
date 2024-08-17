package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.persistencia.ServicoExterno;

public class ServicoDomicilio implements ServicoExterno {
    @Override
    public double custoAdicional() {
        return 50.00;
    }

    @Override
    public String descricaoAdicional() {
        return "Serviço a Domicílio";
    }
}