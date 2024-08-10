package br.ifpe.edu.salao.apresentacao;

import java.util.Scanner;

import br.ifpe.edu.salao.negocio.DAOFactory;

public class Aplicacao {
    public static void iniciar() {
    	DAOFactory factory = DAOFactory.getInstance();
        SalaoControlador controlador = new SalaoControlador(factory.criarDAO());
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Escolha uma op��o:");
            System.out.println("1. Criar Servi�o");
            System.out.println("2. Atualizar Servi�o");
            System.out.println("3. Remover Servi�o");
            System.out.println("4. Buscar Servi�o por ID");
            System.out.println("5. Listar Todos os Servi�os");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarServico(scanner, controlador);
                    break;
                case 2:
                    buscarServico(scanner, controlador);
                    break;
                case 3:
                    removerServico(scanner, controlador);
                    break;
                case 4:
                    buscarServico(scanner, controlador);
                    break;
                case 5:
                    listarServicos(controlador);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
            }
        }

        scanner.close();
    }

	private static void criarServico(Scanner scanner, SalaoControlador controlador) {
		// TODO Auto-generated method stub
		
	}

	private static void removerServico(Scanner scanner, SalaoControlador controlador) {
		// TODO Auto-generated method stub
		
	}

	private static void buscarServico(Scanner scanner, SalaoControlador controlador) {
		// TODO Auto-generated method stub
		
	}

	private static void listarServicos(SalaoControlador controlador) {
		// TODO Auto-generated method stub
		
	}

    
    }

