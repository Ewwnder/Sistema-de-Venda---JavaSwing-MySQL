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
public class FalhaItemNotaFiscalException extends Exception{

    public FalhaItemNotaFiscalException(String message, Throwable ex) {
        super(message, ex);
    }

    public FalhaItemNotaFiscalException(String message) {
        super(message);
    }
    
}
