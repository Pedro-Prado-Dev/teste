package br.inatel.banco.controller;

import br.inatel.banco.model.ContaBaseService;
import br.inatel.banco.service.ContaCorrenteService;
import br.inatel.banco.service.ContaPoupancaService;

import java.util.Scanner;

public class ManipulaConta {
    ContaBaseService ContaCorrente;
    ContaBaseService ContaPoupanca;

    public void menuInicial(){
        System.out.println("Selecione seu tipo de conta: \n");
        System.out.println(" (1) - Conta Corrente");
        System.out.println(" (2) - Conta Poupança");
        System.out.print("Escolha uma opção: ");
        Scanner teclado = new Scanner(System.in);

        short op = teclado.nextShort();
        teclado.nextLine();

        System.out.print("Entre com a agencia: ");
        String agencia = teclado.nextLine();

        System.out.print("Entre com o numero da conta: ");
        String conta = teclado.nextLine();

        System.out.println("----------------------------------------");


        switch (op){
            case 1:
                ContaCorrente = new ContaCorrenteService(agencia,conta);
                this.menuConta(ContaCorrente);
                break;
            case 2:
                ContaPoupanca = new ContaPoupancaService(agencia,conta);
                this.menuConta(ContaPoupanca);
                break;
            default:
                System.out.println("Ivalido");
                break;
        }
    }
    public void menuConta (ContaBaseService Conta){
        short op = 0;

        while(op != 3){
            System.out.println("Conta: ");
            System.out.println("(1) -> Depositar dinheiro em conta");
            System.out.println("(2) -> Pagar Conta");
            System.out.println("(3) -> Ver extrato");
            System.out.println("(4) -> Sair");

            Scanner teclado = new Scanner(System.in);
            op = teclado.nextShort();
            teclado.nextLine();

            switch (op){
                case 1:
                    System.out.println("Entre com o nome do deposito");
                    String nomeDeposito = teclado.nextLine();

                    System.out.println("Entre com o valor do deposito");
                    double valorDeposito = teclado.nextDouble();

                    teclado.nextLine();
                    System.out.println("\n" + this.depositarValor(Conta, valorDeposito, nomeDeposito) + "\n");
                    break;

                case 2:
                    System.out.println("Entre com o nome do pagamento");
                    String nomePagamento = teclado.nextLine();

                    System.out.println("Entre com o valor do pagamento");
                    double valorPagamento = teclado.nextDouble();

                    teclado.nextLine();
                    System.out.println("\n" + this.pagamentoConta(Conta, valorPagamento, nomePagamento) + "\n");
                    break;

                case 3:
                    System.out.println("Extrato Bancario");
                    Conta.consultaExtrato();

                case 4:
                    System.out.println("Fim da operação");
                    break;

                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }

    public String depositarValor(ContaBaseService Conta, double valor, String nome){
        boolean resp = Conta.depositoConta(valor, nome);
        if (resp == false){
            return "Falha ao realizar depósito";
        }
        return "Deposito realizado com sucesso";
    }

    public String pagamentoConta(ContaBaseService Conta, double valor, String nome){
        boolean resp = Conta.pagarConta(valor, nome);
        if (resp == false){
            return "Falha ao realizar pagamento";
        }
        return "Pagamento realizado com sucesso";
    }

}

