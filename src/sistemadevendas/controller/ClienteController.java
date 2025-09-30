
package sistemadevendas.controller;


import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistemadevendas.exceptions.ClienteExistenteException;
import sistemadevendas.exceptions.ClienteNaoEncontradoException;
import sistemadevendas.exceptions.FalhaClienteException;
import sistemadevendas.model.Cliente;
import sistemadevendas.services.ClienteService;
import sistemadevendas.exceptions.IdNegativoException;

/**
 *
 * @author Nicolas Ap
 */
public class ClienteController {
    
    private ClienteService clienteService = new ClienteService();
    
    public Cliente buscarClientePorId(int id) throws IdNegativoException, ClienteNaoEncontradoException, FalhaClienteException{
        
        if(id<=0){
            throw new IdNegativoException("O Id não pode ser negativo.");
        }
        
        Cliente c = clienteService.buscarClientePorId(id);
        return c;
       
    }
    
    public void adicionarCliente(Cliente cliente) throws ClienteExistenteException, FalhaClienteException{
        
        if(cliente == null){
            throw new NullPointerException("O cliente que está sendo adicionado é nulo");
        }
        
        clienteService.adicionarCliente(cliente);
        
    }
       
    public void removerCliente(int id) throws IdNegativoException, ClienteNaoEncontradoException, FalhaClienteException{
        
        if(id<=0){
            throw new IdNegativoException("O Id não pode ser negativo.");
        }
        clienteService.removerCliente(id);
         
    }
    
    public void editarCliente(Cliente cliente) throws ClienteNaoEncontradoException, IdNegativoException, FalhaClienteException, ClienteExistenteException{
       
        if(cliente.getIdCliente()<=0){
            throw new IdNegativoException("O Id não pode ser negativo.");
        }
        
        clienteService.editarCliente(cliente);
    }
    
    public List<Cliente> listarClientes() throws FalhaClienteException{
        return clienteService.listarClientes();
    }
    
}
