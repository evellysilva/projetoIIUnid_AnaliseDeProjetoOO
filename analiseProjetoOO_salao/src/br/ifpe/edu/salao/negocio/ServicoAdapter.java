package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.IServico;
import br.ifpe.edu.salao.Servico;

public class ServicoAdapter implements IServico {
	private Servico servico;
    private boolean emDolares;
    private static final double taxa_conversao = 5.50; 
    
    public ServicoAdapter(Servico servico, boolean emDolares) {
        this.servico = servico;
        this.emDolares = emDolares;
    }

    @Override
    public double preco() {
        double precoEmReais = servico.getPreco();
        if (emDolares) {
            return precoEmReais / taxa_conversao;
        }
        return precoEmReais;
    }

    @Override
    public String getDescricao() {
        return servico.getDescricao();
    }
}
