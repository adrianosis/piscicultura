package br.net.biosenselab.piscicultura.repositories;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import br.net.biosenselab.piscicultura.models.Animal;

/**
 *
 * @author Francisco Adriano da Silva
 */
public class AnimalRepository extends BasicRepository {

    public AnimalRepository(EntityManager em) {
        super(em);
    }

    public Animal create(Animal animal) {
        try {
            return createEntity(animal);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Animal get(long animalId) {
        try {
            return getEntity(Animal.class, animalId);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Animal> find() {
        try {
            params = new HashMap<>();
            query = new StringBuilder("select a from Animal a");

            return findListEntity(Animal.class, query.toString(), params);
        } catch (Exception e) {
            throw e;
        }
    }
}
