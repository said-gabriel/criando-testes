package br.ufes;

import br.ufes.model.Cliente;
import br.ufes.model.Pedido;
import br.ufes.model.Produto;
import java.time.LocalDate;

/**
 *
 * @author Clayton, adaptado da solução de Pedro Henrique Robadel
 */
public class Principal {

    public static void main(String[] args) {

        try {

            Cliente cliente1 = new Cliente("Fulano", "123.456.789-01");

            Produto produto1 = new Produto("Caneta", 3.50, 8);

            Pedido pedido1 = new Pedido(cliente1,
                    produto1, 5,
                    LocalDate.now()
            );

            pedido1.addItem(new Produto("Folha Papel A4", 0.05, 10), 10);

            System.out.println(pedido1);

        } catch (RuntimeException rte) {
            System.err.println("Falha: " + rte.getMessage());

        }

    }

}
