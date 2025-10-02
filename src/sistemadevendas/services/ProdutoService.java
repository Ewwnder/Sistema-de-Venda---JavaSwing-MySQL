package sistemadevendas.services;

import java.util.List;
import sistemadevendas.dao.ProdutoDAO;
import sistemadevendas.exceptions.AtualizacaoEstoqueNegativaException;
import sistemadevendas.exceptions.ExistenteException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.NaoEncontradoException;
import sistemadevendas.model.Produto;

/**
 *
 * @author LucasMorais
 */
public class ProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public void removerProduto(int id) throws FalhaProdutoException, NaoEncontradoException {
        
        boolean success =  produtoDAO.removerProduto(id);
        
        if(!success){
            throw new NaoEncontradoException("Produto", id);
        }
      
    }

    public Produto buscarProdutoPorId(int id) throws FalhaProdutoException, NaoEncontradoException {
   
        Produto produto = produtoDAO.buscarPorId(id);
        
        if(produto==null){
            throw new NaoEncontradoException("Produto", id);
        }
        return produto;
    }
    
    
    public void adicionarProduto(Produto produto) throws ExistenteException, FalhaProdutoException {
            
        
        if(produtoDAO.buscarPorNome(produto.getNomeProduto())!=null){
            throw new ExistenteException("Produto", "nome", produto.getNomeProduto());
        }
          
       produtoDAO.adicionarProduto(produto);
     
    }
    
    public boolean nomeDoProdutoExisteNoBD(Produto produto) throws FalhaProdutoException{
        Produto existente = produtoDAO.buscarPorNome(produto.getNomeProduto());
        return existente!=null && existente.getIdProduto() != produto.getIdProduto();
    }
    

    public void editarProduto(Produto produto) throws ExistenteException, FalhaProdutoException, NaoEncontradoException {
        
        if(nomeDoProdutoExisteNoBD(produto)){
            throw new ExistenteException("Produto", "nome", produto.getNomeProduto());
        }
        
        boolean success = produtoDAO.editarProduto(produto);
        
        if(!success){
            throw new NaoEncontradoException("Produto", produto.getIdProduto());
        }
    }

    public List<Produto> listarProdutos() throws FalhaProdutoException {
        return produtoDAO.listarProdutos();
    }
    
    public boolean atualizarEstoque(Produto produto, int quantidade) throws FalhaProdutoException, NaoEncontradoException, AtualizacaoEstoqueNegativaException{
        boolean success = produtoDAO.atualizarEstoqueSeSuficiente(produto.getIdProduto(), produto.getQuantidade() - quantidade);
        if(!success){
            throw new AtualizacaoEstoqueNegativaException(produto.getIdProduto());
        }
        
        return success;
    }
    
    public int verificarEstoque(Produto produto) throws FalhaProdutoException{
        int quantidade = produtoDAO.verificarEstoque(produto);
        return quantidade;
    }

    public boolean atualizarEstoqueSeSuficiente(int idProduto, int quantidade) throws FalhaProdutoException {
        return produtoDAO.atualizarEstoqueSeSuficiente(idProduto, quantidade);
    }
    
}
