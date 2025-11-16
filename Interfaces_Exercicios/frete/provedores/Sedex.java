package provedores;

public class Sedex implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double valorFrete;
        double pesoEmKg = peso / 1000.0;
        
        if (pesoEmKg > 1) {
            valorFrete = valor * 0.10;
        } else {
            valorFrete = valor * 0.05;
        }
        
        return new Frete(valorFrete, obterTipoProvedorFrete());
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}