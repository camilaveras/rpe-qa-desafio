package br.com.rpe.util;

public class RTF {
    public static void log(String titulo, String detalhe) {
        System.out.println("[RTF] " + titulo + " -> " + detalhe);
    }

    public static void evidenciar(String passo, String valorEsperado, String valorObtido) {
        System.out.println("[RTF] " + passo + " | Esperado: " + valorEsperado + " | Obtido: " + valorObtido);
    }
}
