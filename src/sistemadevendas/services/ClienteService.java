
package sistemadevendas.services;

import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.List;
=======

import java.util.List;

>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
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

<<<<<<< HEAD
    public Cliente buscarClientePorId(int id)
=======
       
    
    
    public Cliente buscarClientePorId(int id) throws FalhaClienteException, NaoEncontradoException
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
    {
        if (id < 0) {
        throw new IllegalArgumentException("ID não pode ser negativo");
        }
        
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

<<<<<<< HEAD
    public void removerCliente(int id){
       
        if (id<0){
            throw new IllegalArgumentException("ID não pode ser negativo");
        }
        
        Cliente c = clienteDAO.buscarPorId(id);
        
        if (c==null){
            throw new RuntimeException("Cliente com ID " + id + " não existe");
        }
        
        boolean success = clienteDAO.removerCliente(id);
        
        if (!success){
            throw new RuntimeException("Falha ao remover cliente do banco");
        }
    }
    
    public void editarCliente(Cliente cliente){
        if (cliente.getIdCliente()<=0){
            throw new IllegalArgumentException("ID não pode ser negativo ou zero!");
        }
        
        Cliente ex = clienteDAO.buscarPorId(cliente.getIdCliente());
        
        if (ex==null){
            throw new RuntimeException("Cliente com ID " + cliente.getIdCliente() + " não existe!");
=======

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
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        }
        
        boolean success = clienteDAO.editarCliente(cliente);
        
        if (!success){
<<<<<<< HEAD
            throw new RuntimeException("Falha ao editar o cliente no banco.");
        }
    }
    
    public List<Cliente> listarClientes(){
        return clienteDAO.listarClientes();
    }
=======
            throw new NaoEncontradoException("Cliente", cliente.getIdCliente());
        }
    }
    
    public List<Cliente> listarClientes() throws FalhaClienteException{
        return clienteDAO.listarClientes();
    }

>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
}
