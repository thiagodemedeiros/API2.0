package exercicio1;

import com.fasterxml.jackson.databind.ObjectMapper;
import exercicio1.model.Endereco;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ObjectMapper mapper = new ObjectMapper();

            System.out.print("Digite o CEP: ");
            String cep = scanner.nextLine().trim();

            if (cep.isEmpty()) {
                System.out.println("CEP nao pode ser vazio");
                return;
            }

            String apiUrl = "https://viacep.com.br/ws/" + cep + "/json/";
            HttpURLConnection conn = (HttpURLConnection) URI.create(apiUrl).toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                System.out.println("Erro na chamada da API, codigo: " + responseCode);
                return;
            }

            Endereco endereco = mapper.readValue(conn.getInputStream(), Endereco.class);

            if (endereco.getCep() == null) {
                System.out.println("CEP nao encontrado");
                return;
            }

            System.out.println(endereco.getCep() + " - " + endereco.getLogradouro() + ", " +
                             endereco.getBairro() + ", " + endereco.getLocalidade() + "/" + endereco.getUf());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}