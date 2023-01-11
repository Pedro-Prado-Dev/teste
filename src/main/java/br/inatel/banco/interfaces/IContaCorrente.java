package br.inatel.banco.interfaces;

public interface IContaCorrente {
    public void adicionarCredito(double valor);
    public boolean pagaCredito(double valor);
    public double consultaCredito();
}
