
package sistemadevendas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
=======
import java.sql.Statement;
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
<<<<<<< HEAD
import sistemadevendas.model.Cliente;
import sistemadevendas.model.NotaFiscal;
=======
import sistemadevendas.exceptions.FalhaNotaFiscalException;
import sistemadevendas.model.Cliente;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.model.Produto;
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
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
    
<<<<<<< HEAD
    public NotaFiscal buscarNotaFiscalPorId(int id){
        String sql = "SELECT * FROM Nota_Fiscal WHERE id_nota_fiscal = ?";
=======
    public NotaFiscal buscarNotaFiscalPorId(int id) throws FalhaNotaFiscalException{
        String sql = "SELECT nf.*, c.nome_cliente FROM Nota_Fiscal nf JOIN Cliente c ON c.id_cliente = nf.id_cliente WHERE nf.id_nota_fiscal = ?";
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        
        try(PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.first()){
                return null;
            }
            NotaFiscal nf = new NotaFiscal();
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("id_cliente"));
<<<<<<< HEAD
=======
            cliente.setNomeCliente(rs.getString("nome_cliente"));
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
            nf.setIdNotaFiscal(id);
            nf.setCliente(cliente);
            java.util.Date utilDate = rs.getDate("data_emissao");
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            nf.setDataEmissao(sqlDate);
            nf.setValorTotal(rs.getDouble("valor_total"));
            return nf;
            
        }catch(SQLException ex){
<<<<<<< HEAD
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
=======
            throw new FalhaNotaFiscalException("Erro de SQL ao buscar Nota Fiscal -" +ex.getMessage(), ex);
            
        }
    
    }     
     public NotaFiscal criarNotaFiscal(NotaFiscal nf) throws FalhaNotaFiscalException{
        String sql = "INSERT INTO Nota_Fiscal(id_cliente, data_emissao, valor_total) VALUES (?, ?, ?)";
    
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
     
            stmt.setInt(1, nf.getCliente().getIdCliente());
            stmt.setDate(2, nf.getDataEmissao());
            stmt.setDouble(3, 0.0);
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    nf.setIdNotaFiscal(rs.getInt(1));
                }
            }
            return nf;
              
         }catch (SQLException ex) {
             throw new FalhaNotaFiscalException("Erro de SQL ao criar Nota Fiscal -" +ex.getMessage(), ex);
        }

    }
    
    public List<NotaFiscal> listarNotasFiscais() throws FalhaNotaFiscalException{
        String sql = "SELECT nota_fiscal.*, cliente.nome_cliente FROM nota_fiscal JOIN cliente ON cliente.id_cliente = nota_fiscal.id_cliente";
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        List<NotaFiscal> listaNfs = new ArrayList<NotaFiscal>();
        
        try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){
<<<<<<< HEAD
                 NotaFiscal nf = new NotaFiscal();
                 Cliente cliente = new Cliente();
                 cliente.setIdCliente(rs.getInt("id_cliente"));
                 nf.setCliente(cliente);
=======
                 Cliente cliente = new Cliente();
                 cliente.setIdCliente(rs.getInt("id_cliente"));
                 cliente.setNomeCliente(rs.getString("nome_cliente"));
                 NotaFiscal nf = new NotaFiscal();
                 nf.setIdNotaFiscal(rs.getInt("id_nota_fiscal"));
                 nf.setCliente(cliente);
                 
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
                 nf.setDataEmissao(rs.getDate("data_emissao"));
                 nf.setValorTotal(rs.getDouble("valor_total"));
                 
                 listaNfs.add(nf);
             }
             
        }catch(SQLException ex){
<<<<<<< HEAD
            JOptionPane.showMessageDialog(null, "Houve um erro na hora de listar as Notas Fiscais: " + ex.getMessage());
=======
             throw new FalhaNotaFiscalException("Erro de SQL ao listar Notas Fiscais -" +ex.getMessage(), ex);
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        }
        
        return listaNfs;
    }
       
}
