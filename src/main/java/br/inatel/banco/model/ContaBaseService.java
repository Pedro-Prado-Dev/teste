package br.inatel.banco.model;

import br.inatel.banco.interfaces.IContaService;

import java.util.ArrayList;

public abstract class ContaBaseService implements IContaService {
        private String agencia;
        private String numeroConta;
        private double saldo =0;
        private ArrayList<Pagamentos> extrato = new ArrayList<Pagamentos>();
    public ContaBaseService(String agencia, String numeroConta) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
    }

    @Override
    public boolean pagarConta(double valor, String nome) {
        if(this.saldo <= valor)
            return false;
        this.saldo = saldo -valor;
        extrato.add(new Pagamentos(-valor,nome,"Pagamento"));
        return true;
    }

    @Override
    public boolean depositoConta(double valor, String nome) {
        if (valor <= 0)
            return  false;
        this.saldo = saldo + valor;
        extrato.add(new Pagamentos(valor,nome,"Deposito"));

        return true;
    }

    @Override
    public double consultaSaldo() {
        return this.saldo;
    }

    public void consultaExtrato() {
        if (this.saldo == 0){
            System.out.println("Extrato vazio");
        }
        else {
            for (Pagamentos Pagamento: this.extrato) {
                System.out.println("Nome: "+ Pagamento.getNome());
                System.out.println("Valor: "+ Pagamento.getValor());
                System.out.println("Operação: "+ Pagamento.getOperacao()+"\n");
            }
            System.out.println("Saldo total " + this.saldo);
        }

    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
