
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
        Cliente cliente = clienteDAO.buscarPorId(id);
        if(cliente==null){
            throw new RuntimeException("Cliente não encontrado");
        }
        return cliente;
        
    }
}
