package br.inatel.banco.service;

import br.inatel.banco.interfaces.IContaPoupança;
import br.inatel.banco.model.ContaBaseService;

public class ContaPoupancaService extends ContaBaseService implements IContaPoupança {
    private double rendimento = 0;
    public ContaPoupancaService(String agencia, String numeroConta) {
        super(agencia, numeroConta);
    }

    @Override
    public void adicionaRendimento() {
        this.rendimento += this.consultaSaldo()*0.01 ;
    }

    @Override
    public double consultaRendimento() {
        return  this.rendimento;
    }

}
