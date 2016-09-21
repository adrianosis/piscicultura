package br.net.biosenselab.piscicultura.repositories;

import br.net.biosenselab.piscicultura.models.Medicao;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Francisco Adriano da Silva
 */
public class MedicaoRepository extends BasicRepository{

    public MedicaoRepository(EntityManager em) {
        super(em);
    }
    
    public Medicao create(Medicao medicao) {
        try {
            return createEntity(medicao);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Medicao> findMedicao(long animalId) {
        try {
            params = new HashMap<>();
            query = new StringBuilder("select m from Medicao m ");
            query.append("join fetch m.animal a ");
            query.append("where a.id = :animalId");
            params.put("animalId", animalId);
            
            return findListEntity(Medicao.class, query.toString(), params);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
