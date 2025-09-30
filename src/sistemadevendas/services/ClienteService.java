
package sistemadevendas.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import sistemadevendas.dao.ClienteDAO;
import sistemadevendas.exceptions.ClienteExistenteException;
import sistemadevendas.exceptions.ClienteNaoEncontradoException;
import sistemadevendas.exceptions.FalhaAoBuscarClienteException;
import sistemadevendas.exceptions.FalhaAoCadastrarClienteException;
import sistemadevendas.exceptions.FalhaAoEditarClienteException;
import sistemadevendas.exceptions.FalhaAoListarClientesException;
import sistemadevendas.exceptions.FalhaAoRemoverClienteException;
import sistemadevendas.exceptions.IdNegativoException;
import sistemadevendas.model.Cliente;

/**
 *
 * @author LucasMorais
 */
public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

       
    
    
    public Cliente buscarClientePorId(int id) throws ClienteNaoEncontradoException, FalhaAoBuscarClienteException
    {
        Cliente cliente = clienteDAO.buscarPorId(id);
        
        if(cliente==null){
            throw new ClienteNaoEncontradoException("Cliente de id: " + id + " não foi encontrado no BD");
        }
        return cliente;
        
    }
    
    public void adicionarCliente(Cliente cliente) throws ClienteExistenteException, FalhaAoBuscarClienteException, FalhaAoCadastrarClienteException, FalhaAoCadastrarClienteException{
        
        if(clienteDAO.buscarPorEmail(cliente.getEmail())!=null){
            throw new ClienteExistenteException("Email do Cliente já existe na base de dados.");
        }
        
        clienteDAO.criarCliente(cliente);
        
       
    }


    public void removerCliente(int id) throws ClienteNaoEncontradoException, FalhaAoBuscarClienteException, FalhaAoRemoverClienteException{
       
        
        boolean success = clienteDAO.removerCliente(id);
        
        if(!success){
            throw new ClienteNaoEncontradoException("Cliente com ID " + id + " não existe");
        }
        
    }
    
    public void editarCliente(Cliente cliente) throws FalhaAoEditarClienteException, ClienteNaoEncontradoException, FalhaAoBuscarClienteException, ClienteExistenteException{
        
        Cliente existente = clienteDAO.buscarPorEmail(cliente.getEmail());
        
        if(existente != null && existente.getIdCliente() != cliente.getIdCliente()){
             throw new ClienteExistenteException("Email do Cliente já existe na base de dados.");
        }
        
        boolean success = clienteDAO.editarCliente(cliente);
        
        if (!success){
            throw new ClienteNaoEncontradoException("Cliente com ID " + cliente.getIdCliente() + " não existe");
        }
    }
    
    public List<Cliente> listarClientes() throws FalhaAoListarClientesException{
        return clienteDAO.listarClientes();
    }

}
