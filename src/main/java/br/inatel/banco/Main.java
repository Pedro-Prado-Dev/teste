package br.inatel.banco;

import br.inatel.banco.controller.ManipulaConta;
import br.inatel.banco.service.ContaCorrenteService;
import br.inatel.banco.service.ContaPoupancaService;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------- Inatel Bank ---------------------------");

        ManipulaConta Conta = new ManipulaConta();

        Conta.menuInicial();
        /*
        ContaCorrenteService ContaCorrente = new ContaCorrenteService("1111","1627893-8");
        ContaPoupancaService ContaPoupanca = new ContaPoupancaService("2222","1728394-6");

        System.out.println("--------------------------- ContaCorrente ---------------------------");
        ContaCorrente.pagarConta(70.56,"CEMIG");
        ContaCorrente.depositoConta(300,"PIX");
        ContaCorrente.adicionarCredito(3000);
        ContaCorrente.pagarConta(70.56,"CEMIG");
        ContaCorrente.pagaCredito(100);
        ContaCorrente.consultaExtrato();

        System.out.println("**********************************************************************");

        System.out.println("--------------------------- ContaPoupança ---------------------------");
        ContaPoupanca.depositoConta(5600,"PIX");
        ContaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + ContaPoupanca.consultaRendimento());
        ContaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + ContaPoupanca.consultaRendimento());
        ContaPoupanca.pagarConta(99.90,"Internet");
        ContaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + ContaPoupanca.consultaRendimento());
        ContaPoupanca.consultaExtrato(); */
    }
}
