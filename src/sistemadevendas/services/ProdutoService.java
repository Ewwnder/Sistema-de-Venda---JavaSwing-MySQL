/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas.services;

import java.util.List;
import sistemadevendas.dao.ProdutoDAO;
import sistemadevendas.exceptions.ProdutoExisteException;
import sistemadevendas.model.Produto;

/**
 *
 * @author LucasMorais
 */
public class ProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public void removerProduto(int id) {
        produtoDAO.removerProduto(id);
    }

    public Produto buscarProdutoPorId(int id) {
        
       if (id < 0) {
        throw new IllegalArgumentException("ID não pode ser negativo");
        }
        
        Produto produto = produtoDAO.buscarPorId(id);
        if(produto==null){
            throw new RuntimeException("Produto não encontrado");
        }
        return produto;
    }
    
    public boolean verificarNomeProdutoExistente(Produto produto){
        String nome = produtoDAO.buscarPorNome(produto.getNomeProduto());
        
        if(nome !=null && nome.equals(produto.getNomeProduto()))
            return true;
        
        else
            return false;
    }
    
    public void adicionarProduto(Produto produto) throws ProdutoExisteException {
            
        boolean check_exists = verificarNomeProdutoExistente(produto);
        if(check_exists){
            throw new ProdutoExisteException("O produto já existe.");
        }
          
       produtoDAO.adicionarProduto(produto);
     
    }

    public void editarProduto(Produto produto) {
        produtoDAO.editarProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }
    
}
