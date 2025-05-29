import java.util.Hashtable;
import java.util.Scanner;

public class AppHashTable {
    private static Scanner input = new Scanner(System.in);
    private static Hashtable<String, Aluno> alunos = new Hashtable<>();

    public static int menu() {
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar Todos");
        System.out.println("3 - Buscar pela Matrícula");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
        int op = input.nextInt();
        input.nextLine(); // limpar buffer
        return op;
    }

    public static void cadastrar() {
        System.out.println("---Cadastro---");
        System.out.print("Matrícula: ");
        String matricula = input.nextLine();

        if (alunos.containsKey(matricula)) {
            System.out.println("Matrícula já cadastrada.");
            return;
        }

        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Curso: ");
        String curso = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();

        Aluno novoAluno = new Aluno(matricula, nome, curso, email);
        alunos.put(matricula, novoAluno);

        System.out.println("Aluno cadastrado com sucesso.");
    }

    public static void buscar() {
        System.out.println("---Buscar---");
        System.out.print("Matrícula: ");
        String buscarMatricula = input.nextLine();

        if (alunos.containsKey(buscarMatricula)) {
            Aluno a = alunos.get(buscarMatricula);
            System.out.println("Aluno encontrado:");
            System.out.println("Matrícula: " + a.getMatricula());
            System.out.println("Nome: " + a.getNome());
            System.out.println("Curso: " + a.getCurso());
            System.out.println("Email: " + a.getEmail());
        } else {
            System.out.println("Matrícula não cadastrada. Deseja cadastrar?");
            System.out.println("Digite 1 para cadastrar ou qualquer outra tecla para cancelar.");
            String opcao = input.nextLine();

            if (opcao.equals("1")) {
                cadastrar();
            } else {
                System.out.println("Cadastro cancelado.");
            }
        }
    }

    public static void listarTodos() {
        System.out.println("---Lista de Alunos---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno a : alunos.values()) {
                System.out.println("------------------------");
                System.out.println("Matrícula: " + a.getMatricula());
                System.out.println("Nome: " + a.getNome());
                System.out.println("Curso: " + a.getCurso());
                System.out.println("Email: " + a.getEmail());
            }
        }
    }

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listarTodos();
                    break;
                case 3:
                    buscar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
