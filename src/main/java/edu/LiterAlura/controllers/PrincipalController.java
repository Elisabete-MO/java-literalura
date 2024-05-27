package edu.LiterAlura.controllers;

import edu.LiterAlura.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class PrincipalController {
    private final BooksService booksService;
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public PrincipalController(BooksService booksService) {
        this.booksService = booksService;
    }

    public void showMenu() {

        System.out.println("Bem vindo ao sistema de cursos da Alura");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cursos");
        System.out.println("2 - Categorias");
        System.out.println("3 - Sair");

        String opt = scanner.nextLine();

        switch (opt) {
            case "1":
                booksService.getAllMediaDataByName("Java");
                break;
            case "2":
                System.out.println("Categorias");
                break;
            case "3":
                System.out.println("Saindo do sistema");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}