import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos;

    public GestaoAlunos() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        Aluno novoAluno = new Aluno(nome, idade);
        alunos.add(novoAluno);
        System.out.println("Aluno adicionado: " + nome);
    }

    public void excluirAluno(String nome) {
        boolean encontrado = false;
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNome().equals(nome)) {
                alunos.remove(i);
                System.out.println("Aluno removido: " + nome);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno nao encontrado: " + nome);
        }
    }

    public void buscarAluno(String nome) {
        boolean encontrado = false;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno nao encontrado: " + nome);
        }
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de alunos:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        gestao.adicionarAluno("Carlos", 20);
        gestao.adicionarAluno("Ana", 22);
        gestao.adicionarAluno("Pedro", 19);

        System.out.println();
        gestao.listarAlunos();

        System.out.println();
        gestao.buscarAluno("Ana");

        System.out.println();
        gestao.excluirAluno("Pedro");

        System.out.println();
        gestao.excluirAluno("Maria");

        System.out.println();
        gestao.buscarAluno("Carlos");

        System.out.println();
        gestao.listarAlunos();
    }
}