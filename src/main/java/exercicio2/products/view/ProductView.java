package exercicio2.products.view;

import java.util.Scanner;

public class ProductView {

    private final Scanner scanner;

    public ProductView() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine().trim();

            System.out.println();

            if (processarOpcao(opcao)) {
                break;
            }

            System.out.println();
        }
    }

    private void exibirMenu() {
        System.out.println("========== CATÁLOGO DE PRODUTOS ==========");
        System.out.println("1. Listar produtos");
        System.out.println("2. Buscar produtos por texto");
        System.out.println("0. Voltar");
        System.out.println("==========================================");
    }

    private boolean processarOpcao(String opcao) {
        switch (opcao) {
            case "1":
                listarProdutos();
                return false;

            case "2":
                buscarProdutos();
                return false;

            case "0":
                System.out.println("Voltando...");
                return true;

            default:
                System.out.println("Opção inválida!");
                return false;
        }
    }

    private void listarProdutos() {
        System.out.print("Digite o limite (quantidade): ");
        String limiteStr = scanner.nextLine().trim();

        System.out.print("Digite o skip (quantos pular): ");
        String pularStr = scanner.nextLine().trim();

        System.out.println("\n[TODO] Listar produtos: limit=" + limiteStr + ", skip=" + pularStr);
    }

    private void buscarProdutos() {
        System.out.print("Digite o texto de busca: ");
        String termo = scanner.nextLine().trim();

        System.out.println("\n[TODO] Buscar produtos: q=" + termo);
    }
}