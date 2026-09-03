# tp08-biblioteca-emprestimos

## Descrição do Sistema

Este é um sistema de biblioteca simples desenvolvido em Java. O programa roda diretamente no console e permite o cadastro de livros e seus autores, cadastro de leitores, listagem de acervo em formato de tabela alinhada, busca de livros por título de forma case-insensitive, efetuar empréstimos, efetuar devoluções, e geração de relatórios da situação do acervo. O sistema utiliza ArrayList para o gerenciamento dinâmico dos dados.

## Integrantes

- **Desenvolvedor A:** Lucas Coleti - User do GitHub: Lucas12135
- **Desenvolvedor B:** Matheus Pereira - User do GitHub: MathLucasP

## Instruções de Compilação e Execução

### Pré-requisitos

- Java JDK (versão 8 ou superior)
- Eclipse IDE (recomendado)

### Como Compilar e Rodar no Terminal

1. Clone o repositório

```bash
    git clone https://github.com/Lucas12135/tp08-biblioteca-emprestimos.git
```

2. Navegue até a pasta do projeto

```bash
    cd tp08-biblioteca-emprestimos/src
```

3. Compile o Arquivo Principal

```bash
    javac br/edu/fatecpg/Principal.java
```

4. Execute o programa

```bash
    java br.edu.fatecpg.Principal
```

(obs: Para executar no Eclipse é só importar o projeto para dentro da IDE e clicar no botão **Run**)

## Divisão de Tarefas

Aqui é a parte que mostra como foi dividida a responsabilidade entre os desenvolvedores

### Desenvolvedor A (Lucas Coleti) - Branch: feature/acervo-livros

Configuração inicial do repositório Git e GitHub.
Implementação do cadastro de livros com validações de campos vazios e duplicados.
Implementação da listagem do acervo.
Implementação da busca por título de livro.
Implementação do cadastro de leitores.

### Desenvolvedor B (Matheus Pereira) - Branch: feature/emprestimo-devolucao

Implementação da funcionalidade de empréstimo com registro do leitor.
Implementação da funcionalidade de devolução.
Implementação da funcionalidade de geração de relatório de situação do acervo.
