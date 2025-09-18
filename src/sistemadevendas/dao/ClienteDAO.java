
package sistemadevendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistemadevendas.model.Cliente;
import sistemadevendas.util.Conexao;

/**
 *
 * @author Lucas Morais
 */
public class ClienteDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void criarCliente(Cliente cliente){
        String sql = "INSERT INTO Cliente (nome_cliente, email, telefone) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso no banco de dados!");
        } catch(SQLException e){
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }
    
    public Cliente buscarPorId(int id){
        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        
        try{
           PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           stmt.setInt(1, id);
           ResultSet rs = stmt.executeQuery();
           
           if(!rs.first()){
               return null;
           }
           
           Cliente c = new Cliente();
                
           rs.first();
           c.setIdCliente(id);
           c.setNomeCliente(rs.getString("nome_cliente"));
           c.setEmail(rs.getString("email"));
           c.setTelefone(rs.getString("telefone"));
           return c;
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao consultar cliente pro id: ", ex);
        }
      
    }
    
}
