package Classes_Objetos.consistencia;
public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public PersonagemGame(int saudeInicial, String nomeInicial) {
        this.nome = nomeInicial;
        this.setSaudeAtual(saudeInicial);
    }

    public int getSaudeAtual() {
        return this.saudeAtual;
    }

    public void setSaudeAtual(int valor) {
        this.saudeAtual = valor;
        if (this.saudeAtual > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nomePersonagem) {
        if (nomePersonagem != null && !nomePersonagem.isEmpty()) {
            this.nome = nomePersonagem;
        }
    }

    public String getStatus() {
        return this.status;
    }

    public void tomarDano(int quantidadeDeDano) {
        int novaSaude = this.saudeAtual - quantidadeDeDano;
        if (novaSaude < 0) {
            novaSaude = 0;
        }
        this.setSaudeAtual(novaSaude);
    }

    public void receberCura(int quantidadeDeCura) {
        int novaSaude = this.saudeAtual + quantidadeDeCura;
        if (novaSaude > 100) {
            novaSaude = 100;
        }
        this.setSaudeAtual(novaSaude);
    }
}