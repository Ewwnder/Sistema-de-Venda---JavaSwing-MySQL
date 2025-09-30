
package sistemadevendas.controller;
import java.util.List;
import sistemadevendas.exceptions.ExistenteException;
import sistemadevendas.exceptions.FalhaClienteException;
import sistemadevendas.model.Cliente;
import sistemadevendas.services.ClienteService;
import sistemadevendas.exceptions.IdNegativoException;
import sistemadevendas.exceptions.NaoEncontradoException;

/**
 *
 * @author Nicolas Ap
 */
public class ClienteController {
    
    private ClienteService clienteService = new ClienteService();
    
    public Cliente buscarClientePorId(int id) throws IdNegativoException, FalhaClienteException, NaoEncontradoException{
        
        if(id<=0){
            throw new IdNegativoException("O Id não pode ser negativo.");
        }
        
        Cliente c = clienteService.buscarClientePorId(id);
        return c;
       
    }
    
    public void adicionarCliente(Cliente cliente) throws FalhaClienteException, ExistenteException{
        
        if(cliente == null){
            throw new NullPointerException("O cliente que está sendo adicionado é nulo");
        }
        
        clienteService.adicionarCliente(cliente);
        
    }
       
    public void removerCliente(int id) throws IdNegativoException, FalhaClienteException, NaoEncontradoException{
        
        if(id<=0){
            throw new IdNegativoException("O Id não pode ser negativo.");
        }
        clienteService.removerCliente(id);
         
    }
    
    public void editarCliente(Cliente cliente) throws IdNegativoException, FalhaClienteException, ExistenteException, NaoEncontradoException{
       
        if(cliente.getIdCliente()<=0){
            throw new IdNegativoException("O Id não pode ser negativo.");
        }
        
        clienteService.editarCliente(cliente);
    }
    
    public List<Cliente> listarClientes() throws FalhaClienteException{
        return clienteService.listarClientes();
    }
    
}
