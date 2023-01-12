package br.inatel.banco.service;
import br.inatel.banco.interfaces.IContaCorrente;
import br.inatel.banco.model.ContaBaseService;
public class ContaCorrenteService extends ContaBaseService implements IContaCorrente {
    private double credito = 0;
    public ContaCorrenteService(String agencia, String numeroConta) {
        super(agencia, numeroConta);
    }

    @Override
    public void adicionarCredito(double valor) {
        this.credito = credito + valor;
    }

    @Override
    public boolean pagaCredito(double valor) {
        if (valor <= 0)
            return false;
        this.pagarConta(valor,"crédito");
        this.credito =this.credito - valor;
        return true;
    }

    @Override
    public double consultaCredito() {
        return this.credito;
    }

    @Override
    public void consultaExtrato() {
        super.consultaExtrato();
    }
}
