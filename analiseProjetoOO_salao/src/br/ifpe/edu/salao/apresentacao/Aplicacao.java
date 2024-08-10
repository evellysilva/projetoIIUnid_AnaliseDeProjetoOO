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
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Serviço");
            System.out.println("2. Atualizar Serviço");
            System.out.println("3. Remover Serviço");
            System.out.println("4. Buscar Serviço por ID");
            System.out.println("5. Listar Todos os Serviços");
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
                    System.out.println("Opção inválida. Tente novamente.");
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

