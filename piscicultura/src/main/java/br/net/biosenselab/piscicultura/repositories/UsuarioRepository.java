package br.net.biosenselab.piscicultura.repositories;

import br.net.biosenselab.piscicultura.models.Usuario;
import java.util.HashMap;
import javax.persistence.EntityManager;

/**
 *
 * @author Francisco Adriano da Silva
 */
public class UsuarioRepository extends BasicRepository {

    public UsuarioRepository(EntityManager em) {
        super(em);
    }

    public Usuario findByNome(String usuarioNome) {
        try {
            params = new HashMap<>();
            query = new StringBuilder("select u from Usuario u ");
            query.append("where u.nome = :usuarioNome");
            params.put("usuarioNome", usuarioNome);

            return findEntity(Usuario.class, query.toString(), params);
        } catch (Exception e) {
            throw e;
        }
    }

}
