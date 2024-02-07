package Biblioteca;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Midia {

    private boolean emprestada;

    private int codigo;

    private static final ArrayList<Midia> midias = new ArrayList<>();

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

}
