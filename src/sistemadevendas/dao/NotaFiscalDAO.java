
package sistemadevendas.dao;

import java.sql.Connection;
import sistemadevendas.util.Conexao;

/**
 *
 * @author LucasMorais
 */
public class NotaFiscalDAO {
    private Conexao conexao;
    private Connection conn;
    
    
    public NotaFiscalDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
       }
    
    public void criarNotaFiscal(){
        String sql = "INSERT INTO "
    }
       
}
