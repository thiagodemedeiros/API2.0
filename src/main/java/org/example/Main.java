package org.example;

import exercicio2.view.MenuConsole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                exibirMenu();

                System.out.print("Escolha uma opção: ");
                String opcao = scanner.nextLine().trim();

                System.out.println();

                if (processarOpcao(opcao)) {
                    break;
                }

                System.out.println();
                System.out.println("Pressione ENTER para continuar...");
                scanner.nextLine();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("===========================================");
        System.out.println("    PROJETOS DE API - ADA");
        System.out.println("===========================================");
        System.out.println();
        System.out.println("Escolha qual exercício executar:");
        System.out.println();
        System.out.println("1 - Exercício 1: Consulta CEP (ViaCEP)");
        System.out.println("2 - Exercício 2: Catálogo & Tarefas (DummyJSON)");
        System.out.println("0 - Sair");
        System.out.println();
        System.out.println("===========================================");
    }

    private static boolean processarOpcao(String opcao) {
        switch (opcao) {
            case "1":
                executarExercicio1();
                return false;

            case "2":
                executarExercicio2();
                return false;

            case "0":
                System.out.println("Encerrando aplicação...");
                System.out.println("Até logo!");
                return true;

            default:
                System.out.println("Opção inválida! Tente novamente.");
                return false;
        }
    }

    private static void executarExercicio1() {
        System.out.println("Iniciando Exercício 1...\n");
        exercicio1.Main.main(new String[]{});
    }

    private static void executarExercicio2() {
        System.out.println("Iniciando Exercício 2...\n");
        MenuConsole menu = new MenuConsole();
        menu.iniciar();
    }
}