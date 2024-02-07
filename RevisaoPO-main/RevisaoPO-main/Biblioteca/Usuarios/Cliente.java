package Biblioteca.Usuarios;

import Biblioteca.*;

public class Cliente extends Usuario {

    public Cliente(String nome, String usuario, String senha) {
        super(nome, usuario, senha);
    }

    @Override
    protected boolean addEmprestimo(Midia midia) {
        int qtd = analiseMidiasEmprestadas(midia);

        if (qtd < 3) {
            emprestimos.add(midia);
            return true;
        }
        return false;
    }
}
