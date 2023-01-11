package br.inatel.banco.tests;

import br.inatel.banco.service.ContaCorrenteService;
import br.inatel.banco.service.ContaPoupancaService;
import org.junit.Before;
import org.junit.Test;
import static  org.junit.Assert.assertEquals;

public class ContaTest {
    ContaCorrenteService cc;
    ContaPoupancaService cp;

    @Before
    public void setup(){
        cc = new ContaCorrenteService("1111","1627893-8");
        cp = new ContaPoupancaService("2222","1728394-6");
    }

    @Test
    public void contaCorrentePagarCreditoTest_OK(){
        boolean verifica = cc.pagaCredito(10);
        assertEquals(true,verifica);
    }
    @Test
    public void contaCorrentePagarCreditoTest_Erro(){
        assertEquals(false,cc.pagaCredito(-10));
    }
    @Test
    public void contaPoupancaAdicionaRendimento_OK(){
        cp.depositoConta(5600,"teste");
        cp.adicionaRendimento();
        assertEquals(56,cp.consultaRendimento(),0);
    }
}
