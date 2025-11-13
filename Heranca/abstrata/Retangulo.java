public class Retangulo extends FormaGeometrica {
    protected double largura;  // mudou de private para protected
    protected double altura;   // mudou de private para protected

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

    @Override
    public double area() {
        return this.largura * this.altura;
    }

    @Override
    public String toString() {
        return String.format("[Retangulo] %.2f / %.2f", this.largura, this.altura);
    }
}