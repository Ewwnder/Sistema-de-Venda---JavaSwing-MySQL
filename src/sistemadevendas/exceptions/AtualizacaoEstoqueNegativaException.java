/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas.exceptions;

/**
 *
 * @author LucasMorais
 */
public class AtualizacaoEstoqueNegativaException extends Exception{

    public AtualizacaoEstoqueNegativaException(int id) {
        super("Tentativa de atualização de estoque de produto id: " + id + " que resultou em quantidade negativa");
    }
    
}
