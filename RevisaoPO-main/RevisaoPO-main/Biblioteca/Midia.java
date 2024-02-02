package Biblioteca;

import java.util.ArrayList;

public abstract class Midia {

    private boolean emprestada;

    private static final ArrayList<Midia> midias = new ArrayList<>();

    public boolean isEmprestada() {
        return emprestada;
    }

    public void alterarEmprestimo() {
        this.emprestada = !this.emprestada;
    }

}
