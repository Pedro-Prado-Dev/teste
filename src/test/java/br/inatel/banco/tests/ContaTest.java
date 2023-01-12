package br.inatel.banco.tests;

import br.inatel.banco.service.ContaCorrenteService;
import br.inatel.banco.service.ContaPoupancaService;
import org.junit.Test;
import static  org.junit.Assert.assertEquals;

public class ContaTest {
    ContaCorrenteService cc;
    ContaPoupancaService cp;
    @Test
    public void contaCorrentePagarCreditoTest_OK(){
        cc = new ContaCorrenteService("1111","1627893-8");
        boolean verifica = cc.pagaCredito(10);
        assertEquals(true,verifica);
    }
    @Test
    public void contaCorrentePagarCreditoTest_Erro(){
        cc = new ContaCorrenteService("1111","1627893-8");
        assertEquals(false,cc.pagaCredito(-10));
    }
    @Test
    public void contaCorrenteDeposito_Erro(){
        cc = new ContaCorrenteService("1111","1627893-8");
        assertEquals(false,cc.depositoConta(-10,"PIX"));
    }
    @Test
    public void contaPoupancaAdicionaRendimento_OK(){
        cp = new ContaPoupancaService("2222","1728394-6");
        cp.depositoConta(5600,"teste");
        cp.adicionaRendimento();
        assertEquals(56,cp.consultaRendimento(),0);
    }
   @Test
    public void contaPoupancaPagaConta_Erro(){
        cp = new ContaPoupancaService("2222","1728394-6");
        assertEquals(false,cp.pagarConta(99.09,"CEMIG"));
    }
    @Test
    public void contaPoupancaPagaConta_OK(){
        cp = new ContaPoupancaService("2222","1728394-6");
        cp.depositoConta(500,"PIX");
        assertEquals(true,cp.pagarConta(99.09,"CEMIG"));
    }
}
