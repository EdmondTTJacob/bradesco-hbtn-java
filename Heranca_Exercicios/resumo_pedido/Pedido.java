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

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        
        double subtotal = 0;
        
        for (ItemPedido item : itens) {
            String tipo = item.getProduto().getClass().getSimpleName();
            String titulo = item.getProduto().getTitulo();
            double preco = item.getProduto().obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = preco * quantidade;
            
            subtotal += totalItem;
            
            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n", 
                tipo, titulo, preco, quantidade, totalItem);
        }
        
        double valorDesconto = subtotal * (percentualDesconto / 100.0);
        double totalPedido = subtotal - valorDesconto;
        
        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", valorDesconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", subtotal);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalPedido);
        System.out.println("----------------------------");
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }
}