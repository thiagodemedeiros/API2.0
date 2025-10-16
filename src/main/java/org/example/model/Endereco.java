package org.example.model;

import lombok.Data;

@Data
public class Endereco {
    private String unidade;
    private String estado;
    private String regiao;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
