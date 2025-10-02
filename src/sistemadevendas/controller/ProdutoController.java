package sistemadevendas.controller;

import java.util.List;
import javax.swing.JOptionPane;
<<<<<<< HEAD
=======
import sistemadevendas.exceptions.ExistenteException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.IdNegativoException;
import sistemadevendas.exceptions.NaoEncontradoException;
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
import sistemadevendas.exceptions.ProdutoExisteException;
import sistemadevendas.model.Produto;
import sistemadevendas.services.ProdutoService;

/**
 *
 * @author LucasMorais
 */
public class ProdutoController {
    
    private ProdutoService produtoService = new ProdutoService();
    
<<<<<<< HEAD
    public Produto buscarProdutoPorId(int id){
        
        
        try{
            Produto p = produtoService.buscarProdutoPorId(id);
            return p;
            
        } catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        catch(Exception e){
            return null;
        }  
    }
    
    public void adicionarProduto(Produto produto){
        try{
            produtoService.adicionarProduto(produto);
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso no banco de dados");
        } catch(ProdutoExisteException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar: " + e.getMessage());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar produto: " + e.getMessage());
        }
    }
    
    public void removerProduto(int id){
        try{
          produtoService.removerProduto(id);  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Houve um erro na hora de remover: " + e.getMessage());
        }
         
    }
    
    public void editarProduto(Produto produto){
        try{
            produtoService.editarProduto(produto);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Houve um erro na hora de editar: " + e.getMessage());
        }
 
    }
    
    public List<Produto> listarProdutos(){
=======
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
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
        return produtoService.listarProdutos();
    }
}
