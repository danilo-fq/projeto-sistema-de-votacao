# 🗳️ Sistema de Votação Eletrônica

Sistema robusto de gerenciamento de votação desenvolvido em Java, aplicando princípios avançados de Programação Orientada a Objetos. O sistema permite o cadastro de candidatos e eleitores, realização de votações com controle de unicidade de voto, e geração de relatórios de resultados em tempo real.

## 🎯 Sobre o Projeto

Este projeto foi desenvolvido durante a **Aceleração Java da Trybe (2024)** com foco em **Programação Orientada a Objetos**, aplicando conceitos como **herança**, **polimorfismo**, **abstração** e **interfaces**. O sistema simula um processo eleitoral completo com validações de integridade e controle de fluxo.

## ✨ Funcionalidades

### 🧑‍💼 Gestão de Candidatos
- ✅ Cadastro de pessoas candidatas com nome e número
- ✅ Validação de unicidade de número de candidato
- ✅ Listagem de candidatos cadastrados
- ✅ Contabilização automática de votos

### 👥 Gestão de Eleitores
- ✅ Cadastro de pessoas eleitoras com nome e CPF
- ✅ Validação de CPF único no sistema
- ✅ Controle de eleitores que já votaram

### 🗳️ Processo de Votação
- ✅ Registro de votos por CPF e número do candidato
- ✅ Prevenção de voto duplicado
- ✅ Resultados parciais durante a votação
- ✅ Resultado final com porcentagens calculadas

### 📊 Relatórios
- ✅ Exibição de votos por candidato
- ✅ Cálculo percentual de votos
- ✅ Totalização geral da votação

## 🛠️ Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Maven** - Gerenciamento de dependências e build
- **ArrayList** - Estrutura de dados para armazenamento
- **Java Streams** - Processamento funcional de coleções
- **JUnit 5** - Framework de testes unitários
- **Google Checkstyle** - Padrão de código

## 🏗️ Arquitetura e Conceitos de POO

### 📐 Hierarquia de Classes

```
Pessoa (abstract)
├── PessoaCandidata
└── PessoaEleitora

GerenciamentoVotacaoInterface
└── GerenciamentoVotacao (implements)
```

### 🎨 Conceitos Aplicados

#### 1. **Abstração**
- Classe abstrata `Pessoa` como base comum
- Atributo protegido `nome` compartilhado entre subclasses
- Definição de comportamentos essenciais

#### 2. **Herança**
- `PessoaCandidata` e `PessoaEleitora` herdam de `Pessoa`
- Reutilização de código e estrutura comum
- Especialização de comportamentos específicos

#### 3. **Encapsulamento**
- Atributos privados em todas as classes
- Acesso controlado via getters/setters
- Proteção da integridade dos dados

#### 4. **Polimorfismo**
- Interface `GerenciamentoVotacaoInterface` define contrato
- Implementação concreta em `GerenciamentoVotacao`
- Flexibilidade para múltiplas implementações

#### 5. **Composição**
- `GerenciamentoVotacao` compõe listas de `PessoaCandidata` e `PessoaEleitora`
- Relação "tem-um" entre classes

#### 6. **Collections Framework**
- Uso extensivo de `ArrayList` para gerenciamento dinâmico
- Operações de busca, inserção e iteração

#### 7. **Java Streams e Expressões Lambda**
- Uso de `stream()` e `anyMatch()` para validações
- Programação funcional moderna
- Código mais legível e conciso

#### 8. **Tratamento de Exceções**
- `try-catch` para `NumberFormatException`
- Validação robusta de entrada do usuário

## 📦 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6 ou superior

### Instalação e Execução

```bash
# Clone o repositório
git clone https://github.com/danilo-fq/projeto-sistema-votacao.git

# Entre no diretório
cd projeto-sistema-votacao

# Compile o projeto
mvn clean install

# Execute a aplicação
mvn exec:java -Dexec.mainClass="com.betrybe.sistemadevotacao.Principal"
```

### Ou usando o Maven Wrapper:

```bash
# No Linux/Mac
./mvnw clean install
./mvnw exec:java -Dexec.mainClass="com.betrybe.sistemadevotacao.Principal"

# No Windows
mvnw.cmd clean install
mvnw.cmd exec:java -Dexec.mainClass="com.betrybe.sistemadevotacao.Principal"
```

