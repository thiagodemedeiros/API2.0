package exercicio2.view;

import exercicio2.products.view.ProductView;

public class MenuConsole {

    public void iniciar() {
        System.out.println("Iniciando Catálogo de Produtos...\n");
        ProductView productView = new ProductView();
        productView.iniciar();
    }
}