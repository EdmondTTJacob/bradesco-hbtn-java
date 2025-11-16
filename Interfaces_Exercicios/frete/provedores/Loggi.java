package provedores;

public class Loggi implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double valorFrete;
        double pesoEmKg = peso / 1000.0;
        
        if (pesoEmKg > 5) {
            valorFrete = valor * 0.12;
        } else {
            valorFrete = valor * 0.04;
        }
        
        return new Frete(valorFrete, obterTipoProvedorFrete());
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
}