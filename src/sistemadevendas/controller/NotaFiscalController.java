
package sistemadevendas.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
import sistemadevendas.services.PdfNotaFiscalService;


/**
 *
 * @author LucasMorais
 */
public class NotaFiscalController {
    private NotaFiscalService notaFiscalService = new NotaFiscalService();
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
    }
    
    public void gerarPdf(int idNota) throws Exception {
        NotaFiscal nf = buscarNotaFiscalPorId(idNota);
        List<ItemNotaFiscal> itens = itemNotaFiscalService.listarNotasFiscais(nf);

        PdfNotaFiscalService pdfService = new PdfNotaFiscalService();
        pdfService.gerarPdf(nf, itens);
    }
}

