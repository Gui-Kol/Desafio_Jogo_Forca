# Desafio DIO: Jogo da Forca em Java (POO)

Este projeto é a minha implementação do Desafio de Programação Orientada a Objetos da Digital Innovation One (DIO), focado na construção de um jogo da forca em ambiente de console utilizando a linguagem Java. O objetivo foi aplicar os conceitos aprendidos nas aulas e demonstrar a compreensão da POO em um projeto prático.

## ✨ Conceitos Abordados

Durante o desenvolvimento deste projeto, tive a oportunidade de aplicar e aprofundar os seguintes conceitos de Programação Orientada a Objetos e Java:

*   **Classes e Objetos**: O jogo foi estruturado em classes bem definidas como `Palavra` (responsável pela palavra secreta e seus estados), `BonecoDaForca` (para o desenho da forca e contagem de erros) e `JogoDaForca` (a classe principal que orquestra toda a lógica do jogo).
*   **Encapsulamento**: Os dados internos de cada classe são protegidos (`private`) e acessados apenas através de métodos públicos (`public`), garantindo que o estado dos objetos seja manipulado de forma controlada.
*   **Métodos**: Definição de comportamentos específicos para os objetos (ex: `tentarAdivinhar()` na `Palavra`, `desenharForca()` no `BonecoDaForca`, `iniciar()` no `JogoDaForca`).
*   **Listas (`ArrayList`)**: Utilizadas para armazenar e gerenciar as letras que o jogador já tentou.
*   **Enums (`StatusJogo`)**: Um tipo enumerado foi criado para representar os estados possíveis do jogo (`JOGANDO`, `GANHOU`, `PERDEU`), tornando o código mais legível e evitando erros de digitação.
*   **Exceções Personalizadas (`InvalidInputException`)**: Uma exceção customizada foi implementada para tratar entradas inválidas do usuário, melhorando a robustez do programa e a experiência do usuário.
*   **Manipulação de Strings**: Diversas operações com strings foram realizadas para ocultar/revelar letras da palavra, verificar palpites e formatar a saída no console.
*   **Lógica de Jogo**: Implementação de fluxos de controle (`if/else`, `while`) para gerenciar as rodadas, verificar condições de vitória/derrota e controlar a contagem de erros.
*   **Interação com o Usuário**: Utilização da classe `Scanner` para capturar as entradas do jogador no console, permitindo a interatividade necessária para o jogo.

## ⚙️ Como Rodar o Projeto

Para executar este jogo no seu ambiente local, siga os passos abaixo:

1.  **Pré-requisitos**:
    *   Certifique-se de ter o **JDK (Java Development Kit)** instalado em sua máquina (versão 11 ou superior recomendada). Você pode baixá-lo no site oficial da Oracle.

2.  **Clonar o Repositório**:
    Abra seu terminal ou prompt de comando e clone este repositório:
    ```bash
    git clone https://github.com/SEU_USUARIO/jogo-da-forca-dio.git
    ```

3.  **Navegar até o Diretório do Projeto**:
    Entre na pasta do projeto clonado:
    ```bash
    cd jogo-da-forca-dio
    ```

4.  **Compilar o Código**:
    Compile os arquivos `.java` na pasta `src`:
    ```bash
    javac src/*.java
    ```

5.  **Executar o Jogo**:
    Agora, execute a classe principal `Main`:
    ```bash
    java -cp src Main
    ```

    **Alternativamente, usando uma IDE:**
    Se você estiver utilizando uma IDE como IntelliJ IDEA ou Visual Studio Code (com a extensão Java), basta abrir o projeto na IDE e executar a classe `Main.java` diretamente.

## 🎮 Exemplo de Execução (Console)

Abaixo, um exemplo de como o jogo interage no console:
Bem-vindo ao Jogo da Forca da DIO! Tente adivinhar a palavra secreta.

| | | | |__

Palavra: _ _ _ _ _ _ _ _ _ _ Erros: 0 Letras tentadas: []
Digite uma letra ou a palavra inteira: A Boa! A letra 'A' está na palavra.
| | | | |__

Palavra: _ A _ _ _ _ _ _ _ _ Erros: 0 Letras tentadas: [A]
Digite uma letra ou a palavra inteira: Z Que pena! A letra 'Z' não está na palavra.
| O | | | |__

Palavra: _ A _ _ _ _ _ _ _ _ Erros: 1 Letras tentadas: [A, Z]
... (continuação do jogo)


## 📂 Estrutura do Projeto

A estrutura do projeto é simples e organizada, com cada classe em seu próprio arquivo Java dentro do diretório `src/`:

. ├── src/ │ ├── BonecoDaForca.java # Gerencia o desenho da forca e a contagem de erros. │ ├── InvalidInputException.java # Exceção personalizada para entradas inválidas. │ ├── JogoDaForca.java # Contém a lógica principal do jogo. │ ├── Main.java # Ponto de entrada do programa. │ ├── Palavra.java # Gerencia a palavra secreta e seus estados. │ └── StatusJogo.java # Enumeração para os estados do jogo. ├── .gitignore # Ignora arquivos e diretórios que não devem ser versionados. └── README.md # Este arquivo.


## 🚀 Melhorias Futuras (Ideias)

*   Adicionar uma lista mais extensa de palavras secretas.
*   Implementar diferentes níveis de dificuldade (com base no tamanho da palavra ou número de chances).
*   Oferecer a opção de reiniciar o jogo ao final de cada partida.
*   Incluir um sistema de pontuação para o jogador.
*   Aprimorar a interface de usuário no console (cores, layouts).

Feito por **Guilherme Kolndorfer**
Linkedin: www.linkedin.com/in/guilherme-kolndorfer-b6836122b
