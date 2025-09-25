package sistemadevendas.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.model.ItemNotaFiscal;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.model.Produto;
import sistemadevendas.services.ItemNotaFiscalService;
import sistemadevendas.services.NotaFiscalService;

/**
 *
 * @author LucasMorais
 */
public class ItemNotaFiscalController {
     private ItemNotaFiscalService itemNotaFiscalService = new ItemNotaFiscalService();
    
    public void criarItemNotaFiscal(Produto produto, NotaFiscal notaFiscal, int quantidade){
        
        try{
            itemNotaFiscalService.criarItemNotaFiscal(produto, notaFiscal, quantidade);
            
            
        } catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }  
        
    }
    
    public boolean removerItemNotaFiscal(ItemNotaFiscal itemNf){
        try{
            itemNotaFiscalService.removerItemNotaFiscal(itemNf);
            return true;
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao remover item da nota Fiscal: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean atualizarQuantidadeItemNotaFiscal(ItemNotaFiscal itemNF, int quantidade){
        try{
            itemNotaFiscalService.atualizarQuantidadeItemNotaFiscal(itemNF, quantidade);
            return true;
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a quantidade do item da nota fiscal");
            return false;
        }        
    }
    
     public List<ItemNotaFiscal> listarNotasFiscais(NotaFiscal nf){
        try{
           return itemNotaFiscalService.listarNotasFiscais(nf);
           
       
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar itens da nota fiscal");
            return null;
        }        
    }
    
}
