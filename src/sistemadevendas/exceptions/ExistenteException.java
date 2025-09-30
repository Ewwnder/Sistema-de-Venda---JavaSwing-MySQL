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
public class ExistenteException extends Exception {

    public ExistenteException(String tabela, int id) {
        super(tabela + " com id: " + id + " ja existe na base de dados");
    }
    
    public ExistenteException(String tabela, String email){
        super(tabela + " com email: " + email + " ja existe na base de dados");
    }
    
}
