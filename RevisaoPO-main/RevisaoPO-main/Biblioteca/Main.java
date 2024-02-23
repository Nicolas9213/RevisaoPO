package Biblioteca;

import Biblioteca.Midias.DVD;
import Biblioteca.Midias.Jornal;
import Biblioteca.Midias.Livro;
import Biblioteca.Midias.Revista;
import Biblioteca.Usuarios.*;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final Usuario usuario1 = new Bibliotecario("Nicolas", "nicolasag", "123");
    private static final Usuario usuario2 = new Atendente("Mairon", "maironr", "456");

    private static Usuario usuarioLogado;

    public static void main(String[] args) {
        Usuario.addUsuario(usuario1);
        Usuario.addUsuario(usuario2);

        do {
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
        } while (usuarioLogado == null);
    }


    public static void cadastroUsuario() {
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Usuário: ");
        String username = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();

        Usuario usuario = new Cliente(nome, username, senha);
        Usuario.addUsuario(usuario);
    }

    private static void login() {

        do {
            System.out.println("Usuário: ");
            String usuario = sc.next();
            System.out.println("Senha: ");
            String senha = sc.next();

            usuarioLogado = Usuario.login(usuario, senha);
        } while (usuarioLogado == null);
        menuUsuario();
    }

    private static void opcoesUsuario() {
        System.out.println("""
                1- Alterar nome:
                2- Alterar senha:
                3- Ver empréstimos:
                4- Ver perfil:
                5- Consultar disponibilidade de mídia:
                """);
    }

    private static void opcoesFuncionario() {
        System.out.println("""
                    6- Cadastrar cliente:
                    7- Remover usuário:
                    8- Emprestar mídia:
                    9- Devolução de mídia:
                    10- Ver mídias:
                    """);
    }

    private static void opcoesBibliotecario() {
        System.out.println("""
                        11- Cadastro de mídia:
                        12- Remover mídia:
                        """);
    }
    private static void menuUsuario() {
        opcoesUsuario();

        if (usuarioLogado instanceof Funcionario) {
            opcoesFuncionario();

            if (usuarioLogado instanceof Bibliotecario) {
                opcoesBibliotecario();
            }
        }
        System.out.println("0- Logout");

        int escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> alterarNome();
            case 2 -> alterarSenha();
            case 3 -> verEmprestimos();
            case 4 -> verPerfil();
            case 5 -> consultarDisponibilidade();
            case 6 -> cadastroUsuario();
            case 7 -> removerUsuario();
            case 8 -> emprestarMidia();
            case 11 -> cadastroMidia();
        }
    }

    private static void opcoesCadastroMidia() {
        System.out.println("Qual mídia você quer cadastrar: ");
        System.out.println("""
                1- DVD:
                2- Jornal:
                3- Livro:
                4- Revista:
                """);
    }

    private static void cadastroMidia() {
        opcoesCadastroMidia();

        int escolha = sc.nextInt();

        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Código: ");
        int codigo = sc.nextInt();

        if (escolha == 1) {
            Midia midia = new DVD(nome, codigo);
            Midia.addMidia(midia);
        } else if (escolha == 2) {
            Midia midia = new Jornal(nome, codigo);
            Midia.addMidia(midia);
        } else if (escolha == 3) {
            Midia midia = new Livro(nome, codigo);
            Midia.addMidia(midia);
        } else if (escolha == 4) {
            Midia midia = new Revista(nome, codigo);
            Midia.addMidia(midia);
        }
        menuUsuario();

    }

    private static void emprestarMidia() {
        System.out.println("Digite o código da mídia: ");
        int codigo = sc.nextInt();

        Midia midia = Midia.procurarMidia(codigo);
        midia.alterarEmprestimo();
    }

    private static void removerUsuario() {
        System.out.println("Digite o usuário: ");
        String usuario = sc.next();

        Usuario usuarioRemover = Usuario.getUsuarioByUsername(usuario);

        if (usuarioRemover != null) {
            Usuario.removeUsuario(usuarioRemover);
        }
    }

    private static void consultarDisponibilidade() {

        // Falta implementar a consulta de disponibilidade na Midia
        System.out.println("Digite o código da mídia: ");
        String codigo = sc.next();
    }

    private static void verPerfil() {
        System.out.println("------------Perfil-------------");
        System.out.println("Nome: " + usuarioLogado.getNome());
        System.out.println("Usuário: " + usuarioLogado.getUsuario());
    }

    private static void verEmprestimos() {

        // Falta implementar método mostrar empréstimos no Usuario
        if (usuarioLogado instanceof Cliente) {
            Cliente cliente = (Cliente) usuarioLogado;
            cliente.mostrarEmprestimos();
        } else if (usuarioLogado instanceof Funcionario) {
            Funcionario funcionario = (Funcionario) usuarioLogado;
            funcionario.mostrarEmprestimos();
        }
    }

    private static void alterarSenha() {
        System.out.println("Digite a nova senha: ");
        String novaSenha = sc.next();

        usuarioLogado.setSenha(novaSenha);

        System.out.println("Senha alterada com sucesso");
    }

    private static void alterarNome() {
        System.out.println("Digite o novo nome: ");
        String novoNome = sc.next();

        usuarioLogado.setNome(novoNome);

        System.out.println("Nome alterado para: " + novoNome);
    }
}
