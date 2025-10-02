package sistemadevendas.controller;

<<<<<<< HEAD
=======

import java.util.List;
import sistemadevendas.exceptions.AtualizacaoEstoqueNegativaException;
import sistemadevendas.exceptions.FalhaItemNotaFiscalException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.NaoEncontradoException;
import sistemadevendas.model.ItemNotaFiscal;
import sistemadevendas.model.NotaFiscal;
import sistemadevendas.services.ItemNotaFiscalService;


>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
/**
 *
 * @author LucasMorais
 */
public class ItemNotaFiscalController {
<<<<<<< HEAD
=======
     private ItemNotaFiscalService itemNotaFiscalService = new ItemNotaFiscalService();
    
    public void criarItemNotaFiscal(List<ItemNotaFiscal> lista_itens) throws FalhaItemNotaFiscalException, AtualizacaoEstoqueNegativaException, FalhaProdutoException, NaoEncontradoException{
        
        if(lista_itens.isEmpty()){
            throw new ListaItemNotaException("A lista de itens esta vazia");
        }
        
        itemNotaFiscalService.criarItemNotaFiscal(lista_itens);
        
    }
    
     public List<ItemNotaFiscal> listarNotasFiscais(NotaFiscal nf) throws FalhaItemNotaFiscalException{
        
        return itemNotaFiscalService.listarNotasFiscais(nf);

    }
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
    
}
