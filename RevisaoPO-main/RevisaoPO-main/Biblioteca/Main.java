package Biblioteca;

import Biblioteca.Usuarios.Bibliotecario;
import Biblioteca.Usuarios.Cliente;
import Biblioteca.Usuarios.Funcionario;
import Biblioteca.Usuarios.Usuario;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo à Biblioteca do Nicolas");
        System.out.println("""
                        1- Cadastro de Usuário
                        2- Login
                        3- Sair"
                        """);
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> cadastroUsuario();
            case 2 -> login();
            case 3 -> System.exit(0);
        }
    }

    public static void cadastroUsuario() {
        System.out.println("");

        Usuario cliente = new Cliente("Nicolas", "nicolasg", "123456");
        Usuario.addUsuario(Cliente);
    }

    private static void login() {
        Usuario usuarioLogado;
        do {
            System.out.println("");
            usuarioLogado = Usuario.login("nicolasg", "123456");
        } while (usuarioLogado == null);
    }

    private static void menuUsuario() {
        System.out.println("""
                1- Alterar nome:
                2- Alterar senha:
                3- Ver empréstimos:
                4- Ver perfil:
                5- Consultar disponibilidade de mídia:
                """);
        if (usuarioLogado instanceof Funcionario) {
            System.out.println("""
                    6- Cadastrar cliente:
                    7- Remover usuário:
                    8- Emprestar mídia:
                    9- Devolução de mídia:
                    10- Ver mídias:
                    """);
            if (usuarioLogado instanceof Bibliotecario) {
                System.out.println("""
                        11- Cadastro de mídia:
                        12- Remover mídia:
                        """);
            }
        }
        System.out.println("0- Logout");
    }
}
