// src/BonecoDaForca.java
public class BonecoDaForca {
    private int erros;
    private final int MAX_ERROS = 6; // Número máximo de partes do boneco

    public BonecoDaForca() {
        this.erros = 0;
    }

    public void adicionarErro() {
        if (erros < MAX_ERROS) {
            erros++;
        }
    }

    public boolean isEnforcado() {
        return erros >= MAX_ERROS;
    }

    public void desenharForca() {
        System.out.println("  ____");
        System.out.println(" |    " + (erros > 0 ? "O" : ""));
        System.out.println(" |   " + (erros > 2 ? "/" : "") + (erros > 1 ? "|" : "") + (erros > 3 ? "" : ""));
        System.out.println(" |    " + (erros > 4 ? "|" : ""));
        System.out.println(" |   " + (erros > 5 ? "/ " : ""));
        System.out.println(" |");
        System.out.println("_|___");
    }

    public int getErros() {
        return erros;
    }
}