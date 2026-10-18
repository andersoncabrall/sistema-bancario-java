package model;

import exception.ContaNaoEncontradaException;
import java.util.HashMap;
import java.util.List;
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

    public List<ContaBancaria> buscarContasComSaldoMinimo(double saldoMinimo){
        return this.contas.values().stream()
        .filter(conta -> conta.getSaldo() >= saldoMinimo)
        .toList();
    }

    public double calcularSaldoTotalDoBanco(){
        return this.contas.values().stream()
        .mapToDouble(conta -> conta.getSaldo())
        .sum();
    }

    public List<String> obterNomesDosClientes(){
        return this.contas.values().stream()
        .map(conta -> conta.getCliente().getNome())
        .sorted((c1, c2) -> c1.compareTo(c2))
        .toList();
    }
}