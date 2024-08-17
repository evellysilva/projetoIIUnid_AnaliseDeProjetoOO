package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.persistencia.ServicoExterno;

public class ServicoAdapter extends Servico {
    private ServicoExterno servicoExterno;

    public ServicoAdapter(Servico servico, ServicoExterno servicoExterno) {
        super(servico.getId(), servico.getNome(), servico.getPreco(), servico.getDescricao());
        this.servicoExterno = servicoExterno;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + " + servicoExterno.descricaoAdicional();
    }

    @Override
    public double getPreco() {
        return super.getPreco() + servicoExterno.custoAdicional();
    }

}
