package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.persistencia.GenericDAO;
import br.ifpe.edu.salao.persistencia.ServicoDAO;

public class DAOFactory extends AbstractFactory {

    // Instância única da fábrica (Singleton)
    private static DAOFactory instancia;

    // Construtor privado para evitar instâncias externas
    private DAOFactory() {
    }

    // Método para obter a instância única da fábrica
    public static DAOFactory getInstance() {
        if (instancia == null) {
            if (instancia == null) {
                instancia = new DAOFactory();
            }
        }
        return instancia;
    }

    // Implementação do método para criar um DAO de Servico
    @Override
    public GenericDAO<Servico> criarDAO() {
        // Retorna uma nova instância de ServicoDAO
        return new ServicoDAO();
    }
}
