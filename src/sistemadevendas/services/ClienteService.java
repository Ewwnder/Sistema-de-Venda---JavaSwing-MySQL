
package sistemadevendas.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import sistemadevendas.dao.ClienteDAO;
import sistemadevendas.model.Cliente;

/**
 *
 * @author LucasMorais
 */
public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public Cliente buscarClientePorId(int id)
    {
        if (id < 0) {
        throw new IllegalArgumentException("ID não pode ser negativo");
        }
        
        Cliente cliente = clienteDAO.buscarPorId(id);
        if(cliente==null){
            throw new RuntimeException("Cliente não encontrado");
        }
        return cliente;
        
    }
    
    public void adicionarCliente(Cliente cliente){
        clienteDAO.criarCliente(cliente);
    }

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
        }
        
        boolean success = clienteDAO.editarCliente(cliente);
        
        if (!success){
            throw new RuntimeException("Falha ao editar o cliente no banco.");
        }
    }
}
