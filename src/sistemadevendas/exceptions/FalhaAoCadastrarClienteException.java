/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas.exceptions;

import java.sql.SQLException;

/**
 *
 * @author LucasMorais
 */
public class FalhaAoCadastrarClienteException extends Exception {

    public FalhaAoCadastrarClienteException(String message, Throwable ex) {
       super(message, ex);
    }
    
}
