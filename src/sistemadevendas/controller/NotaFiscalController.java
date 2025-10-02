
package sistemadevendas.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
<<<<<<< HEAD
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.services.NotaFiscalService;

=======
import sistemadevendas.exceptions.AtualizacaoEstoqueNegativaException;
import sistemadevendas.exceptions.FalhaItemNotaFiscalException;
import sistemadevendas.exceptions.FalhaNotaFiscalException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.IdNegativoException;
import sistemadevendas.exceptions.NaoEncontradoException;
import sistemadevendas.model.ItemNotaFiscal;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.services.NotaFiscalService;
import sistemadevendas.services.ItemNotaFiscalService;
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8


/**
 *
 * @author LucasMorais
 */
public class NotaFiscalController {
    private NotaFiscalService notaFiscalService = new NotaFiscalService();
<<<<<<< HEAD
    
    public NotaFiscal buscarNotaFiscalPorId(int id){
        
        try{
            NotaFiscal nf = notaFiscalService.buscarNotaFiscalPorId(id);
            return nf;
            
        } catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        catch(Exception e){
            return null;
        }  
    }
    
    public void criarNotaFiscal(NotaFiscal nf){
        try{
            notaFiscalService.criarNotaFiscal(nf);
            JOptionPane.showMessageDialog(null, "Nota Fiscal cadastrada com sucesso no banco de dados");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao criar nota Fiscal: " + e.getMessage());
        }
    }
    
    
    public List<NotaFiscal> listarNotasFiscais(){
        try{
            List<NotaFiscal> lista_nf = new ArrayList<NotaFiscal>();
            lista_nf = notaFiscalService.listarNotasFiscais();
            JOptionPane.showMessageDialog(null, "Listagem feita com sucesso! Danadinho");
            
            return lista_nf;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar notas fiscais");
            return null;
        }        
=======
    private ItemNotaFiscalService itemNotaFiscalService = new ItemNotaFiscalService();
    
    public NotaFiscal buscarNotaFiscalPorId(int id) throws IdNegativoException, FalhaNotaFiscalException, NaoEncontradoException{
            
            if(id<=0){
                throw new IdNegativoException("Id não pode ser negativo ou 0.");
            }
            return notaFiscalService.buscarNotaFiscalPorId(id);
    }
    
    public void criarNotaFiscal(NotaFiscal nf, List<ItemNotaFiscal> itens) throws FalhaNotaFiscalException, FalhaProdutoException, NaoEncontradoException, AtualizacaoEstoqueNegativaException, FalhaItemNotaFiscalException{
        if(nf == null){
            throw new NullPointerException("A nota fiscal enviada é nula.");
        }
        
        nf = notaFiscalService.criarNotaFiscal(nf);
        
        for(ItemNotaFiscal item : itens){
            item.setNotaFiscal(nf);
        }
        itemNotaFiscalService.criarItemNotaFiscal(itens);
        
        
       
    }
    
    
    public List<NotaFiscal> listarNotasFiscais() throws FalhaNotaFiscalException{  
        return notaFiscalService.listarNotasFiscais();
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
    }
}
