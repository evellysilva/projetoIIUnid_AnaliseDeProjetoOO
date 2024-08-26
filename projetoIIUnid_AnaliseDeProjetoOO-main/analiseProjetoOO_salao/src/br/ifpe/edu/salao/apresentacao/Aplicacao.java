package br.ifpe.edu.salao.apresentacao;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.negocio.DAOFactory;
import br.ifpe.edu.salao.negocio.PacoteDebutante;
import br.ifpe.edu.salao.negocio.PacoteNoiva;
import br.ifpe.edu.salao.negocio.IServicoAdapter;
import br.ifpe.edu.salao.negocio.ServicoAdapter;

public class Aplicacao {

    private static Scanner scanner;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void iniciar() {
        scanner = new Scanner(System.in);
        DAOFactory factory = DAOFactory.getInstance();

        SalaoControlador controlador = new SalaoControlador(factory.criarDAO());

        boolean running = true;

        while (running) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Serviço");
            System.out.println("2. Atualizar Serviço");
            System.out.println("3. Remover Serviço");
            System.out.println("4. Buscar Serviço por ID");
            System.out.println("5. Listar Todos os Serviços");
            System.out.println("6. Sair");
            int opcao = obterInteiro("Escolha uma opção:");
            if (opcao == -1) continue; // Se a opção for inválida, repete o loop
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
                    System.out.println("Agradecemos sua visita! Espero que tenha gostado!");

                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static int obterInteiro(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine(); // Usa nextLine para capturar a entrada como uma String
                return Integer.parseInt(input); // Converte a String para inteiro            
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }
    }

    private static double obterDouble(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine(); // Usa nextLine para capturar a entrada como uma String
                return Double.parseDouble(input); // Converte a String para double
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número decimal.");
            }
        }
    }

    private static String obterRespostaValida(String prompt) {
        while (true) {
            System.out.println(prompt);
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("s") || resposta.equals("n")) {
                return resposta;
            }
            System.out.println("Resposta inválida. Por favor, insira 's' para sim ou 'n' para não.");
        }
    }

    private static void criarServico(Scanner scanner, SalaoControlador controlador) {
    	 try {
             int id = obterInteiro("Digite o código de identificação do serviço:");
             if (controlador.buscarServico(id) != null) {
                 System.out.println("Erro ao criar serviço: Já existe um serviço com esse ID.");
                 return;
             }

             System.out.println("Digite o nome do serviço:");
             String nome = scanner.nextLine();
             System.out.println("Informe a descrição do serviço:");
             String descricao = scanner.nextLine();
             double preco = obterDouble("Digite o preço do serviço:");

             System.out.println("Escolha o tipo de pacote:");
             System.out.println("1 para Pacote de Noiva");
             System.out.println("2 para Pacote de Debutante");
             System.out.println("3 para Nenhum (serviço básico)");
             int tipoPacote = obterInteiro("Escolha o tipo de pacote:");

             Servico servico = new Servico(id, nome, preco, descricao);

             switch (tipoPacote) {
                 case 1:
                     servico = new PacoteNoiva(servico);
                     break;
                 case 2:
                     servico = new PacoteDebutante(servico);
                     break;
                 case 3:
                     // Mantém o serviço básico, sem pacote
                     break;
                 default:
                     System.out.println("Opção inválida. Criando serviço básico.");
             }

             controlador.criarServico(servico);
             System.out.println("Serviço criado com sucesso.");

         } catch (IllegalArgumentException e) {
             System.out.println("Erro ao criar serviço: " + e.getMessage());
         }
     }


    private static void atualizarServico(Scanner scanner, SalaoControlador controlador) {
    	 int id = obterInteiro("Digite o código de identificação do serviço que deseja atualizar:");
    	    Servico servico = controlador.buscarServico(id);
    	    if (servico == null) {
    	        System.out.println("Serviço não encontrado.");
    	        return;
    	    }

    	    // Guarda o pacote atual para possível remoção
    	    Servico pacoteAntigo = servico;

    	    System.out.println("Digite o novo nome do serviço:");
    	    String nome = scanner.nextLine();
    	    System.out.println("Digite a nova descrição do serviço:");
    	    String descricao = scanner.nextLine();
    	    double preco = obterDouble("Digite o novo preço do serviço:");

    	    // Pergunta ao usuário se deseja usar o mesmo pacote ou selecionar outro
    	    String manterPacote = obterRespostaValida("Deseja manter o pacote atual? (s/n):");

    	    if (manterPacote.equalsIgnoreCase("n")) {
    	        System.out.println("Escolha o novo tipo de pacote:");
    	        System.out.println("1 para Pacote de Noiva");
    	        System.out.println("2 para Pacote de Debutante");
    	        System.out.println("3 para Nenhum (serviço básico)");
    	        int tipoPacote = obterInteiro("Escolha o tipo de pacote:");

    	        // Remove o pacote antigo
    	        servico = new Servico(id, nome, preco, descricao); // Cria um novo serviço básico

    	        switch (tipoPacote) {
    	            case 1:
    	                servico = new PacoteNoiva(servico);
    	                break;
    	            case 2:
    	                servico = new PacoteDebutante(servico);
    	                break;
    	            case 3:
    	                // Mantém o serviço básico, sem pacote
    	                break;
    	            default:
    	                System.out.println("Opção inválida. Mantendo o serviço básico.");
    	        }
    	    } else {
    	        // Se manter o pacote, atualiza os detalhes, mas mantém o pacote atual
    	        servico.setNome(nome);
    	        servico.setPreco(preco);
    	        servico.setDescricao(descricao);
    	    }

    	    // Atualiza o serviço no controlador
    	    controlador.atualizarServico(servico);

    	    // Mensagem de sucesso
    	    System.out.println("Serviço atualizado com sucesso!");
    	}
    private static void removerServico(Scanner scanner, SalaoControlador controlador) {
        try {
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

        } catch (Exception e) {
            System.out.println("Erro ao remover serviço: " + e.getMessage());
            scanner.nextLine(); // Limpa o buffer
        }
    }

    private static void buscarServico(Scanner scanner, SalaoControlador controlador) {
        int id = obterInteiro("Digite o código de identificação do serviço que deseja buscar:");
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
    	        // Pergunta se o pagamento será em dólares
    	        String pagamentoEmDolares = obterRespostaValida("O pagamento será em dólares? (s/n):");
    	        boolean emDolares = pagamentoEmDolares.equalsIgnoreCase("s");

    	        // Cria o adaptador de serviço
    	        IServicoAdapter servicoAdapter = new ServicoAdapter();
    	        DecimalFormat df = new DecimalFormat("#.00");

    	        System.out.println("Lista de serviços:");
    	        for (Servico servico : servicos) {
    	            double preco = servico.getPreco();
    	            if (emDolares) {
    	                // Converte o preço para dólares se necessário
    	                preco = servicoAdapter.getPrecoEmDolar(preco);
    	            }
    	            String precoFormatado = df.format(preco);

    	            System.out.println("ID: " + servico.getId());
    	            System.out.println("Nome: " + servico.getNome());
    	            System.out.println("Preço: " + (emDolares ? "$ " : "R$ ") + precoFormatado);
    	            System.out.println("Descrição: " + servico.getDescricao());
    	            System.out.println("------------------------");
    	        }
    	    }
    	}
    }