/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas.controller;

import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.exceptions.ProdutoExisteException;
import sistemadevendas.model.Produto;
import sistemadevendas.services.ProdutoService;

/**
 *
 * @author LucasMorais
 */
public class ProdutoController {
    
    private ProdutoService produtoService = new ProdutoService();
    
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
        return produtoService.listarProdutos();
    }
}
