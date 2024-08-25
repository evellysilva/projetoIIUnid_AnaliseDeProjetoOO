package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;

public class SalaoDecorator extends Servico {
    // Objeto Servico que será decorado
    protected Servico servico;

    public SalaoDecorator(Servico servico) {
        super(servico.getId(), servico.getNome(), servico.getPreco(), servico.getDescricao());
        this.servico = servico;
    }

    @Override
    public double getPreco() {
        return servico.getPreco();
    }

    @Override
    public String getDescricao() {
        return servico.getDescricao();
    }
    // Sobrescrita do método toString para fornecer uma representação textual do serviço
    @Override
    public String toString() {
        // Retorna uma string que inclui o ID, nome, preço base e descrição do serviço
        return "ID: " + getId() + ", Nome: " + getNome() + 
               ", Preço com Acréscimo: " + getPreco() + 
               ", Descrição: " + getDescricao();
    }
}
