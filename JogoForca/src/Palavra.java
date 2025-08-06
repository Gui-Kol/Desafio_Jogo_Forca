// src/Palavra.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Palavra {
    private String palavraSecreta;
    private List<Character> letrasAdivinhadas; // Letras que o jogador já tentou
    private List<String> palavrasDisponiveis = Arrays.asList(
        "JAVA", "PROGRAMACAO", "ORIENTACAO", "OBJETOS", "ALGORITMO",
        "DESAFIO", "DIO", "CONSOLE", "FORCA", "APRENDER"
    );

    public Palavra() {
        // Escolhe uma palavra aleatoriamente da lista
        Random random = new Random();
        this.palavraSecreta = palavrasDisponiveis.get(random.nextInt(palavrasDisponiveis.size())).toUpperCase();
        this.letrasAdivinhadas = new ArrayList<>();
    }

    public String getPalavraOculta() {
        StringBuilder palavraOculta = new StringBuilder();
        for (char letra : palavraSecreta.toCharArray()) {
            if (letrasAdivinhadas.contains(letra)) {
                palavraOculta.append(letra).append(" ");
            } else {
                palavraOculta.append("_ ");
            }
        }
        return palavraOculta.toString().trim();
    }

    public boolean tentarAdivinhar(char letra) {
        char letraMaiuscula = Character.toUpperCase(letra);
        if (letrasAdivinhadas.contains(letraMaiuscula)) {
            System.out.println("Você já tentou a letra '" + letraMaiuscula + "'. Tente outra!");
            return false; // Já adivinhou ou tentou essa letra
        }

        letrasAdivinhadas.add(letraMaiuscula);
        return palavraSecreta.indexOf(letraMaiuscula) >= 0; // Retorna true se a letra estiver na palavra
    }

    public boolean isPalavraCompletada() {
        for (char letra : palavraSecreta.toCharArray()) {
            if (!letrasAdivinhadas.contains(letra)) {
                return false; // Se alguma letra da palavra secreta não foi adivinhada
            }
        }
        return true; // Todas as letras foram adivinhadas
    }

    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public List<Character> getLetrasTentadas() {
        return letrasAdivinhadas;
    }
}