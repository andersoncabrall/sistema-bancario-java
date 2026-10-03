public class Main{
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Adriano", "173.234.254-99");
        ContaBancaria conta = new ContaBancaria(322424, cliente);

        conta.depositarValor(1000000);
        conta.depositarValor(-10099900);

        conta.sacarValor(223233450);
        conta.sacarValor(3232);
    }
}