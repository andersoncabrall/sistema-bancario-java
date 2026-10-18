package model;

import exception.ContaNaoEncontradaException;
import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<Integer, ContaBancaria> contas = new HashMap<>();

    public Map<Integer, ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(Map<Integer, ContaBancaria> contas) {
        this.contas = contas;
    }

    public void adicionarConta(ContaBancaria conta) {
        this.contas.put(conta.getNumeroConta(), conta);
    }

    public ContaBancaria buscarConta(int numeroConta) throws ContaNaoEncontradaException {
        ContaBancaria conta = this.contas.get(numeroConta);
        if (conta == null) {
            throw new ContaNaoEncontradaException("Conta número " + numeroConta + " não encontrada!");
        }
        return conta;
    }
}