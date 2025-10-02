/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas.services;

import java.util.List;
import sistemadevendas.dao.NotaFiscalDAO;
<<<<<<< HEAD
=======
import sistemadevendas.exceptions.AtualizacaoEstoqueNegativaException;
import sistemadevendas.exceptions.FalhaNotaFiscalException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.NaoEncontradoException;
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
import sistemadevendas.model.NotaFiscal;

/**
 *
 * @author LucasMorais
 */
public class NotaFiscalService {

    private NotaFiscalDAO nfDAO = new NotaFiscalDAO();
<<<<<<< HEAD
    
    public NotaFiscal buscarNotaFiscalPorId(int id) {
        return nfDAO.buscarNotaFiscalPorId(id);
    }
    
    public void criarNotaFiscal(NotaFiscal nf) {
        nfDAO.criarNotaFiscal(nf);
    }

    public List<NotaFiscal> listarNotasFiscais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
    private ProdutoService produtoService = new ProdutoService();
    
    public NotaFiscal buscarNotaFiscalPorId(int id) throws FalhaNotaFiscalException, NaoEncontradoException {
        
        NotaFiscal nf = nfDAO.buscarNotaFiscalPorId(id);
       
        if(nf == null){
            throw new NaoEncontradoException("Nota Fiscal", id);
        }
        return nf;
        
    }
    
    public NotaFiscal criarNotaFiscal(NotaFiscal nf) throws FalhaNotaFiscalException, NaoEncontradoException {
  
        return nfDAO.criarNotaFiscal(nf);
        
       
   
    }

    public List<NotaFiscal> listarNotasFiscais() throws FalhaNotaFiscalException {
        return nfDAO.listarNotasFiscais();
>>>>>>> b040bc436e583440d3963a9af864a8762b323cc8
    }
    
}
