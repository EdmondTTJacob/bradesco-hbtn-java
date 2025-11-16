import produtos.Produto;
public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double subtotal = 0;

        for (ItemPedido item : itens) {
            double precoLiquido = item.getProduto().obterPrecoLiquido();
            double valorItem = precoLiquido * item.getQuantidade();
            subtotal += valorItem;
        }

        double valorDesconto = subtotal * (percentualDesconto / 100.0);
        double total = subtotal - valorDesconto;

        return total;
    }
}