package br.ifpe.edu.salao.apresentacao;

import java.util.List;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.persistencia.ServicoDAO;
import br.ifpe.edu.salao.persistencia.GenericDAO;
import br.ifpe.edu.salao.negocio.PacoteNoiva;
import br.ifpe.edu.salao.negocio.PacoteDebutante;

public class SalaoFacade {
    // Instância única do facade, implementando o padrão Singleton
	 private static SalaoFacade instance;
	    // DAO genérico para manipulação de objetos Servico
	    private GenericDAO<Servico> servicoDAO;
	    
	    // Construtor privado para evitar a criação de múltiplas instâncias
	    private SalaoFacade() {
	        servicoDAO = new ServicoDAO(); // Inicializa o DAO para serviços
	    }
	    
	    // Método para obter a instância única do SalaoFacade (padrão Singleton)
	    public static synchronized SalaoFacade getInstance() {
	        if (instance == null) {
	            instance = new SalaoFacade();// Cria uma nova instância se não existir
	        }
	        return instance; // Retorna a instância existente
	    }

	    public void criarServico(Servico servico) {
	        servicoDAO.criar(servico);
	    }

	    public void atualizarServico(Servico servico) {
	        servicoDAO.atualizar(servico);
	    }

	    public void deletarServico(int id) {
	        Servico servico = servicoDAO.buscar(id);
	        if (servico != null) {
	            servicoDAO.deletar(servico);
	        }
	    }

	    public Servico buscarServico(int id) {
	        return servicoDAO.buscar(id);
	    }

	    public void aplicarPacoteNoiva(int id) {
	        Servico servico = servicoDAO.buscar(id);
	        if (servico != null) {
	            servico = new PacoteNoiva(servico);
	            servicoDAO.atualizar(servico);
	        }
	    }

	    public void aplicarPacoteDebutante(int id) {
	        Servico servico = servicoDAO.buscar(id);
	        if (servico != null) {
	            servico = new PacoteDebutante(servico);
	            servicoDAO.atualizar(servico);
	        }
	    }

	    public List<Servico> listarServicos() {
	        return servicoDAO.listarTudo();
	    }
	}