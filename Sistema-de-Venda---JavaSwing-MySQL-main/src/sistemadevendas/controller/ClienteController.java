
package sistemadevendas.controller;

import java.util.List;
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
    
    public void adicionarCliente(Cliente cliente){
        try{
            clienteService.adicionarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso no banco de dados");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar cliente: " + e.getMessage());
        }
    }
    
    
    public void removerCliente(int id){
         clienteService.removerCliente(id);
    }
    
    public void editarCliente(Cliente cliente){
        clienteService.editarCliente(cliente);
    }
    
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }
    
}
