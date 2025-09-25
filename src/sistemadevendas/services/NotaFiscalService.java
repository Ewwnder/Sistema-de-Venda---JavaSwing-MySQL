/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas.services;

import java.util.List;
import javax.swing.JOptionPane;
import sistemadevendas.dao.NotaFiscalDAO;
import sistemadevendas.model.NotaFiscal;

/**
 *
 * @author LucasMorais
 */
public class NotaFiscalService {

    private NotaFiscalDAO nfDAO = new NotaFiscalDAO();
    
    public NotaFiscal buscarNotaFiscalPorId(int id) {
        try{
            return nfDAO.buscarNotaFiscalPorId(id);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar nota: " +e.getMessage());
            return null;
        }
        
    }
    
    public void criarNotaFiscal(NotaFiscal nf) {
        try{
             nfDAO.criarNotaFiscal(nf);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao criar nota fiscal " + e.getMessage());
        }
       
    }

    public List<NotaFiscal> listarNotasFiscais() {
        try{
            return nfDAO.listarNotasFiscais();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar notas fiscais: " + e.getMessage());
            return null;
        }
        
    }
    
}
