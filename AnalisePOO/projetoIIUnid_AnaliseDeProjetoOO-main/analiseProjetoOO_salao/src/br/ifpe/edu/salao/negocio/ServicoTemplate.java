package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;

public abstract class ServicoTemplate {
	// Template method
    public final void processarServico(int id, String nome, double preco, String descricao, int tipoPacote) {
        validarDados(id, nome, preco, descricao);
        Servico servico = criarServico(id, nome, preco, descricao);
        aplicarPacote(servico, tipoPacote);
        salvarServico(servico);
    }

    // Passos do algoritmo que podem ser personalizados pelas subclasses
    protected abstract void validarDados(int id, String nome, double preco, String descricao);

    protected abstract Servico criarServico(int id, String nome, double preco, String descricao);

    protected void aplicarPacote(Servico servico, int tipoPacote) {
        switch (tipoPacote) {
            case 1:
                servico = new PacoteNoiva(servico);
                break;
            case 2:
                servico = new PacoteDebutante(servico);
                break;
            default:
                break;  // Nenhum pacote adicional
        }
    }

    protected abstract void salvarServico(Servico servico);
}

