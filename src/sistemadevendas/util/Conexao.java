
package sistemadevendas.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LucasMorais
 */
public class Conexao {
 
    public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancodadosprogsql?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Conexão realizada com sucesso!");
            return conn;
<<<<<<< HEAD
        } catch(Exception e){        
            e.printStackTrace();
=======

        } catch(Exception e){        
                e.printStackTrace();
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
            System.out.println("Não foi possível realizar a conexão");
            return null;
         }
    
    }
}
