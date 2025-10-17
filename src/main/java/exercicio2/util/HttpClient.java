package exercicio2.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;

public class HttpClient {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final int TIMEOUT = 5000;

    public <T> T get(String url, Class<T> responseType) throws IOException {
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) URI.create(url).toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIMEOUT);
            connection.setReadTimeout(TIMEOUT);
            connection.setRequestProperty("Content-Type", "application/json");

            int statusCode = connection.getResponseCode();

            if (statusCode < 200 || statusCode >= 300) {
                throw new IOException("Erro HTTP " + statusCode + ": " + connection.getResponseMessage());
            }

            return mapper.readValue(connection.getInputStream(), responseType);

        } catch (JsonParseException e) {
            throw new IOException("Erro ao processar JSON: formato inválido", e);
        } catch (JsonMappingException e) {
            throw new IOException("Erro ao mapear JSON: estrutura incompatível", e);
        } catch (IOException e) {
            throw new IOException("Erro de comunicação com a API: " + e.getMessage(), e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}