package br.inatel.banco.tests;
import static  org.junit.Assert.assertEquals;
import br.inatel.banco.controller.ManipulaConta;
import br.inatel.banco.service.ContaCorrenteService;
import org.junit.Test;

public class ManipulaContaTest {
    ManipulaConta ManipulaFK;

    @Test
    public void depositarValorContaCorrenteTest_OK(){
        ManipulaFK = new ManipulaConta();
        ContaCorrenteService cc = new ContaCorrenteService("1111","1111111");
        String resultado = ManipulaFK.depositarValor(cc,1500,"Pix");
        assertEquals("Deposito realizado com sucesso",resultado);
    }
    @Test
    public void depositarValorContaCorrenteTest_Erro(){
        ManipulaFK = new ManipulaConta();
        ContaCorrenteService cc = new ContaCorrenteService("1111","1111111");
        String resultado = ManipulaFK.depositarValor(cc,-100,"Pix");
        assertEquals("Falha ao realizar depósito",resultado);
    }


    @Test
    public void pagamentoContaCorrenteTest_OK(){
        ManipulaFK = new ManipulaConta();
        ContaCorrenteService cc = new ContaCorrenteService("1111","1111111");
        ManipulaFK.depositarValor(cc,1500,"Pix");
        String resultado = ManipulaFK.pagamentoConta(cc,102.57,"CMIG");
        assertEquals("Pagamento realizado com sucesso",resultado);
    }
    @Test
    public void pagamentoContaCorrenteTest_Erro(){
        ManipulaFK = new ManipulaConta();
        ContaCorrenteService cc = new ContaCorrenteService("1111","1111111");
        ManipulaFK.depositarValor(cc,15,"Pix");
        String resultado = ManipulaFK.pagamentoConta(cc,102.57,"CMIG");
        assertEquals("Falha ao realizar pagamento",resultado);
    }

}
