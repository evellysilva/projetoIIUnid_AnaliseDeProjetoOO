package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.persistencia.ServicoDAO;
import br.ifpe.edu.salao.persistencia.GenericDAO;

public class DAOFactory extends AbstractFactory {
	private static DAOFactory instancia;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        if (instancia == null) {
                if (instancia == null) {
                    instancia = new DAOFactory();
                }
        }
        return instancia;
    }

    @Override
    public GenericDAO<Servico> criarDAO() {
        return new ServicoDAO();
    }
}
