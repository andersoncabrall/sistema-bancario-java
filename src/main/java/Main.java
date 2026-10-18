import exception.ContaNaoEncontradaException;
import exception.SaldoInsuficienteException;
import java.util.List;
import model.Banco;
import model.Cliente;
import model.ContaBancaria;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Clientes (inclui Beatriz para testar ordem alfabética)
        Cliente cliente1 = new Cliente("Adriano", "173.234.254-99");
        Cliente cliente2 = new Cliente("Cassiano", "173.244.254-99");
        Cliente cliente3 = new Cliente("Beatriz", "987.654.321-11");

        ContaBancaria conta1 = new ContaBancaria(322424, cliente1);
        ContaBancaria conta2 = new ContaBancaria(3287824, cliente2);
        ContaBancaria conta3 = new ContaBancaria(555123, cliente3);

        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);
        banco.adicionarConta(conta3);

        System.out.println("=== 1. DEPÓSITO INICIAL ===");
        try {
            ContaBancaria c1 = banco.buscarConta(322424);
            c1.depositarValor(1000.0);

            ContaBancaria c3 = banco.buscarConta(555123);
            c3.depositarValor(1500.0);
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

        System.out.println("\n=== 6. RELATÓRIOS FUNCIONAIS (STREAMS) ===");

        double saldoTotal = banco.calcularSaldoTotalDoBanco();
        System.out.println("Saldo total no banco: R$ " + saldoTotal);

        List<String> nomesClientes = banco.obterNomesDosClientes();
        System.out.println("Clientes em ordem alfabética: " + nomesClientes);

        List<ContaBancaria> contasVip = banco.buscarContasComSaldoMinimo(500.0);
        System.out.println("\nContas com saldo mínimo de R$ 500,00:");
        contasVip.forEach(c -> 
            System.out.println(" -> Conta: " + c.getNumeroConta() + " | Cliente: " + c.getCliente().getNome() + " | Saldo: R$ " + c.getSaldo())
        );
    }
}