public class PersonagemGame {
    private int saudeAtual;
    private String nome;

    public int getSaudeAtual() {
        return this.saudeAtual;
    }

    public void setSaudeAtual(int valor) {
        this.saudeAtual = valor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nomePersonagem) {
        this.nome = nomePersonagem;
    }

    public void tomarDano(int quantidadeDeDano) {
        this.saudeAtual -= quantidadeDeDano;
        if (this.saudeAtual < 0) {
            this.saudeAtual = 0;
        }
    }

    public void receberCura(int quantidadeDeCura) {
        this.saudeAtual += quantidadeDeCura;
        if (this.saudeAtual > 100) {
            this.saudeAtual = 100;
        }
    }
}