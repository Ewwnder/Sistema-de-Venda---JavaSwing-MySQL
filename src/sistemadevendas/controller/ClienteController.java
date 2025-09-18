
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
 * @author Nicolas Ap
 */
public class ClienteController {
    
    private ClienteService clienteService = new ClienteService();
    
    public Cliente buscarClientePorId(int id) throws IdClienteInvalidoException{
        
        if(id<0){
            throw new IdClienteInvalidoException("Id não pode ser negativo");
        }
        
        try{
            Cliente c = clienteService.buscarClientePorId(id);
            return c;
            
        } catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch(Exception e){
            
            return null;
        }  
    }
    
    public void adicionarCliente(Cliente cliente){
        try{
            clienteService.adicionarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso no banco de dados");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar cliente: " + e.getMessage());
        }
    }
    
}
