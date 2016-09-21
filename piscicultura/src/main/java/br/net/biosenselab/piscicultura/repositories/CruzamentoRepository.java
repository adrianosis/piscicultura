package br.net.biosenselab.piscicultura.repositories;

import br.net.biosenselab.piscicultura.models.Cruzamento;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Francisco Adriano da Silva
 */
public class CruzamentoRepository extends BasicRepository {

    public CruzamentoRepository(EntityManager em) {
        super(em);
    }

    public Cruzamento create(Cruzamento cruzamento) {
        try {
            return createEntity(cruzamento);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Cruzamento> find() {
        try {
            params = new HashMap<>();
            query = new StringBuilder("select c from Cruzamento c ");       
            
            return findListEntity(Cruzamento.class, query.toString(), params);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
