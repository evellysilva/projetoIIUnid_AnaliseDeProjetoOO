package br.ifpe.edu.salao.persistencia;
//Interface ServicoExterno define o contrato para serviços externos que podem ser adaptados para adicionar funcionalidades adicionais a um serviço principal.
public interface ServicoExterno {
	 double custoAdicional();
	 String descricaoAdicional();
}