## 💻 Fluxo de Uso

### 1️⃣ Cadastro de Candidatos
```
Cadastrar pessoa candidata?
1 - Sim
2 - Não
Entre com o número correspondente à opção desejada:
1

Entre com o nome da pessoa candidata:
Maria Silva
Entre com o número da pessoa candidata:
10
```

### 2️⃣ Cadastro de Eleitores
```
Cadastrar pessoa eleitora?
1 - Sim
2 - Não
Entre com o número correspondente à opção desejada:
1

Entre com o nome da pessoa eleitora:
João Santos
Entre com o CPF da pessoa eleitora:
123.456.789-00
```

### 3️⃣ Votação
```
Entre com o número correspondente à opção desejada:
1 - Votar
2 - Resultado Parcial
3 - Finalizar Votação
1

Entre com o cpf da pessoa eleitora:
123.456.789-00
Entre com o número da pessoa candidata:
10
```

### 4️⃣ Resultado Final
```
Nome: Maria Silva - 45 votos ( 75% )
Nome: João Pedro - 15 votos ( 25% )
Total de votos: 60
```

## 📁 Estrutura do Projeto

```
sistema-votacao/
├── src/
│   └── main/
│       └── java/
│           └── com/betrybe/sistemadevotacao/
│               ├── Pessoa.java                        # Classe abstrata base
│               ├── PessoaCandidata.java               # Modelo de candidato
│               ├── PessoaEleitora.java                # Modelo de eleitor
│               ├── GerenciamentoVotacaoInterface.java # Contrato do sistema
│               ├── GerenciamentoVotacao.java          # Lógica de negócio
│               └── Principal.java                     # Ponto de entrada e menu CLI
├── pom.xml                                            # Configuração Maven
└── README.md
```

## 🎓 Aprendizados Consolidados

Este projeto evidencia domínio dos seguintes conceitos:

### Fundamentos de POO
- ✅ Classes abstratas e concretas
- ✅ Herança e polimorfismo
- ✅ Interfaces e implementações
- ✅ Encapsulamento e modificadores de acesso
- ✅ Composição de objetos

### Java Moderno
- ✅ Java Streams API
- ✅ Expressões Lambda
- ✅ Method Reference
- ✅ Optional e programação funcional

### Boas Práticas
- ✅ Clean Code (métodos pequenos e focados)
- ✅ Single Responsibility Principle
- ✅ Javadoc completo e detalhado
- ✅ Validação de regras de negócio
- ✅ Separação de responsabilidades

### Estruturas de Dados
- ✅ ArrayList e manipulação dinâmica
- ✅ Iteração e busca em coleções
- ✅ Controle de estado com múltiplas listas

### Interação com Usuário
- ✅ Scanner para entrada de dados
- ✅ Validação robusta de input
- ✅ Tratamento de exceções
- ✅ Menu interativo no terminal

## 🔒 Regras de Negócio Implementadas

1. **Unicidade de Candidato**: Não permite cadastro de dois candidatos com o mesmo número
2. **Unicidade de Eleitor**: Valida CPF único no cadastro de eleitores
3. **Voto Único**: Cada CPF pode votar apenas uma vez
4. **Validação de Entrada**: Trata exceções de formato e valida opções de menu
5. **Integridade Eleitoral**: Garante que apenas eleitores e candidatos cadastrados participem
6. **Cálculo Preciso**: Porcentagens com arredondamento matemático correto

## 👨‍💻 Autor

Desenvolvido por **Danilo Ferreira Queiroz**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/danilo-fq)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/danilo-fq)

---

## 📝 Nota sobre o Projeto

Este projeto foi desenvolvido como parte do programa de **Aceleração Java da Trybe** em 2024, durante o módulo de **Orientação a Objetos**. O código demonstra aplicação prática de conceitos avançados de POO, incluindo herança, polimorfismo, interfaces e programação funcional com Java Streams.

Todo o código-fonte foi desenvolvido por mim, aplicando as melhores práticas de desenvolvimento orientado a objetos e seguindo os padrões de código Google Checkstyle.

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais.
