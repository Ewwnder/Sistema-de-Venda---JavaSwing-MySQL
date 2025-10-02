/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas.services;

import java.util.List;
import sistemadevendas.dao.NotaFiscalDAO;
import sistemadevendas.exceptions.AtualizacaoEstoqueNegativaException;
import sistemadevendas.exceptions.FalhaNotaFiscalException;
import sistemadevendas.exceptions.FalhaProdutoException;
import sistemadevendas.exceptions.NaoEncontradoException;
import sistemadevendas.model.NotaFiscal;

/**
 *
 * @author LucasMorais
 */
public class NotaFiscalService {

    private NotaFiscalDAO nfDAO = new NotaFiscalDAO();
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
    }
    
}
