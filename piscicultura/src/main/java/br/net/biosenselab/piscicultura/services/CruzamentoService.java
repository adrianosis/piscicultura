package br.net.biosenselab.piscicultura.services;

import br.net.biosenselab.piscicultura.models.Cruzamento;
import br.net.biosenselab.piscicultura.repositories.CruzamentoRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

/**
 *
 * @author Francisco Adriano da Silva
 */
@Stateless
public class CruzamentoService extends BasicService {

    @EJB
    private UsuarioService usuarioService;
    
    private CruzamentoRepository cruzamentoRepository;

    @PostConstruct
    public void postConstruct() {
        cruzamentoRepository = new CruzamentoRepository(em);
    }

    @Transactional(rollbackOn = Throwable.class)
    public Cruzamento adicionar(Cruzamento cruzamento, String user) {
        try {
            cruzamento.setUsuario(usuarioService.findByNome(user));
            
            return cruzamentoRepository.create(cruzamento);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Cruzamento> find() {
        try {
            return cruzamentoRepository.find();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
