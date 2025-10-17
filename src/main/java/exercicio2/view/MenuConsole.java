package exercicio2.view;

import exercicio2.products.view.ProductView;

import java.util.Scanner;

public class MenuConsole {

    public void iniciar() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                exibirMenu();

                System.out.print("Escolha uma opção: ");
                String opcao = scanner.nextLine().trim();

                System.out.println();

                if (processarOpcao(opcao)) {
                    break;
                }


            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


    public void exibirMenu () {
        System.out.println("========== CATÁLOGO & TAREFAS (DummyJson) ==========");
        System.out.println("1. Catálogo de produtos");
        System.out.println("2. Tarefas");
        System.out.println("0. Voltar");
        System.out.println("====================================================");
    }

    private static boolean processarOpcao(String opcao) {
        switch (opcao) {
            case "1":
                System.out.println("Iniciando Catálogo de Produtos...\n");
                ProductView productView = new ProductView();
                productView.iniciar();
                return false;

            case "2":
                System.out.println("Iniciando Todos...\n");
                TodosView todosView = new TodosView();
                todosView.iniciar();
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
}