package sistemadevendas.services;

import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.dao.ItemNotaFiscalDAO;
import sistemadevendas.model.ItemNotaFiscal;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.model.Produto;

/**
 *
 * @author LucasMorais
 */
public class ItemNotaFiscalService {
    
    private ItemNotaFiscalDAO itemNotaFiscalDAO = new ItemNotaFiscalDAO();
    public void criarItemNotaFiscal(Produto produto, NotaFiscal notaFiscal, int quantidade) {
       try{
           itemNotaFiscalDAO.criarItemNotaFiscal(produto, notaFiscal, quantidade);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "ERRO!!!!!!");
       }
    }

    public void removerItemNotaFiscal(ItemNotaFiscal itemNf) {
        try{
           itemNotaFiscalDAO.removerItemNotaFiscal(itemNf);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "ERRO!!!!!!");
       }
    }

    public void atualizarQuantidadeItemNotaFiscal(ItemNotaFiscal itemNF, int quantidade) {
        try{
           itemNotaFiscalDAO.atualizarQuantidadeItemNotaFiscal(itemNF, quantidade);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "ERRO!!!!!!");
       }
    }

    public List<ItemNotaFiscal> listarNotasFiscais(NotaFiscal nf) {
        try{
           return itemNotaFiscalDAO.listarItemsNotaFiscal(nf);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "ERRO!!!!!!");
           return null;
       }
    }
    
}
