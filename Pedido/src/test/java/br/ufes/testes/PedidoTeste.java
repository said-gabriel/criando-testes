package br.ufes.testes;

import br.ufes.model.Cliente;
import br.ufes.model.ItemPedido;
import br.ufes.model.Pedido;
import br.ufes.model.Produto;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoTeste {

    LocalDate data = null;
    Cliente cliente = new Cliente("Fulano", "951.075.557-12");
    Produto produto1 = new Produto("Camisa rosa", 20.00, 300);
    Produto produto2 = new Produto("Camisa vermelha", 40.00, 600);
    Pedido pedido = new Pedido(cliente, produto1, 200.0, data);

    public PedidoTeste() {
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
    public void CT007() {
        double qtdEsperada1 = 150;
        double qtdEsperada2 = 450;
        pedido.addItem(produto1,qtdEsperada1);
        pedido.addItem(produto2, qtdEsperada2);
        pedido.removerItem("Camisa vermelha");
        assertEquals(pedido.getItens(),produto1);
        
    }

}
