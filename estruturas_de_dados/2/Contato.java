import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Contato {
    private String nome;
    private List<String> telefones;
    private Set<String> emails;

    public Contato(String nome) {
        this.nome = nome;
        this.telefones = new ArrayList<>();
        this.emails = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarTelefone(String telefone) {
        telefones.add(telefone);
    }

    public void adicionarEmail(String email) {
        emails.add(email);
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public Set<String> getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nTelefones: " + telefones + "\nEmails: " + emails;
    }
}