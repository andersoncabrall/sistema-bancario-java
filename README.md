# 🏦 Sistema Bancário - Java Core

Sistema de gerenciamento bancário desenvolvido em **Java Core**, focado na aplicação de arquitetura orientada a objetos (POO), gerenciamento de coleções com `Map` e `List`, tratamento de exceções customizadas, transferências entre contas, histórico de extrato cronológico e geração de relatórios funcionais com **Streams API & Lambdas**.

---

## 🎯 Funcionalidades

* **Cadastro de Clientes e Contas:** Associação de contas bancárias a clientes (`Cliente` e `ContaBancaria`).
* **Gerenciamento do Banco:** Armazenamento e busca eficiente de contas via `Map<Integer, ContaBancaria>`.
* **Operações Bancárias:**
* Depósitos e saques com validação em tempo real.
* Transferências entre contas com atualização automática do extrato em ambas as pontas.


* **Histórico de Extrato:** Registro cronológico de transações com data e hora formatadas (`dd/MM/yyyy HH:mm`).
* **Tratamento de Erros:** Exceções personalizadas (`SaldoInsuficienteException` e `ContaNaoEncontradaException`) para garantir regras de negócio seguras.
* **Relatórios Funcionais (Streams API):**
* Consulta de contas com saldo superior a um valor mínimo (`.filter()`).
* Cálculo do saldo total de recursos sob custódia do banco (`.mapToDouble()`, `.sum()`).
* Listagem dos nomes de todos os clientes em ordem alfabética (`.map()`, `.sorted()`).



---

## 🛠️ Tecnologias e Conceitos Utilizados

* **Linguagem:** Java (JDK 17+)
* **Programação Funcional:** Streams API e Expressões Lambda para processamento declarativo de coleções.
* **Coleções (Collections Framework):**
* `List` / `ArrayList` para histórico sequencial do extrato.
* `Map` / `HashMap` para busca de contas em tempo $O(1)$.


* **Datas e Horas:** `java.time.LocalDateTime` e `java.time.format.DateTimeFormatter`.
* **Exceções Personalizadas:** Herança de `Exception` para capturar regras de negócio violadas.
* **Arquitetura em Pacotes:** Separação clara de responsabilidades entre modelo e exceções (`model` e `exception`).

---

## 📂 Estrutura do Projeto

```text
sistema-bancario-java/
└── src/
    ├── exception/
    │   ├── ContaNaoEncontradaException.java
    │   └── SaldoInsuficienteException.java
    ├── model/
    │   ├── Banco.java
    │   ├── Cliente.java
    │   └── ContaBancaria.java
    └── Main.java

```

---

## 🚀 Como Executar

1. **Clone o repositório:**
```bash
git clone https://github.com/andersoncabrall/sistema-bancario-java.git

```


2. **Acesse a pasta do projeto:**
```bash
cd sistema-bancario-java

```


3. **Compile e execute a classe `Main.java**` através do VS Code ou sua IDE de preferência.

---