package sistemadevendas.model;

/**
 *
 * @author LucasMorais
 */
public class ItemNotaFiscal {
    
    private NotaFiscal notaFiscal;
    private Produto produto;
    private int quantidade;
   

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

    
    
}
