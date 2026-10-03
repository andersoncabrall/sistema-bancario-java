# 🏦 Sistema Bancário - Programação Orientada a Objetos em Java

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=openjdk)](https://www.oracle.com/java/)
[![Paradigma](https://img.shields.io/badge/Paradigma-POO-blue?style=flat-square)](#-decisões-de-arquitetura-e-poo)

Aplicação desenvolvida em Java puro com foco no domínio de **Programação Orientada a Objetos (POO)**, aplicando regras rígidas de encapsulamento, immutabilidade e integridade de dados financeiros.

---

## 🎯 Objetivo do Projeto

Modelar e simular o funcionamento de uma estrutura bancária sem o uso de frameworks externos ou atalhos práticos, garantindo a implementação manual da lógica de negócios, validações de segurança em memória e associação entre entidades.

---

## 🛡️ Decisões de Arquitetura e POO

O projeto foi desenhado evitando armadilhas comuns de modelagem inicial:

1. **Proteção de Saldo (Sem `setSaldo`):** 
   - A alteração do saldo de uma conta é **estritamente proibida** via métodos modificadores diretos (`setters`).
   - O saldo só é alterado através de operações de domínio encapsuladas (`depositarValor` e `sacarValor`), garantindo rastreabilidade e validação de regras de negócio.

2. **Imutabilidade de Dados Sensíveis:**
   - O CPF do cliente é definido obrigatoriamente via construtor e não possui método `setCpf()`, impedindo a adulteração do cadastro do titular durante a execução.

3. **Garantia de Estado Válido:**
   - Uma `ContaBancaria` nasce obrigatoriamente vinculada a um `Cliente` e com saldo inicial zerado (`0.0`), evitando a existência de contas "fantasmas" ou saldos arbitrários na criação.

4. **Associação entre Objetos:**
   - A classe `ContaBancaria` possui uma relação de associação direta com a entidade `Cliente`, permitindo o acesso aos dados do titular por composição.

---

## 🚀 Funcionalidades

- [x] **Cadastro de Clientes:** Criação de titulares com validação obrigatória de Nome e CPF via construtor.
- [x] **Abertura de Conta:** Associação automática entre número de conta e titular.
- [x] **Depósito Controlado:** Bloqueio de depósitos zerados ou negativos.
- [x] **Saque Seguro:** Validação dupla que impede saques negativos e bloqueia operações que excedam o saldo disponível.

---

## 💻 Como Executar o Projeto

### Pré-requisitos
- **JDK 17** ou superior instalado.
- Terminal / Prompt de Comando ou qualquer IDE Java (VS Code, IntelliJ, Eclipse).

### Passo a passo via Terminal

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/SEU_USUARIO/sistema-bancario-poo.git](https://github.com/SEU_USUARIO/sistema-bancario-poo.git)
   cd sistema-bancario-poo
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