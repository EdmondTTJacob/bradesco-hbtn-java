package provedores;

public class JadLog implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double valorFrete;
        double pesoEmKg = peso / 1000.0;
        
        if (pesoEmKg > 2) {
            valorFrete = valor * 0.07;
        } else {
            valorFrete = valor * 0.045;
        }
        
        return new Frete(valorFrete, obterTipoProvedorFrete());
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }
}