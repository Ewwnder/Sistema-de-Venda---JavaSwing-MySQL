
package sistemadevendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.exceptions.FalhaItemNotaFiscalException;
import sistemadevendas.exceptions.FalhaNotaFiscalException;
import sistemadevendas.model.ItemNotaFiscal;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.model.Produto;
import sistemadevendas.util.Conexao;

/**
 *
 * @author LucasMorais
 */
public class ItemNotaFiscalDAO {
    private Conexao conexao;
    private Connection conn;
    
    
    public ItemNotaFiscalDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void criarItemNotaFiscal(Produto produto, NotaFiscal notaFiscal, int quantidade) throws FalhaItemNotaFiscalException{
        
        if(quantidade<=0){
            throw new FalhaItemNotaFiscalException("Quantidade deve ser maior que 0");
        }
        
        String sql = "INSERT INTO Item_Nota_Fiscal(id_nota_fiscal, id_produto, quantidade) VALUES (?, ?, ?)";
        String sqlUpdateNotaFiscal = "UPDATE Nota_Fiscal SET valor_total = valor_total + ? WHERE id_nota_fiscal = ?";
        try(PreparedStatement stmtItem  = this.conn.prepareStatement(sql)){
            PreparedStatement stmtUpdateNF = this.conn.prepareStatement(sqlUpdateNotaFiscal);
            stmtItem .setInt(1, notaFiscal.getIdNotaFiscal());
            stmtItem .setInt(2, produto.getIdProduto());
            stmtItem .setInt(3, quantidade);
            stmtItem .executeUpdate();
           
            
            double subtotal = produto.getPrecoVenda()* quantidade; 
            stmtUpdateNF.setDouble(1, subtotal);
            stmtUpdateNF.setInt(2, notaFiscal.getIdNotaFiscal());
            stmtUpdateNF.executeUpdate();

        }catch(SQLException ex){
            throw new FalhaItemNotaFiscalException("Erro de SQL ao inserir Item Nota Fiscal -" + ex.getMessage(), ex);
        }
    }
    
 
   
  
    public List<ItemNotaFiscal> listarItemsNotaFiscal(NotaFiscal nf) throws FalhaItemNotaFiscalException{
        
        String sql = "SELECT inf.*, p.nome_produto, p.preco_venda " +
                 "FROM Item_Nota_Fiscal inf " +
                 "INNER JOIN Produto p ON p.id_produto = inf.id_produto " +
                 "WHERE inf.id_nota_fiscal = ?";
         
        List<ItemNotaFiscal> items = new ArrayList<ItemNotaFiscal>();
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
             stmt.setInt(1, nf.getIdNotaFiscal());
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){
                 ItemNotaFiscal itemNF = new ItemNotaFiscal();
            
                 itemNF.setNotaFiscal(nf);
                 
                 Produto prod = new Produto();
                 prod.setIdProduto(rs.getInt("id_produto"));
                 prod.setNomeProduto(rs.getString("nome_produto"));
                 prod.setPrecoVenda(rs.getDouble("preco_venda"));
                 
                 itemNF.setProduto(prod);
                 itemNF.setQuantidade(rs.getInt("quantidade"));
                 
                 items.add(itemNF);
             }
             return items;
        }catch(SQLException ex){
              throw new FalhaItemNotaFiscalException("Erro de SQL ao listar Itens da Nota Fiscal -" + ex.getMessage(), ex);
              
        }
        
    }
}
