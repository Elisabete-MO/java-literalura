package edu.LiterAlura.controllers;

import edu.LiterAlura.models.records.Book;
import edu.LiterAlura.models.records.Books;
import edu.LiterAlura.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class PrincipalController {
    private final BooksService booksService;
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public PrincipalController(BooksService booksService) {
        this.booksService = booksService;
    }

    public void showMenu() {
        System.out.println("********************************");
        System.out.println("Bem vindo ao sistema de consulta de livros!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Buscar livros pelo título ou autor");
        System.out.println("2 - Buscar livros pelo Id");
        System.out.println("3 - Listar livros salvos");
        System.out.println("4 - Listar autores salvos");
        System.out.println("5 - Listar autores vivos em determinado ano");
        System.out.println("6 - Listar livros em determinado idioma");
        System.out.println("0 - Sair");


        String opt = scanner.nextLine();

        switch (opt) {
            case "1":
                getAuthorNameOrTitle();
                break;
            case "2":
                getDataByBookId();
                break;
            case "3":
                System.out.println("And I have nothing....");
                break;
            case "0":
                System.out.println("Saindo do sistema");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida");
                showMenu();
                break;
        }
    }

    public void getAuthorNameOrTitle() {
        System.out.println("Digite o nome do autor ou título do livro:");
        String nameOrTitle = scanner.nextLine();
        Books books = booksService.getAllMediaDataByName(nameOrTitle);
        showBooks(books, nameOrTitle);
        getDataByBookId();
    }

    public void getDataByBookId() {
        System.out.println("Digite o ID do livro:");
        String id = scanner.nextLine();
        Book book = booksService.getMediaDataById(id);
        System.out.println(book);
    }

    public void showBooks(Books books, String nameOrTitle) {
        System.out.println("** Foram encontrados " + books.count() + " livros" +
                " " +
                "como resultado da busca por '" + nameOrTitle + "':" + "\n");
        books.books().forEach(System.out::println);
    }


}