// src/JogoDaForca.java
import java.util.Scanner;

public class JogoDaForca {
    private Palavra palavra;
    private BonecoDaForca boneco;
    private StatusJogo status;
    private Scanner scanner;

    public JogoDaForca() {
        this.palavra = new Palavra();
        this.boneco = new BonecoDaForca();
        this.status = StatusJogo.JOGANDO;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bem-vindo ao Jogo da Forca da DIO!");
        System.out.println("Tente adivinhar a palavra secreta.");

        while (status == StatusJogo.JOGANDO) {
            exibirEstadoAtual();
            try {
                char palpite = pedirPalpite();
                processarPalpite(palpite);
                verificarStatusJogo();
            } catch (InvalidInputException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
            System.out.println("------------------------------------");
        }

        finalizarJogo();
    }

    private void exibirEstadoAtual() {
        boneco.desenharForca();
        System.out.println("\nPalavra: " + palavra.getPalavraOculta());
        System.out.println("Erros: " + boneco.getErros());
        System.out.println("Letras tentadas: " + palavra.getLetrasTentadas());
    }

    private char pedirPalpite() throws InvalidInputException {
        System.out.print("Digite uma letra ou a palavra inteira: ");
        String entrada = scanner.nextLine().trim();

        if (entrada.isEmpty()) {
            throw new InvalidInputException("Entrada não pode ser vazia.");
        }

        if (entrada.length() > 1) {
            // Tentar adivinhar a palavra inteira
            if (entrada.equalsIgnoreCase(palavra.getPalavraSecreta())) {
                System.out.println("Parabéns! Você adivinhou a palavra completa!");
                status = StatusJogo.GANHOU;
            } else {
                System.out.println("Que pena! A palavra '" + entrada + "' está incorreta.");
                boneco.adicionarErro(); // Erro fatal ao tentar palavra errada
            }
            // Retorna um caractere dummy, pois o status já foi atualizado
            return '\0'; // Caractere nulo para indicar que a jogada foi um palpite de palavra
        } else {
            // Tentar adivinhar uma letra
            char palpiteLetra = entrada.charAt(0);
            if (!Character.isLetter(palpiteLetra)) {
                throw new InvalidInputException("Entrada inválida. Por favor, digite apenas uma letra.");
            }
            return palpiteLetra;
        }
    }


    private void processarPalpite(char palpite) {
        if (palpite == '\0') { // Se foi um palpite de palavra completa, já foi processado
            return;
        }

        if (palavra.tentarAdivinhar(palpite)) {
            System.out.println("Boa! A letra '" + Character.toUpperCase(palpite) + "' está na palavra.");
        } else {
            System.out.println("Que pena! A letra '" + Character.toUpperCase(palpite) + "' não está na palavra.");
            boneco.adicionarErro();
        }
    }

    private void verificarStatusJogo() {
        if (palavra.isPalavraCompletada()) {
            status = StatusJogo.GANHOU;
        } else if (boneco.isEnforcado()) {
            status = StatusJogo.PERDEU;
        }
    }

    private void finalizarJogo() {
        boneco.desenharForca(); // Desenha a forca final
        System.out.println("\n--- FIM DE JOGO ---");
        if (status == StatusJogo.GANHOU) {
            System.out.println("🎉 PARABÉNS! Você adivinhou a palavra: " + palavra.getPalavraSecreta() + " ��");
        } else {
            System.out.println("😢 VOCÊ PERDEU! A palavra era: " + palavra.getPalavraSecreta() + " 😢");
        }
        scanner.close(); // Sempre feche o Scanner para liberar recursos
    }
}