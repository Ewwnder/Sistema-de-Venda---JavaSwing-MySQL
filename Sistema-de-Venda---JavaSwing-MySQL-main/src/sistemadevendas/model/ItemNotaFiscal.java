package sistemadevendas.model;

/**
 *
 * @author LucasMorais
 */
public class ItemNotaFiscal {
    
    private int idItemNotaFiscal;
    private NotaFiscal notaFiscal;
    private Produto produto;
    private int quantidade;
    private double valorUnitario;

    public int getIdItemNotaFiscal() {
        return idItemNotaFiscal;
    }

    public void setIdItemNotaFiscal(int idItemNotaFiscal) {
        this.idItemNotaFiscal = idItemNotaFiscal;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    
}
