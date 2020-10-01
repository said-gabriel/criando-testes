package br.ufes.testes;


import br.ufes.model.ItemPedido;
import br.ufes.model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemPedidoTeste {
    Produto produto = new Produto("Camisa rosa", 20.00, 300); 
    double quantidadeEsperada = 200; 
    ItemPedido itemPedido = new ItemPedido(produto,quantidadeEsperada);
    public ItemPedidoTeste() {
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
    public void CT005(){
        double valorItemEsperado = 20.00;
        double valorEsperado = valorItemEsperado * quantidadeEsperada;
        assertEquals(valorEsperado,itemPedido.getValorItem());
}
       
  
}
