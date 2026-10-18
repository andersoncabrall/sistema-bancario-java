import exception.ContaNaoEncontradaException;
import exception.SaldoInsuficienteException;
import model.Banco;
import model.Cliente;
import model.ContaBancaria;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("Adriano", "173.234.254-99");
        Cliente cliente2 = new Cliente("Cassiano", "173.244.254-99");

        ContaBancaria conta1 = new ContaBancaria(322424, cliente1);
        ContaBancaria conta2 = new ContaBancaria(3287824, cliente2);

        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        System.out.println("=== 1. DEPÓSITO INICIAL ===");
        try {
            ContaBancaria c1 = banco.buscarConta(322424);
            c1.depositarValor(1000.0);
        } catch (ContaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n=== 2. TRANSFERÊNCIA COM SUCESSO ===");
        try {
            ContaBancaria c1 = banco.buscarConta(322424);
            ContaBancaria c2 = banco.buscarConta(3287824);
            c1.transferir(400.0, c2);
        } catch (ContaNaoEncontradaException | SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n=== 3. TESTE DE ERRO (SALDO INSUFICIENTE) ===");
        try {
            ContaBancaria c1 = banco.buscarConta(322424);
            ContaBancaria c2 = banco.buscarConta(3287824);
            c1.transferir(2000.0, c2);
        } catch (ContaNaoEncontradaException | SaldoInsuficienteException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        System.out.println("\n=== 4. TESTE DE ERRO (CONTA NÃO ENCONTRADA) ===");
        try {
            banco.buscarConta(999999);
        } catch (ContaNaoEncontradaException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        System.out.println("\n=== 5. EXTRATO ===");
        try {
            ContaBancaria c1 = banco.buscarConta(322424);
            c1.imprimirExtrato();
        } catch (ContaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}