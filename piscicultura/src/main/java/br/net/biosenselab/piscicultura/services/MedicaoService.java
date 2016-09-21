package br.net.biosenselab.piscicultura.services;

import br.net.biosenselab.piscicultura.models.Medicao;
import br.net.biosenselab.piscicultura.repositories.MedicaoRepository;
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
public class MedicaoService extends BasicService {

    @EJB
    private AnimalService animalService;    
    @EJB
    private UsuarioService usuarioService;
    
    private MedicaoRepository medicaoRepository;
    
    @PostConstruct
    public void postConstruct(){
        medicaoRepository = new MedicaoRepository(em);
    }
    
    @Transactional(rollbackOn = Throwable.class)
    public Medicao adicionar(long animalId, Medicao medicao, String user){
        try {
            medicao.setAnimal(animalService.find(animalId));
            medicao.setUsuario(usuarioService.findByNome(user));
            
            return medicaoRepository.create(medicao);
        } catch (Exception e) {
            throw e;
        }
    }
    
     public List<Medicao> findMedicao(long animalId) {
        try {            
            return medicaoRepository.findMedicao(animalId);
        } catch (Exception e) {
            throw e;
        }
    }   
    
}
