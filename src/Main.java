public class Main{
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Adriano", "173.234.254-99");
        Cliente cliente2 = new Cliente("Cassiano", "173.244.254-99");

        // 2. Criando as contas bancárias
        ContaBancaria conta1 = new ContaBancaria(322424, cliente1);
        ContaBancaria conta2 = new ContaBancaria(3287824, cliente2);

        System.out.println("=== 1. DEPÓSITO INICIAL ===");
        conta1.depositarValor(1000.0);

        System.out.println("\n=== 2. TRANSFERÊNCIA COM SUCESSO ===");
        // Transfere R$ 400 de Adriano para Cassiano
        conta1.transferir(400.0, conta2);

        System.out.println("\n=== 3. TESTE DE ERRO (SALDO INSUFICIENTE) ===");
        // Tenta transferir R$ 2000 (deve barrar)
        conta1.transferir(2000.0, conta2);

        System.out.println("\n=== 4. SALDOS FINAIS ===");
        System.out.printf("Saldo de %s: R$ %.2f%n", conta1.getCliente().getNome(), conta1.getSaldo());
        System.out.printf("Saldo de %s: R$ %.2f%n", conta2.getCliente().getNome(), conta2.getSaldo());
    }
}