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
public class NaoEncontradoException extends Exception {

    public NaoEncontradoException(String tabela, int id) {
        super(tabela + " com id: " + id + " não encontrado");
    }
    
    
    
    
}
