package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Endereco;

import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String cepDigitado;

            System.out.print("DIGITE SEU CEP: ");
            cepDigitado = "01153000";

            URL url = new URL("https://viacep.com.br/ws/" + cepDigitado +"/json/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int verificarConexaoComApi = conn.getResponseCode();

            if (verificarConexaoComApi != 200) {
                System.out.println("Erro na chamada de api");
                return;
            }

            Endereco json = mapper.readValue(conn.getInputStream(), Endereco.class);
            System.out.println(json);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}