
package sistemadevendas.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.exceptions.AtualizacaoEstoqueNegativaException;
import sistemadevendas.exceptions.FalhaNotaFiscalException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.IdNegativoException;
import sistemadevendas.exceptions.NaoEncontradoException;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.services.NotaFiscalService;



/**
 *
 * @author LucasMorais
 */
public class NotaFiscalController {
    private NotaFiscalService notaFiscalService = new NotaFiscalService();
    
    public NotaFiscal buscarNotaFiscalPorId(int id) throws IdNegativoException, FalhaNotaFiscalException, NaoEncontradoException{
            
            if(id<=0){
                throw new IdNegativoException("Id não pode ser negativo ou 0.");
            }
            return notaFiscalService.buscarNotaFiscalPorId(id);
    }
    
    public void criarNotaFiscal(NotaFiscal nf) throws FalhaNotaFiscalException, FalhaProdutoException, NaoEncontradoException, AtualizacaoEstoqueNegativaException{
        if(nf == null){
            throw new NullPointerException("A nota fiscal enviada é nula.");
        }
        
        notaFiscalService.criarNotaFiscal(nf);
        
       
    }
    
    
    public List<NotaFiscal> listarNotasFiscais() throws FalhaNotaFiscalException{  
        return notaFiscalService.listarNotasFiscais();
    }
}
