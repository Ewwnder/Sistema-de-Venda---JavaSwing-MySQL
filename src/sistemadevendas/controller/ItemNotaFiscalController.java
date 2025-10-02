package sistemadevendas.controller;


import java.util.List;
import sistemadevendas.exceptions.AtualizacaoEstoqueNegativaException;
import sistemadevendas.exceptions.FalhaItemNotaFiscalException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.ListaItemNotaException;
import sistemadevendas.exceptions.NaoEncontradoException;
import sistemadevendas.model.ItemNotaFiscal;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.services.ItemNotaFiscalService;


/**
 *
 * @author LucasMorais
 */
public class ItemNotaFiscalController {
     private ItemNotaFiscalService itemNotaFiscalService = new ItemNotaFiscalService();
    
    public void criarItemNotaFiscal(List<ItemNotaFiscal> lista_itens) throws FalhaItemNotaFiscalException, AtualizacaoEstoqueNegativaException, FalhaProdutoException, NaoEncontradoException, ListaItemNotaException{
        
        if(lista_itens.isEmpty()){
            throw new ListaItemNotaException("A lista de itens esta vazia");
        }
        
        itemNotaFiscalService.criarItemNotaFiscal(lista_itens);
        
    }
    
     public List<ItemNotaFiscal> listarNotasFiscais(NotaFiscal nf) throws FalhaItemNotaFiscalException{
        
        return itemNotaFiscalService.listarNotasFiscais(nf);

    }
    
}
