package br.ufes.testes;

import br.ufes.model.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ClienteTeste {
   Cliente cliente = new Cliente("Fulano","951.075.557-12"); 
    public ClienteTeste() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void CT001(){
        String nomeEsperado = "Fulano";
        String CPFouCNPJEsperado = "951.075.557-12";
        assertEquals(nomeEsperado, cliente.getNome());
        assertEquals(CPFouCNPJEsperado, cliente.getCNPJOuCPF());
}
   

}
