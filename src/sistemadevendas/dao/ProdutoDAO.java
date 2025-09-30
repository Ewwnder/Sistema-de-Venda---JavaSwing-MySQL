package sistemadevendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemadevendas.exceptions.FalhaProdutoException;
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
    
    
    public boolean atualizarEstoque(Produto produto, int estoque) throws FalhaProdutoException{
        String sql = "UPDATE Produto SET quantidade = ? WHERE id_produto = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setInt(1, estoque);
            stmt.setInt(2, produto.getIdProduto());
            
            int atualizado = stmt.executeUpdate();
            return atualizado >0;
            
        } catch (SQLException ex){
            throw new FalhaProdutoException("Erro de SQL ao atualizar estoque de produto - " + ex.getMessage(), ex);
        }
    }
    
    public void adicionarProduto(Produto produto) throws FalhaProdutoException {
        
        String sql = "INSERT INTO Produto (nome_produto, descricao, preco_venda, quantidade) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidade());
            
            stmt.executeUpdate();
            
        } catch(SQLException ex){
            throw new FalhaProdutoException("Erro de SQL ao cadastrar produto - " + ex.getMessage(), ex);
            
        }
    }
    
    public Produto buscarPorNome(String nome) throws FalhaProdutoException{
        String sql = "SELECT * FROM Produto WHERE nome_produto = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.first()){
                return null;
            }
            
            Produto p = new Produto();
            p.setIdProduto(rs.getInt("id_produto"));
            p.setNomeProduto(nome);
            p.setDescricao(rs.getString("descricao"));
            p.setPrecoVenda(rs.getDouble("preco_venda"));
            p.setQuantidade(rs.getInt("quantidade"));
            return p;
           
        }catch(SQLException ex){
            throw new FalhaProdutoException("Erro de SQL ao buscar produto por nome - " + ex.getMessage(), ex);
            
        }
        
    }
    
     
    public Produto buscarPorId(int id) throws FalhaProdutoException{
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
            throw new FalhaProdutoException("Erro de SQL ao buscar produto por id - " + ex.getMessage(), ex);
        }
    }
    
    public boolean removerProduto(int id) throws FalhaProdutoException{
        String sql = "DELETE FROM Produto WHERE id_produto = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            int removido = stmt.executeUpdate();
            return removido>0;
 
        } catch (SQLException ex){
            throw new FalhaProdutoException("Erro de SQL ao deletar produto - " + ex.getMessage(), ex);
        }
      
    }
    
    
    public boolean editarProduto(Produto produto) throws FalhaProdutoException{
        String sql = "UPDATE Produto SET nome_produto = ?, descricao = ?, preco_venda = ?, quantidade = ? WHERE id_produto = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getIdProduto());
            
            int att = stmt.executeUpdate();
            return att>0;
        } catch(SQLException ex){
            throw new FalhaProdutoException("Erro de SQL ao editar produto - " + ex.getMessage(), ex);
        }

    }
    
      public List<Produto> listarProdutos() throws FalhaProdutoException{
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
            
        } catch (SQLException ex){
            throw new FalhaProdutoException("Erro ao listar produtos - " + ex.getMessage(), ex);
        }
        
        return produtos;
    }
}
