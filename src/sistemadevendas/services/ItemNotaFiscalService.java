package sistemadevendas.services;

<<<<<<< HEAD
=======
import java.util.List;

import sistemadevendas.dao.ItemNotaFiscalDAO;
import sistemadevendas.exceptions.AtualizacaoEstoqueNegativaException;
import sistemadevendas.exceptions.FalhaItemNotaFiscalException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.NaoEncontradoException;
import sistemadevendas.model.ItemNotaFiscal;
import sistemadevendas.model.NotaFiscal;

>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
/**
 *
 * @author LucasMorais
 */
public class ItemNotaFiscalService {
    
<<<<<<< HEAD
=======
    private ItemNotaFiscalDAO itemNotaFiscalDAO = new ItemNotaFiscalDAO();
    private ProdutoService produtoService = new ProdutoService();
    
    public void criarItemNotaFiscal(List<ItemNotaFiscal> lista_itens) throws FalhaItemNotaFiscalException, AtualizacaoEstoqueNegativaException, FalhaProdutoException, NaoEncontradoException {
       
       for(ItemNotaFiscal item:lista_itens){
           int estoqueAtual = produtoService.verificarEstoque(item.getProduto());
           boolean estoqueAtualizado = produtoService.atualizarEstoqueSeSuficiente(item.getProduto().getIdProduto(), item.getQuantidade());
           if(!estoqueAtualizado){
              throw new AtualizacaoEstoqueNegativaException(item.getProduto().getIdProduto());
           }
            
           itemNotaFiscalDAO.criarItemNotaFiscal(item.getProduto(), item.getNotaFiscal(), item.getQuantidade());
       }
      
    }
    
    public void atualizarValorNotaFiscal(ItemNotaFiscal item){
        
    }

    public List<ItemNotaFiscal> listarNotasFiscais(NotaFiscal nf) throws FalhaItemNotaFiscalException {
      
        return itemNotaFiscalDAO.listarItemsNotaFiscal(nf);
      
    }
    
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
}
