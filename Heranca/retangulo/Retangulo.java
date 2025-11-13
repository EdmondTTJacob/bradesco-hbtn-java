public class Retangulo extends FormaGeometrica {
    private double largura;
    private double altura;

    public double getLargura() {
        return this.largura;
    }

    public void setLargura(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Largura deve ser maior ou igual a 0");
        }
        this.largura = valor;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Altura deve ser maior ou igual a 0");
        }
        this.altura = valor;
    }
}