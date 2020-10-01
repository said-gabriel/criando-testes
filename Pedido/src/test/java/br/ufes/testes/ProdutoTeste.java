package br.ufes.testes;


import br.ufes.model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTeste {
   Produto produto = new Produto("Camisa rosa", 20.00, 300); 
    public ProdutoTeste() {
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
    public void CT002(){
        String nomeEsperado = "Camisa rosa";
        double valorEsperado = 20.00;
        double quantidadeEsperada = 300;
        double valorUltimaCompraEsperado = 20.00;
        produto.setValorUnitario(valorEsperado); 
        assertEquals(nomeEsperado, produto.getNome());
        assertEquals(valorEsperado, produto.getValorUnitario());
        assertEquals(quantidadeEsperada, produto.getQuantidade());
        assertEquals(valorUltimaCompraEsperado, produto.getValorUltimaCompra());
    }
    
    @Test
    public void CT003(){
        boolean estoqueEsperado = true;
        assertEquals(estoqueEsperado, produto.estoqueDisponivel(299));
    }
    
    @Test
    public void CT004(){
        String nomeEsperado = "Camisa rosa";
        double valorEsperado = 20.00;
        double quantidadeEsperada = 300;
        double valorUltimaCompraEsperado = 20.00;
        produto.setValorUnitario(valorEsperado);
        String toStringEsperado = "Produto: " + nomeEsperado
                + ", valor unitario: R$" + valorEsperado
                + ", valor da ultima compra: R$" + valorUltimaCompraEsperado
                + ", quantidade em estoque: " + quantidadeEsperada;
        assertEquals(toStringEsperado, produto.toString());
    }

}
