
package sistemadevendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
=======
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.exceptions.FalhaItemNotaFiscalException;
import sistemadevendas.exceptions.FalhaNotaFiscalException;
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
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
    
<<<<<<< HEAD
    public void criarItemNotaFiscal(Produto produto, NotaFiscal notaFiscal, int quantidade){
        String sql = "INSERT INTO Item_Nota_Fiscal(id_nota_fiscal, id_produto, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";
        
        try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setInt(1, notaFiscal.getIdNotaFiscal());
            stmt.setInt(2, produto.getIdProduto());
            stmt.setInt(3, quantidade);
            stmt.setDouble(4, produto.getPrecoVenda());
            int criarNF = stmt.executeUpdate();
            
            if(criarNF>0){
                atualizarValorTotal(notaFiscal);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível criar um item na Nota Fiscal: " + ex.getMessage());
        }
    }
    
    private void atualizarValorTotal(NotaFiscal nf){
        String sqlUpdate = "UPDATE Nota_Fiscal " + "SET valor_total = (SELECT COALESCE(SUM(quantidade*valor_unitario), 0) " +
        "FROM Item_Nota_Fiscal WHERE id_nota_fiscal = ?)" + "WHERE id_nota_fiscal = ?";
        
         try (PreparedStatement stmtUpdate = this.conn.prepareStatement(sqlUpdate)){
                stmtUpdate.setInt(1, nf.getIdNotaFiscal());
                stmtUpdate.setInt(2, nf.getIdNotaFiscal());
                stmtUpdate.executeUpdate();
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Não foi possível atualizar o valor total da Nota Fiscal: " + ex.getMessage());
         }
    }
    
    public boolean removerItemNotaFiscal(ItemNotaFiscal itemNf){
        String sqlDelete = "DELETE FROM Item_Nota_Fiscal WHERE id_item_nota_fiscal = ?";
       
        
        try (PreparedStatement stmtDelete = this.conn.prepareStatement(sqlDelete)){
            stmtDelete.setInt(1, itemNf.getIdItemNotaFiscal());
            int removido = stmtDelete.executeUpdate();
            
            if(removido>0){
                atualizarValorTotal(itemNf.getNotaFiscal());
            }
            return removido>0;
 
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao remover o produto: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean atualizarQuantidadeItemNotaFiscal(ItemNotaFiscal itemNF, int quantidade){
        String sql = "UPDATE Item_Nota_Fiscal SET quantidade = ? WHERE id_item_nota_fiscal = ?";

        try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setInt(1, quantidade);
            stmt.setInt(2, itemNF.getIdItemNotaFiscal());
            int atualizado = stmt.executeUpdate();
            if(atualizado>0){
                atualizarValorTotal(itemNF.getNotaFiscal());
            }
            return atualizado>0;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a quantidade do item da nota fiscal: " + ex.getMessage());
            return false;
        }
        
    }
    
    public List<ItemNotaFiscal> listarItemsNotaFiscal(NotaFiscal nf){
        
        String sql = "SELECT * FROM Item_Nota_Fiscal WHERE id_nota_fiscal = ?";
=======
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
         
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        List<ItemNotaFiscal> items = new ArrayList<ItemNotaFiscal>();
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
             stmt.setInt(1, nf.getIdNotaFiscal());
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){
                 ItemNotaFiscal itemNF = new ItemNotaFiscal();
<<<<<<< HEAD
                 itemNF.setIdItemNotaFiscal(rs.getInt("id_item_nota_fiscal"));
=======
            
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
                 itemNF.setNotaFiscal(nf);
                 
                 Produto prod = new Produto();
                 prod.setIdProduto(rs.getInt("id_produto"));
<<<<<<< HEAD
                 itemNF.setProduto(prod);
                 
                 itemNF.setQuantidade(rs.getInt("quantidade"));
                 itemNF.setValorUnitario(prod.getPrecoVenda());
                 items.add(itemNF);
             }
             
        }catch(SQLException ex){
              JOptionPane.showMessageDialog(null, "Não foi possível listar os items da nota fiscal: " + ex.getMessage());
              
        }
        return items;
=======
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
        
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
    }
}
