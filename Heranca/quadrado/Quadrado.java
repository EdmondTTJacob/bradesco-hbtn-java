public class Quadrado extends Retangulo {
    private double lado;

    public double getLado() {
        return this.lado;
    }

    public void setLado(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Lado deve ser maior ou igual a 0");
        }
        this.lado = valor;
        this.largura = valor;
        this.altura = valor;
    }

    @Override
    public String toString() {
        return String.format("[Quadrado] %.2f", this.lado);
    }
}