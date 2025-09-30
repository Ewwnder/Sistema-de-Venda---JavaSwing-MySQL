
package sistemadevendas.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import sistemadevendas.dao.ClienteDAO;
import sistemadevendas.exceptions.ExistenteException;
import sistemadevendas.exceptions.FalhaClienteException;
import sistemadevendas.exceptions.NaoEncontradoException;
import sistemadevendas.model.Cliente;

/**
 *
 * @author LucasMorais
 */
public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

       
    
    
    public Cliente buscarClientePorId(int id) throws FalhaClienteException, NaoEncontradoException
    {
        Cliente cliente = clienteDAO.buscarPorId(id);
        
        if(cliente==null){
            throw new NaoEncontradoException("Cliente", id);
        }
        return cliente;
        
    }
    
    public Cliente buscarClientePorEmail(Cliente cliente) throws FalhaClienteException{
        return clienteDAO.buscarPorEmail(cliente.getEmail());
    }
    
    public void adicionarCliente(Cliente cliente) throws FalhaClienteException, ExistenteException{
        
        if(buscarClientePorEmail(cliente)!=null){
            throw new ExistenteException("Cliente", "email", cliente.getEmail());
        }
        
        clienteDAO.criarCliente(cliente);
        
       
    }


    public void removerCliente(int id) throws FalhaClienteException, NaoEncontradoException{
       
        
        boolean success = clienteDAO.removerCliente(id);
        
        if(!success){
            throw new NaoEncontradoException("Cliente", id);
        }
        
    }
    
    public void editarCliente(Cliente cliente) throws FalhaClienteException, NaoEncontradoException, ExistenteException{
        
        Cliente existente = buscarClientePorEmail(cliente);
        
        if(existente!=null && existente.getIdCliente() != cliente.getIdCliente()){
             throw new ExistenteException("Cliente", "email", cliente.getEmail());
        }
        
        boolean success = clienteDAO.editarCliente(cliente);
        
        if (!success){
            throw new NaoEncontradoException("Cliente", cliente.getIdCliente());
        }
    }
    
    public List<Cliente> listarClientes() throws FalhaClienteException{
        return clienteDAO.listarClientes();
    }

}
