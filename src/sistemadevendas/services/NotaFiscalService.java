/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas.services;

import java.util.List;
import sistemadevendas.dao.NotaFiscalDAO;
import sistemadevendas.model.NotaFiscal;

/**
 *
 * @author LucasMorais
 */
public class NotaFiscalService {

    private NotaFiscalDAO nfDAO = new NotaFiscalDAO();
    
    public NotaFiscal buscarNotaFiscalPorId(int id) {
        return nfDAO.buscarNotaFiscalPorId(id);
    }
    
    public void criarNotaFiscal(NotaFiscal nf) {
        nfDAO.criarNotaFiscal(nf);
    }

    public List<NotaFiscal> listarNotasFiscais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
