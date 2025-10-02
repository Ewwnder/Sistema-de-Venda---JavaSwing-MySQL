package sistemadevendas.controller;

import java.util.List;
import sistemadevendas.exceptions.ExistenteException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.IdNegativoException;
import sistemadevendas.exceptions.NaoEncontradoException;
import sistemadevendas.model.Produto;
import sistemadevendas.services.ProdutoService;

/**
 *
 * @author LucasMorais
 */
public class ProdutoController {
    
    private ProdutoService produtoService = new ProdutoService();
    
    public Produto buscarProdutoPorId(int id) throws IdNegativoException, FalhaProdutoException, NaoEncontradoException{
        
        if(id<=0){
            throw new IdNegativoException("O Id não pode ser negativo.");
        }
        
      
        Produto p = produtoService.buscarProdutoPorId(id);
        return p;
            

    }
    
    public void adicionarProduto(Produto produto) throws ExistenteException, FalhaProdutoException{
        if(produto == null){
            throw new NullPointerException("O produto que está sendo adicionado é nulo");
        }
        produtoService.adicionarProduto(produto);
        
    }
    
    public void removerProduto(int id) throws IdNegativoException, FalhaProdutoException, NaoEncontradoException{
        
        if(id<=0){
            throw new IdNegativoException("O Id não pode ser negativo.");
        }
        produtoService.removerProduto(id);  
        
         
    }
    
    public void editarProduto(Produto produto) throws IdNegativoException, ExistenteException, FalhaProdutoException, NaoEncontradoException{
        
        if(produto.getIdProduto()<=0){
            throw new IdNegativoException("O Id não pode ser negativo.");
        }
        
        produtoService.editarProduto(produto);
        
 
    }
    
    public List<Produto> listarProdutos() throws FalhaProdutoException{
        return produtoService.listarProdutos();
    }
}
