package br.ufes.testes;

import br.ufes.model.Cliente;
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
    
    @org.junit.jupiter.api.Test
    public void CT001(){
        String nomeEsperado = "Camisa rosa";
        double valorEsperado = 20.00;
        double quantidadeEsperada = 300;
        assertEquals(nomeEsperado, produto.getNome());
        assertEquals(valorEsperado, produto.getValorUnitario());
        assertEquals(quantidadeEsperada, produto.getQuantidade());
    }
    
    @org.junit.jupiter.api.Test
    public void CT002(){
        double estoqueEsperado = 300;
        assertEquals(estoqueEsperado, produto.estoqueDisponivel(299));
    }


}