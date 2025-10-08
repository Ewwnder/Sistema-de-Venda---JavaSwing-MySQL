
package sistemadevendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistemadevendas.exceptions.FalhaClienteException;
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
    
    public void criarCliente(Cliente cliente) throws FalhaClienteException{
        String sql = "INSERT INTO Cliente (nome_cliente, email, telefone) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            
            stmt.executeUpdate();
           

        } catch(SQLException ex){
           throw new FalhaClienteException("Erro de SQL ao cadastrar - " + ex.getMessage(), ex);
          
        }
    }
    
    public Cliente buscarPorId(int id) throws FalhaClienteException{
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
            

        } catch(SQLException ex){
            throw new FalhaClienteException("Erro de SQL ao buscar por id - " + ex.getMessage(), ex);
        }
    }
    
    public Cliente buscarPorEmail(String email) throws FalhaClienteException{
        String sql = "SELECT * FROM Cliente WHERE email = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.first()){
                return null;
            }
            Cliente c = new Cliente();
            rs.first();

            c.setIdCliente(rs.getInt("id_cliente"));
            c.setNomeCliente(rs.getString("nome_cliente"));
            c.setEmail(email);
            c.setTelefone(rs.getString("telefone"));
            return c;
        }catch(SQLException ex){
           throw new FalhaClienteException("Erro de SQL ao buscar por email - " + ex.getMessage(), ex);
        
        }   
    }
    
    
    public boolean removerCliente(int id) throws FalhaClienteException{
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            int removido = stmt.executeUpdate();
            return removido>0;
 
        } catch (SQLException ex){
            throw new FalhaClienteException("Erro de SQL ao remover - " + ex.getMessage(), ex);
        }

    }
      
    public boolean editarCliente(Cliente cliente) throws FalhaClienteException{
        String sql = "UPDATE Cliente SET nome_cliente = ?, email = ?, telefone = ? WHERE id_cliente = ?";
        
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getIdCliente());
            
            int att = stmt.executeUpdate();
            return att>0;
        } catch(SQLException ex){
           throw new FalhaClienteException("Erro de SQL ao editar - " + ex.getMessage(), ex); 
        }

    }
    
    public List<Cliente> listarClientes() throws FalhaClienteException{
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
            
        } catch (SQLException ex){
            throw new FalhaClienteException("Erro de SQL ao listar - " + ex.getMessage(), ex);
        }
        
        return clientes;
    }

}
