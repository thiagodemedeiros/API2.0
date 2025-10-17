package exercicio2.products.service;

import exercicio2.products.dto.ProductListResponse;
import exercicio2.products.model.Product;
import exercicio2.util.HttpClient;

import java.io.IOException;
import java.util.List;

public class ProductService {

    private static final String BASE_URL = "https://dummyjson.com/products";
    private final HttpClient httpClient;

    public ProductService() {
        this.httpClient = new HttpClient();
    }

    public List<Product> listar(int limite, int pular) throws IOException {
        String url = BASE_URL + "?limit=" + limite + "&skip=" + pular;

        System.out.println("Buscando da API: " + url);

        ProductListResponse response = httpClient.get(url, ProductListResponse.class);
        return response.getProducts();
    }

    public List<Product> buscar(String termo) throws IOException {
        if (termo == null || termo.trim().isEmpty()) {
            throw new IllegalArgumentException("Texto de busca não pode ser vazio");
        }

        String url = BASE_URL + "/search?q=" + termo;

        System.out.println("Buscando da API: " + url);

        ProductListResponse response = httpClient.get(url, ProductListResponse.class);
        return response.getProducts();
    }
}