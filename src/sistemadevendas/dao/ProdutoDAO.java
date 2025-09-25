package sistemadevendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.exceptions.ProdutoExisteException;
import sistemadevendas.model.Produto;
import sistemadevendas.util.Conexao;

/**
 *
 * @author LucasMorais
 */
public class ProdutoDAO {
    private Conexao conexao;
    private Connection conn;
    
    
    public ProdutoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void adicionarProduto(Produto produto) {
        
        String sql = "INSERT INTO Produto (nome_produto, descricao, preco_venda, quantidade) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidade());
            
            stmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }
    
    public String buscarPorNome(String nome){
        String sql = "SELECT * FROM Produto WHERE nome_produto = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.first()){
                return null;
            }
            return rs.getString("nome_produto");
           
        }catch(SQLException ex){
            System.out.println("Erro ao buscar produto por nome: " + ex.getMessage());
            return null;
        }
        
    }
    
     
    public Produto buscarPorId(int id){
        String sql = "SELECT * FROM Produto WHERE id_produto = ?";
        
        try{
           PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           stmt.setInt(1, id);
           ResultSet rs = stmt.executeQuery();
           
           if(!rs.first()){
               return null;
           }
           
           Produto p = new Produto();
    
           p.setIdProduto(id);
           p.setNomeProduto(rs.getString("nome_produto"));
           p.setDescricao(rs.getString("descricao"));
           p.setPrecoVenda(rs.getDouble("preco_venda"));
           p.setQuantidade(rs.getInt("quantidade"));
          
           return p;
            
        } catch(SQLException ex){
            System.out.println("Erro ao buscar produto por id: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean removerProduto(int id){
        String sql = "DELETE FROM Produto WHERE id_produto = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            int removido = stmt.executeUpdate();
            return removido>0;
 
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao remover o produto: " + e.getMessage());
            return false;
        }
      
    }
    
    
    public boolean editarProduto(Produto produto){
        String sql = "UPDATE Produto SET nome_produto = ?, descricao = ?, preco_venda = ?, quantidade = ? WHERE id_produto = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getIdProduto());
            
            int att = stmt.executeUpdate();
            return att>0;
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao editar produto: " + e.getMessage());
            return false;
        }

    }
    
      public List<Produto> listarProdutos(){
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "SELECT * FROM Produto";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()){
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoVenda(rs.getDouble("preco_venda"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        }
        
        return produtos;
    }
}
