package exercicio2.products.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Product {

    private int id;
    private String title;
    private double price;

    @Override
    public String toString() {
        return id + " | " + title + " | " + String.format("%.2f", price);
    }
}

