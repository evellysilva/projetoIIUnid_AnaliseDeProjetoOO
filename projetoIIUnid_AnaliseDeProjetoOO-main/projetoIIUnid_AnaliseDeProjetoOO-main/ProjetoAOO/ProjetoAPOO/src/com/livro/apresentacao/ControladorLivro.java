package com.livro.apresentacao;

import java.util.List;
import java.util.Scanner;

import com.livro.Livro;
import com.negocio.LivroService;

public class ControladorLivro {
	private LivroService livroService;
    private Scanner scanner;

    public ControladorLivro(LivroService livroService) {
        this.livroService = livroService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\n1. Adicionar Livro");
            System.out.println("2. Ver Livro");
            System.out.println("3. Ver Todos os Livros");
            System.out.println("4. Atualizar Livro");
            System.out.println("5. Deletar Livro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (choice) {
                case 1:
                    addLivro();
                    break;
                case 2:
                    viewLivro();
                    break;
                case 3:
                    viewTodosLivros();
                    break;
                case 4:
                    updateLivro();
                    break;
                case 5:
                    deleteLivro();
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

    private void addLivro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Editora: ");
        String ediotora = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        livroService.addLivro(titulo, autor, editora, preco);
        System.out.println("Livro adicionado com sucesso!");
    }

    private void viewLivro() {
        System.out.print("ID do livro: ");
        int id = scanner.nextInt();
        Livro livro = livroService.getLivro(id);
        if (livro != null) {
            System.out.println("Livro encontrado: " + livro.getTitulo() + ", " + livro.getAutor() + ", " + livro.getEditora() + ", " + livro.getPreco());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void viewTodosLivros() {
        List<Livro> livros = livroService.getTodosLivros();
        for (Livro livro : livros) {
            System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", Editora: " + livro.getEditora() + ", Preço: " + livro.getPreco());
        }
    }

    private void updateLivro() {
        System.out.print("ID do livro: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha
        System.out.print("Novo Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Novo Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Nova Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Novo Preço: ");
        double preco = scanner.nextDouble();

        livroService.updateLivro(id, titulo, autor, editora, preco);
        System.out.println("Livro atualizado com sucesso!");
    }

    private void deleteLivro() {
        System.out.print("ID do livro: ");
        int id = scanner.nextInt();
        livroService.deleteLivro(id);
        System.out.println("Livro deletado com sucesso!");
    }
}
