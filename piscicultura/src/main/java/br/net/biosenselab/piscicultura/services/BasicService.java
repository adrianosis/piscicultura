package br.net.biosenselab.piscicultura.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Francisco Adriano da Silva
 */
public abstract class BasicService {

    @PersistenceContext(unitName = "Piscicultura_PU")
    protected EntityManager em;
    
}
