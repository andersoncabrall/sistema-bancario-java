# 🏦 Sistema Bancário - Programação Orientada a Objetos em Java

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=openjdk)](https://www.oracle.com/java/)
[![Paradigma](https://img.shields.io/badge/Paradigma-POO-blue?style=flat-square)](#-decisões-de-arquitetura-e-poo)

Aplicação desenvolvida em Java puro com foco no domínio de **Programação Orientada a Objetos (POO)**, aplicando regras rígidas de encapsulamento, imutabilidade, associação entre objetos e integridade de dados financeiros.

---

## 🎯 Objetivo do Projeto

Modelar e simular o funcionamento de uma estrutura bancária sem o uso de frameworks externos, garantindo a implementação manual da lógica de negócios, validações de segurança em memória, transferências entre contas e refatoração para código limpo via métodos privados.

---

## 🛡️ Decisões de Arquitetura e POO

O projeto foi desenhado seguindo boas práticas de POO e Clean Code:

1. **Proteção de Saldo (Sem `setSaldo`):** 
   - A alteração do saldo de uma conta é **estritamente proibida** via métodos modificadores diretos (`setters`).
   - O saldo só é alterado através de operações de domínio encapsuladas (`depositarValor`, `sacarValor` e `transferir`).

2. **Abstração com Métodos Privados Auxiliares:**
   - Criação de métodos privados (`executarSaque` e `executarDeposito`) para realizar mutações de saldo em memória de forma silenciosa.
   - Elimina a duplicação/poluição de mensagens no terminal em operações compostas (como a transferência), garantindo que cada método público exiba apenas seu próprio comprovante.

3. **Associação de Objetos (Transferência Bancária):**
   - Implementação de relacionamento direto entre duas instâncias no método `transferir(double valor, ContaBancaria contaDestino)`.
   - Garante que o saldo seja debitado da conta de origem e creditado na conta de destino de forma atômica e validada.

4. **Imutabilidade de Dados Sensíveis:**
   - O CPF do cliente é definido obrigatoriamente no construtor e não possui método `setCpf()`, impedindo a adulteração do cadastro do titular durante a execução.

5. **Garantia de Estado Válido:**
   - Uma `ContaBancaria` nasce obrigatoriamente vinculada a um `Cliente` e com saldo inicial zerado (`0.0`), evitando a existência de contas "fantasmas" ou saldos arbitrários na criação.

---

## 🚀 Funcionalidades

- [x] **Cadastro de Clientes:** Criação de titulares com validação obrigatória de Nome e CPF via construtor.
- [x] **Abertura de Conta:** Associação automática entre número de conta e titular.
- [x] **Depósito Controlado:** Bloqueio de depósitos zerados ou negativos.
- [x] **Saque Seguro:** Validação dupla que impede saques negativos e bloqueia operações que excedam o saldo disponível.
- [x] **Transferência entre Contas:** Movimentação direta de saldo entre instâncias de `ContaBancaria` com verificação de saldo e mensagens de saída limpas.

---

## 💻 Como Executar o Projeto

### Pré-requisitos
- **JDK 17** ou superior instalado.
- Terminal / Prompt de Comando ou qualquer IDE Java (VS Code, IntelliJ, Eclipse).

### Passo a passo via Terminal

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/andersoncabrall/sistema-bancario-java.git](https://github.com/andersoncabrall/sistema-bancario-java.git)
   cd sistema-bancario-java
   ```

2. **Compile as classes:**
   ```bash
   javac src/*.java
   ```

3. **Execute a aplicação:**
   ```bash
   java -cp src Main
   ```

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java
- **IDE:** Visual Studio Code / IntelliJ IDEA
- **Controle de Versão:** Git & GitHub
