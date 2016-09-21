package br.net.biosenselab.piscicultura.services;

import br.net.biosenselab.piscicultura.models.Animal;
import br.net.biosenselab.piscicultura.repositories.AnimalRepository;
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
public class AnimalService extends BasicService {

    @EJB
    private UsuarioService usuarioService;
    
    private AnimalRepository animalRepository;

    @PostConstruct
    public void postConstruct() {
        animalRepository = new AnimalRepository(em);
    }

    @Transactional(rollbackOn = Throwable.class)
    public Animal adicionar(Animal animal, String user) {
        try {
            animal.setUsuario(usuarioService.findByNome(user));
            
            return animalRepository.create(animal);
        } catch (Exception e) {
            throw e;
        }
    }

    public Animal find(long animalId) {
        try {
            return animalRepository.get(animalId);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Animal> find() {
        try {
            return animalRepository.find();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
