package br.ufes.testes;

import br.ufes.model.ItemPedido;
import br.ufes.model.Produto;
import java.text.DecimalFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemProdutoTeste {

    Produto produto = new Produto("Camisa rosa", 20.0, 300);
    double quantidadeAdquiridaEsperada = 200;
    ItemPedido itemPedido = new ItemPedido(produto, quantidadeAdquiridaEsperada);

    public ItemProdutoTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void CT005() {
        double valorItemEsperado = 20.0;
        double valorEsperado = valorItemEsperado * quantidadeAdquiridaEsperada;
        assertEquals(valorEsperado, itemPedido.getValorItem());
    }

    @Test
    public void CT006() {

        double valorItemEsperado = 20.0;
        double valorEsperado = valorItemEsperado * quantidadeAdquiridaEsperada;
        DecimalFormat df = new DecimalFormat("0.00");
        String toStringEsperado = produto.getNome()
                + ", valor Unitario: R$ " + produto.getValorUnitario()
                + ", quantidade no pedido:" + quantidadeAdquiridaEsperada
                + ", valor Total: R$ " + df.format(valorEsperado);
        assertEquals(toStringEsperado, itemPedido.toString());

    }
}
