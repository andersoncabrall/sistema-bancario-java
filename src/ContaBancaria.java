public class ContaBancaria {
    private int numeroConta;
    private double saldo;
    private Cliente cliente;

    public ContaBancaria(int numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void depositarValor(double valor) {
        if (executarDeposito(valor)) {
            System.out.printf("Depósito de R$%.2f realizado com sucesso!%n", valor);
        } else {
            System.out.println("Erro: Valor de depósito deve ser positivo.");
        }
    }

    public boolean sacarValor(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do saque deve ser maior que zero.");
            return false;
        } else if (valor > saldo) {
            System.out.printf("Erro: Saldo insuficiente (R$%.2f) para sacar R$%.2f.%n", saldo, valor);
            return false;
        } else {
            executarSaque(valor);
            System.out.printf("Saque de R$%.2f realizado! Saldo restante: R$%.2f%n", valor, saldo);
            return true;
        }
    }

    public boolean transferir(double valor, ContaBancaria contaDestino) {
        if (valor <= 0) {
            System.out.println("Erro: O valor da transferência deve ser maior que zero.");
            return false;
        } else if (valor > saldo) {
            System.out.printf("Erro: Saldo insuficiente (R$%.2f) para transferir R$%.2f.%n", saldo, valor);
            return false;
        } else {

            executarSaque(valor);
            contaDestino.executarDeposito(valor);

            System.out.printf("Transferência de R$%.2f para %s realizada com sucesso!%n", 
                              valor, contaDestino.getCliente().getNome());
            return true;
        }
    }

    private boolean executarDeposito(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    private void executarSaque(double valor) {
        this.saldo -= valor;
    }
}