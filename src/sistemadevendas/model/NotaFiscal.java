
package sistemadevendas.model;

import java.sql.Date;

/**
 *
 * @author LucasMorais
 */
public class NotaFiscal {
    private int idNotaFiscal;
    private Cliente cliente;
<<<<<<< HEAD
    private Produto produto;
    private int quantidade;
    private Date dataEmissao;
    private double valorTotal;  

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

    
=======
    private Date dataEmissao;
    private double valorTotal;

>>>>>>> 06a105ef78c799da3adf5f026a472e721347c2b0
    public int getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(int idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
