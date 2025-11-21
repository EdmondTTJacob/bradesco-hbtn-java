import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;
    private Set<String> emailsUtilizados;

    public GerenciamentoDeContatos() {
        contatos = new HashMap<>();
        emailsUtilizados = new HashSet<>();
    }

    public void adicionarContato(String nome, String telefone, String email) {
        if (contatos.containsKey(nome)) {
            System.out.println("Erro: Contato com nome " + nome + " ja existe!");
            return;
        }

        if (emailsUtilizados.contains(email)) {
            System.out.println("Erro: Email " + email + " ja esta em uso!");
            return;
        }

        Contato novoContato = new Contato(nome);
        novoContato.adicionarTelefone(telefone);
        novoContato.adicionarEmail(email);

        contatos.put(nome, novoContato);
        emailsUtilizados.add(email);

        System.out.println("Contato " + nome + " adicionado com sucesso!");
    }

    public void exibirTodosContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        System.out.println("\nExibindo todos os contatos:");
        for (Contato contato : contatos.values()) {
            System.out.println(contato);
            System.out.println("-------------------------------");
        }
    }

    public void buscarContato(String nome) {
        System.out.println("\nBuscando contato '" + nome + "':");
        if (contatos.containsKey(nome)) {
            Contato contato = contatos.get(nome);
            System.out.println("Contato encontrado: " + nome);
            System.out.println("Telefones: " + contato.getTelefones());
            System.out.println("Emails: " + contato.getEmails());
        } else {
            System.out.println("Contato " + nome + " nao encontrado.");
        }
    }

    public void removerContato(String nome) {
        if (contatos.containsKey(nome)) {
            Contato contato = contatos.remove(nome);
            for (String email : contato.getEmails()) {
                emailsUtilizados.remove(email);
            }
            System.out.println("Contato " + nome + " removido com sucesso!");
        } else {
            System.out.println("Contato " + nome + " nao encontrado.");
        }
    }

    public static void main(String[] args) {
        GerenciamentoDeContatos gerenciamento = new GerenciamentoDeContatos();

        gerenciamento.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gerenciamento.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gerenciamento.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gerenciamento.adicionarContato("Carlos", "9999-9999", "outro@email.com");

        gerenciamento.exibirTodosContatos();

        gerenciamento.buscarContato("Maria");

        System.out.println("\nRemovendo contato 'Carlos':");
        gerenciamento.removerContato("Carlos");

        System.out.println("\nTentando remover contato 'Joao' que nao existe:");
        gerenciamento.removerContato("Joao");

        gerenciamento.exibirTodosContatos();
    }
}
