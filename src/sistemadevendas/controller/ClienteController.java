
package sistemadevendas.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistemadevendas.model.Cliente;
import sistemadevendas.services.ClienteService;
import sistemadevendas.exceptions.IdClienteInvalidoException;

/**
 *
 * @author User
 */
public class ClienteController {
    
    private ClienteService clienteService = new ClienteService();
    
    public Cliente buscarClientePorId(int id){
        
        
        try{
            Cliente c = clienteService.buscarClientePorId(id);
            return c;
            
        } catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        catch(Exception e){
            return null;
        }
        
        
    }
}
