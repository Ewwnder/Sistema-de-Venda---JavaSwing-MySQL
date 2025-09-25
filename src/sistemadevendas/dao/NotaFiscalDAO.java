
package sistemadevendas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.model.Cliente;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.util.Conexao;

/**
 *
 * @author LucasMorais
 */
public class NotaFiscalDAO {
    private Conexao conexao;
    private Connection conn;
    
    
    public NotaFiscalDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
       }
    
    public NotaFiscal buscarNotaFiscalPorId(int id){
        String sql = "SELECT * FROM Nota_Fiscal WHERE id_nota_fiscal = ?";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.first()){
                return null;
            }
            NotaFiscal nf = new NotaFiscal();
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("id_cliente"));
            nf.setIdNotaFiscal(id);
            nf.setCliente(cliente);
            java.util.Date utilDate = rs.getDate("data_emissao");
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            nf.setDataEmissao(sqlDate);
            nf.setValorTotal(rs.getDouble("valor_total"));
            return nf;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar nota fiscal pelo id: " + ex.getMessage());
            return null;
        }
    
    }     
    public void criarNotaFiscal(NotaFiscal nf){
        String sql = "INSERT INTO Nota_Fiscal(id_cliente, data_emissao, valor_total) VALUES (?, ?, ?)";
        
        try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            stmt.setInt(1, nf.getCliente().getIdCliente());
            stmt.setDate(2, sqlDate);
            stmt.setDouble(3, 0.0);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível criar uma nota Fiscal: " + ex.getMessage());
        }
    }
    
    public List<NotaFiscal> listarNotasFiscais(){
        String sql = "SELECT * FROM Nota_Fiscal";
        List<NotaFiscal> listaNfs = new ArrayList<NotaFiscal>();
        
        try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){
                 NotaFiscal nf = new NotaFiscal();
                 Cliente cliente = new Cliente();
                 cliente.setIdCliente(rs.getInt("id_cliente"));
                 nf.setCliente(cliente);
                 nf.setDataEmissao(rs.getDate("data_emissao"));
                 nf.setValorTotal(rs.getDouble("valor_total"));
                 
                 listaNfs.add(nf);
             }
             
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Houve um erro na hora de listar as Notas Fiscais: " + ex.getMessage());
        }
        
        return listaNfs;
    }
       
}
