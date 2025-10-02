package sistemadevendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import javax.swing.JOptionPane;
import sistemadevendas.exceptions.ProdutoExisteException;
=======
import sistemadevendas.exceptions.FalhaProdutoException;
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
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
    
<<<<<<< HEAD
    public void adicionarProduto(Produto produto) {
=======
    
  public boolean atualizarEstoqueSeSuficiente(int idProduto, int quantidadeRequerida) throws FalhaProdutoException {
    String sql = "UPDATE Produto SET quantidade = quantidade - ? WHERE id_produto = ? AND quantidade >= ?";
    
    try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
        stmt.setInt(1, quantidadeRequerida);
        stmt.setInt(2, idProduto);
        stmt.setInt(3, quantidadeRequerida);
        
        int atualizado = stmt.executeUpdate();
        return atualizado > 0; 
        
    } catch (SQLException ex) {
        throw new FalhaProdutoException("Erro de SQL ao atualizar estoque de produto - " + ex.getMessage(), ex);
    }
}
    public void adicionarProduto(Produto produto) throws FalhaProdutoException {
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        
        String sql = "INSERT INTO Produto (nome_produto, descricao, preco_venda, quantidade) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidade());
            
            stmt.executeUpdate();
            
<<<<<<< HEAD
        } catch(SQLException e){
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }
    
    public String buscarPorNome(String nome){
=======
        } catch(SQLException ex){
            throw new FalhaProdutoException("Erro de SQL ao cadastrar produto - " + ex.getMessage(), ex);
            
        }
    }
    
    public Produto buscarPorNome(String nome) throws FalhaProdutoException{
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        String sql = "SELECT * FROM Produto WHERE nome_produto = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.first()){
                return null;
            }
<<<<<<< HEAD
            return rs.getString("nome_produto");
           
        }catch(SQLException ex){
            System.out.println("Erro ao buscar produto por nome: " + ex.getMessage());
            return null;
=======
            
            Produto p = new Produto();
            p.setIdProduto(rs.getInt("id_produto"));
            p.setNomeProduto(nome);
            p.setDescricao(rs.getString("descricao"));
            p.setPrecoVenda(rs.getDouble("preco_venda"));
            p.setQuantidade(rs.getInt("quantidade"));
            return p;
           
        }catch(SQLException ex){
            throw new FalhaProdutoException("Erro de SQL ao buscar produto por nome - " + ex.getMessage(), ex);
            
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        }
        
    }
    
     
<<<<<<< HEAD
    public Produto buscarPorId(int id){
=======
    public Produto buscarPorId(int id) throws FalhaProdutoException{
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
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
<<<<<<< HEAD
            System.out.println("Erro ao buscar produto por id: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean removerProduto(int id){
=======
            throw new FalhaProdutoException("Erro de SQL ao buscar produto por id - " + ex.getMessage(), ex);
        }
    }
    
    public boolean removerProduto(int id) throws FalhaProdutoException{
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        String sql = "DELETE FROM Produto WHERE id_produto = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            int removido = stmt.executeUpdate();
            return removido>0;
 
<<<<<<< HEAD
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao remover o produto: " + e.getMessage());
            return false;
=======
        } catch (SQLException ex){
            throw new FalhaProdutoException("Erro de SQL ao deletar produto - " + ex.getMessage(), ex);
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        }
      
    }
    
    
<<<<<<< HEAD
    public boolean editarProduto(Produto produto){
=======
    public boolean editarProduto(Produto produto) throws FalhaProdutoException{
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        String sql = "UPDATE Produto SET nome_produto = ?, descricao = ?, preco_venda = ?, quantidade = ? WHERE id_produto = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getIdProduto());
            
            int att = stmt.executeUpdate();
            return att>0;
<<<<<<< HEAD
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao editar produto: " + e.getMessage());
            return false;
=======
        } catch(SQLException ex){
            throw new FalhaProdutoException("Erro de SQL ao editar produto - " + ex.getMessage(), ex);
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        }

    }
    
<<<<<<< HEAD
      public List<Produto> listarProdutos(){
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "SELECT * FROM Produto";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
=======
      public List<Produto> listarProdutos() throws FalhaProdutoException{
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "SELECT * FROM Produto";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
            
            while (rs.next()){
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoVenda(rs.getDouble("preco_venda"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            
<<<<<<< HEAD
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
=======
        } catch (SQLException ex){
            throw new FalhaProdutoException("Erro ao listar produtos - " + ex.getMessage(), ex);
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        }
        
        return produtos;
    }
<<<<<<< HEAD
=======

    public int verificarEstoque(Produto produto) throws FalhaProdutoException {
       String sql = "SELECT quantidade FROM produto WHERE id_produto = ?";
       try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
           stmt.setInt(1, produto.getIdProduto());
           ResultSet rs = stmt.executeQuery();
           
             
           if(!rs.first()){
               return -1;
           }
      
           int quantidade = rs.getInt("quantidade");
          
           
           return quantidade;
           
       }catch(SQLException ex){
           throw new FalhaProdutoException("Erro ao enviar estoque de produto - " + ex.getMessage(), ex);
       }
    }
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
}
