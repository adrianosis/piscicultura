package br.net.biosenselab.piscicultura.repositories;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author Francisco Adriano da Silva
 */
public class BasicRepository {

    protected Map<String, Object> params;
    protected StringBuilder query;

    protected final EntityManager em;

    public BasicRepository(EntityManager em) {
        this.em = em;
    }

    // Adicionar entidades
    protected <T> T createEntity(T entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception e) {
            throw e;
        }
    }

    // Remover entidades
    protected <T> void deleteEntity(Class<T> classToCast, long pk) {
        try {
            em.remove(getEntity(classToCast, pk));
        } catch (Exception e) {
            throw e;
        }
    }

    protected <T> void deleteEntity(List<T> list) {
        try {
            for (T t : list) {
                em.remove(t);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    // Buscar entidades
    protected <T> T getEntity(Class<T> classToCast, long pk) {
        try {
            return em.find(classToCast, pk);
        } catch (Exception e) {
            throw e;
        }
    }

    protected <T> T getEntityLock(Class<T> classToCast, long pk) {
        try {
            return em.find(classToCast, pk, LockModeType.PESSIMISTIC_WRITE);
        } catch (Exception e) {
            throw e;
        }
    }

    protected <T> T findEntity(Class<T> classToCast, String query, Map<String, Object> params) {
        try {
            return createQuery(classToCast, query, params).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    protected <T> T findEntity(Class<T> classToCast, String query, Map<String, Object> params, int limit) {
        try {
            return createQuery(classToCast, query, params).setMaxResults(limit).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    protected <T> T findEntityLock(Class<T> classToCast, String query, Map<String, Object> params) {
        try {
            return createQuery(classToCast, query, params).setLockMode(LockModeType.PESSIMISTIC_WRITE).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    // Listar entidades
    protected <T> List<T> findListEntity(Class<T> classToCast, String query, Map<String, Object> params) {
        try {
            return createQuery(classToCast, query, params).getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    protected <T> List<T> findListEntity(Class<T> classToCast, String query, Map<String, Object> params, int limit) {
        try {
            return createQuery(classToCast, query, params).setMaxResults(limit).getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    protected <T> List<T> findListEntityLock(Class<T> classToCast, String query, Map<String, Object> params) {
        try {
            return createQuery(classToCast, query, params).setLockMode(LockModeType.PESSIMISTIC_READ).getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    // Criar query
    private <T> TypedQuery<T> createQuery(Class<T> classToCast, String query, Map<String, Object> params) {
        try {
            TypedQuery<T> qr = em.createQuery(query, classToCast);
            for (Map.Entry<String, Object> param : params.entrySet()) {
                switch (param.getValue().getClass().getSimpleName()) {
                    case "Calendar":
                    case "GregorianCalendar":
                        qr.setParameter(param.getKey(), (Calendar) param.getValue(), TemporalType.DATE);
                        break;
                    default:
                        qr.setParameter(param.getKey(), param.getValue());
                        break;
                }
            }
            return qr;
        } catch (Exception e) {
            throw e;
        }
    }

}
