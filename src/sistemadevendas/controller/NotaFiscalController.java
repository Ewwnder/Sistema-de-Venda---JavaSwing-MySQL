
package sistemadevendas.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.services.NotaFiscalService;



/**
 *
 * @author LucasMorais
 */
public class NotaFiscalController {
    private NotaFiscalService notaFiscalService = new NotaFiscalService();
    
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
    }
}
