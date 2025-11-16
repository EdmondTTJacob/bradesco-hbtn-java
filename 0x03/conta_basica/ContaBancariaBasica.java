import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        saldo = saldo + valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if (valor > saldo) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        saldo = saldo - valor;
    }

    public double calcularTarifaMensal() {
        double opcao1 = 10.00;
        double opcao2 = saldo * 0.10;
        
        if (opcao1 < opcao2) {
            return opcao1;
        } else {
            return opcao2;
        }
    }

    public double calcularJurosMensal() {
        if (saldo < 0) {
            return 0;
        }
        
        double taxaMensal = taxaJurosAnual / 12.0;
        double juros = saldo * (taxaMensal / 100.0);
        return juros;
    }

    public void aplicarAtualizacaoMensal() {
        double tarifa = calcularTarifaMensal();
        double juros = calcularJurosMensal();
        
        saldo = saldo - tarifa + juros;
    }
}