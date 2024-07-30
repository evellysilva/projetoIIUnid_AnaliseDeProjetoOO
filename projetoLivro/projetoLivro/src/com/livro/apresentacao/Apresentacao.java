package com.livro.apresentacao;

import java.util.List;
import java.util.Scanner;

import com.livro.Livro;
import com.livro.persistencia.LivroDAO;

public class Apresentacao {
	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Livros");
            System.out.println("2. Listar Livros");
            System.out.println("3. Atualizar Livros");
            System.out.println("4. Remover Livros");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    atualizarLivro();
                    break;
                case 4:
                    removerLivro();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarLivro() {
        System.out.println("Adicionar Livro:");
        System.out.print("ID_ISBN: ");
        int id_ISBN = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        scanner.nextLine(); 

        Livro livro = new Livro(id_ISBN, titulo, editora, autor);
        LivroDAO.getInstance().adicionarLivro(livro);
        System.out.println("Livro adicionado com sucesso.");
    }

    private static void listarLivros() {
        System.out.println("Listar Livros:");
        List<Livro> livros = LivroDAO.getInstance().listarLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livroo encontrado.");
        } 
        
        else {
        	for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    private static void atualizarLivro() {
        System.out.println("Atualizar Livro:");
        System.out.print("ID_ISBN do Livro a ser atualizado: ");
        int id_ISBN = scanner.nextInt();
        scanner.nextLine();  

        Livro livro = LivroDAO.getInstance().encontrarLivroPorId_ISBN(id_ISBN);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        System.out.print("Novo titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Novo editora: ");
        String editora = scanner.nextLine();
        System.out.print("Novo autor: ");
        String autor = scanner.nextLine();
        scanner.nextLine(); 

        livro.setTitulo(titulo);
        livro.setEditora(editora);
        livro.setAutor(autor);
        LivroDAO.getInstance().atualizarLivro(livro);
        System.out.println("Llivro atualizado com sucesso.");
    }

    private static void removerLivro() {
        System.out.println("Remover livroo:");
        System.out.print("ID_ISBN do livro a ser removido: ");
        int id_ISBN = scanner.nextInt();
        scanner.nextLine();  

        Livro livro = LivroDAO.getInstance().encontrarLivroPorId_ISBN(id_ISBN);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        LivroDAO.getInstance().removerLivro(id_ISBN);
        System.out.println("Livro removido com sucesso.");
    }
}

