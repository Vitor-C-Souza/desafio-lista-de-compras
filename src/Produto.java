public class Produto implements Comparable<Produto> {
    private final String descricao;
    private final double preco;

    public Produto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return descricao + " - R$" + preco;
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return Double.compare(this.getPreco(), outroProduto.getPreco());
    }
}

