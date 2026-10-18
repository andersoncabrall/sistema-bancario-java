package model;

import exception.SaldoInsuficienteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private int numeroConta;
    private double saldo;
    private Cliente cliente;
    private List<String> extrato = new ArrayList<>();

    public ContaBancaria(int numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    private String getDataFormatada() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.now().format(formatador);
    }

    public void depositarValor(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.extrato.add("Depósito de R$ " + valor + " em " + getDataFormatada());
            System.out.printf("Depósito de R$%.2f realizado com sucesso!%n", valor);
        } else {
            System.out.println("Erro: Valor de depósito deve ser positivo.");
        }
    }

    public void sacarValor(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new SaldoInsuficienteException("O valor do saque deve ser maior que zero.");
        }
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException(String.format("Saldo insuficiente (R$%.2f) para sacar R$%.2f.", this.saldo, valor));
        }
        this.saldo -= valor;
        this.extrato.add("Saque de R$ " + valor + " em " + getDataFormatada());
        System.out.printf("Saque de R$%.2f realizado! Saldo restante: R$%.2f%n", valor, this.saldo);
    }

    public void transferir(double valor, ContaBancaria contaDestino) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new SaldoInsuficienteException("O valor da transferência deve ser maior que zero.");
        }
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException(String.format("Saldo insuficiente (R$%.2f) para transferir R$%.2f.", this.saldo, valor));
        }
        this.saldo -= valor;
        contaDestino.saldo += valor;
        this.extrato.add("Transferência de R$ " + valor + " para " + contaDestino.getCliente().getNome() + " em " + getDataFormatada());
        contaDestino.extrato.add("Recebido R$ " + valor + " de " + this.cliente.getNome() + " em " + getDataFormatada());
        System.out.printf("Transferência de R$%.2f para %s realizada com sucesso!%n", valor, contaDestino.getCliente().getNome());
    }

    public void imprimirExtrato() {
        System.out.println("=== EXTRATO BANCÁRIO (Conta " + this.numeroConta + " - Cliente: " + this.cliente.getNome() + ") ===");
        for (String linha : this.extrato) {
            System.out.println(linha);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
}