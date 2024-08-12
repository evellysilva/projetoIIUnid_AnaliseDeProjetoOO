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
                    atualizarServico(scanner, controlador);
                    break;
                case 3:
                    removerServico(scanner, controlador);
                    break;
                case 4:
                    buscarServico(scanner, controlador);
                    break;
                case 5:
                    listarTodosServicos(controlador);
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
		try {
            System.out.println("Digite o codigo de identificação do serviço:");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Digite o nome do serviço:");
            String nome = scanner.nextLine();

            System.out.println("Informe a descrição do serviço:");
            String descricao = scanner.nextLine();

            System.out.println("Digite o preço do serviço:");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Escolha o tipo de pacote:");
            System.out.println("1. Pacote Noiva");
            System.out.println("2. Pacote Debutante");
            System.out.println("3. Nenhum");

            int tipoPacote = scanner.nextInt();
            scanner.nextLine(); 

            Servico servico = new Servico(id, nome, preco, descricao);

            switch (tipoPacote) {
                case 1:
                    servico = new PacoteNoiva(servico);
                    break;
                case 2:
                    servico = new PacoteDebutante(servico);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida. Criando serviço básico.");
            }

            controlador.criarServico(servico);
            System.out.println("Serviço criado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar serviço: " + e.getMessage());
        }
		
	}
    private static void atualizarServico(Scanner scanner, SalaoControlador controlador) {
        System.out.println("Digite o código de identificação do serviço que deseja atualizar:");
	        int id = scanner.nextInt();
	        scanner.nextLine(); 

	        Servico servico = controlador.buscarServico(id);
	        if (servico == null) {
	            System.out.println("Serviço não encontrado.");
	            return;
	        }

	        System.out.println("Digite o novo nome do serviço:");
	        String nome = scanner.nextLine();

	        System.out.println("Digite a nova descrição do serviço:");
	        String descricao = scanner.nextLine();

	        System.out.println("Digite o novo preço do serviço:");
	        double preco = scanner.nextDouble();
	        scanner.nextLine();

	        servico.setNome(nome);
	        servico.setPreco(preco);
            servico.setDescricao(descricao);

	        controlador.atualizarServico(servico);
	        System.out.println("Serviço atualizado com sucesso!");
        
    }

	private static void removerServico(Scanner scanner, SalaoControlador controlador) {
		System.out.println("Digite o ID do serviço que deseja remover:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Servico servico = controlador.buscarServico(id);
        if (servico == null) {
            System.out.println("Serviço não encontrado.");
            return;
        }

        controlador.removerServico(servico);
        System.out.println("Serviço removido com sucesso!");
    }

	private static void buscarServico(Scanner scanner, SalaoControlador controlador) {
		System.out.println("Digite o codigo de identificação do serviço que deseja buscar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Servico servico = controlador.buscarServico(id);
        if (servico != null) {
            System.out.println("Serviço encontrado:");
            System.out.println("ID: " + servico.getId());
            System.out.println("Nome: " + servico.getNome());
            System.out.println("Preço: " + servico.getPreco());
            System.out.println("Descrição: " + servico.getDescricao());
        } else {
            System.out.println("Serviço não encontrado.");
        }
	}

	private static void listarTodosServicos(SalaoControlador controlador) {
		List<Servico> servicos = controlador.listarTodosServicos();
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço encontrado.");
        } else {
            System.out.println("Lista de serviços:");
            for (Servico servico : servicos) {
                System.out.println("ID: " + servico.getId());
                System.out.println("Nome: " + servico.getNome());
                System.out.println("Preço: " + servico.getPreco());
                System.out.println("Descrição: " + servico.getDescricao());
                System.out.println("------------------------");
            }
        }
      }
		
	}

    
    }

