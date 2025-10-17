package exercicio2.todos.view;

import exercicio2.products.model.Product;
import exercicio2.products.service.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TodosView {
    private final Scanner scanner;
    private final TodosService todosService;

    public TodosView() {
        this.scanner = new Scanner(System.in);
        this.todosService = new TodosService();
    }

    public void iniciar() {
        while (true) {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine().trim();

            System.out.println();

            try {
                if (processarOpcao(opcao)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números válidos.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro de comunicação: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }

            System.out.println();
        }
    }

    private void exibirMenu() {
        System.out.println("========== TAREFAS ==========");
        System.out.println("1. Listar tarefas");
        System.out.println("2. Adicionar tarefa");
        System.out.println("3. Atualizar tarefa");
        System.out.println("4. Remover tarefa");
        System.out.println("0. Voltar");
        System.out.println("==========================================");
    }

    private boolean processarOpcao(String opcao) throws Exception {
        switch (opcao) {
            case "1":
                listarTarefas();
                return false;

            case "2":
                adicionarTarefa();
                return false;

            case "3":
                atualizarTarefa();
                return false;

            case "4":
                removerTarefa();
                return false;

            case "0":
                System.out.println("Voltando...");
                return true;

            default:
                System.out.println("Opção inválida!");
                return false;
        }
    }

    private void listarProdutos() throws Exception {
        System.out.print("Digite o limite (quantidade): ");
        String limiteStr = scanner.nextLine().trim();

        if (limiteStr.isEmpty()) {
            throw new IllegalArgumentException("Limite não pode ser vazio");
        }

        System.out.print("Digite o skip (quantos pular): ");
        String pularStr = scanner.nextLine().trim();

        if (pularStr.isEmpty()) {
            throw new IllegalArgumentException("Skip não pode ser vazio");
        }

        int limite = Integer.parseInt(limiteStr);
        int pular = Integer.parseInt(pularStr);

        if (limite <= 0) {
            throw new IllegalArgumentException("Limite deve ser maior que zero");
        }

        if (pular < 0) {
            throw new IllegalArgumentException("Skip não pode ser negativo");
        }

        System.out.println("\nBuscando produtos...\n");

        List<Product> produtos = productService.listar(limite, pular);

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            System.out.println("========== RESULTADOS ==========");
            for (Product produto : produtos) {
                System.out.println(produto);
            }
            System.out.println("\nTotal: " + produtos.size() + " produtos exibidos");
        }
    }

    private void buscarProdutos() throws Exception {
        System.out.print("Digite o texto de busca: ");
        String termo = scanner.nextLine().trim();

        if (termo.isEmpty()) {
            throw new IllegalArgumentException("Texto de busca não pode ser vazio");
        }

        System.out.println("\nBuscando produtos...\n");

        List<Product> produtos = productService.buscar(termo);

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o termo: " + termo);
        } else {
            System.out.println("========== RESULTADOS ==========");
            for (Product produto : produtos) {
                System.out.println(produto);
            }
            System.out.println("\nTotal: " + produtos.size() + " produtos encontrados");
        }
    }
}
