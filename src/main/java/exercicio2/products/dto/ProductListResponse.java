package exercicio2.products.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import exercicio2.products.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ProductListResponse {

    @Getter
    @Setter
    @JsonProperty("products")
    private List<Product> products;

    @JsonProperty("total")
    private int total;

    @JsonProperty("skip")
    private int skip;

    @JsonProperty("limit")
    private int limit;

}