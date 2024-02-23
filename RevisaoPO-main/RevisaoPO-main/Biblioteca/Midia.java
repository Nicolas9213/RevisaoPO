package Biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Midia {

    private boolean emprestada;

    private String nome;

    private int codigo;

    private static final ArrayList<Midia> midias = new ArrayList<>();

    public Midia(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public static Midia procurarMidia(int codigo) {
        for (Midia midia : midias) {
            if (midia.codigo == codigo) {
                return midia;
            }
        }
        return null;
    }

    public boolean isEmprestada() {
        return emprestada;
    }

    public void alterarEmprestimo() {
        this.emprestada = !this.emprestada;
    }

    @Override
     public String toString() {
        return "Midia{" +
                "codigo=" + codigo +
                ", emprestado=" + emprestada +
                '}';
    }

    public static List<Midia> getMidias() {
        return Collections.unmodifiableList(midias);
    }

    public static void addMidia(Midia midia){
        midias.add(midia);
    }

    public static void removeMidia(int codigo) {
        for (Midia midia : midias) {
            if (midia.codigo == codigo) {
                midias.remove(midia);
                return;
            }
        }
    }
}
