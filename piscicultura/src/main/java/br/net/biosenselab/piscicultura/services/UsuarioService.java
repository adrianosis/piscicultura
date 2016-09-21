package br.net.biosenselab.piscicultura.services;

import br.net.biosenselab.piscicultura.models.Usuario;
import br.net.biosenselab.piscicultura.repositories.UsuarioRepository;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author Francisco Adriano da Silva
 */
@Stateless
public class UsuarioService extends BasicService{
    
    private UsuarioRepository usuarioRepository;

    @PostConstruct
    public void postConstruct() {
        usuarioRepository = new UsuarioRepository(em);
    }
    
    public Usuario findByNome(String usuarioNome){
        try {
            return usuarioRepository.findByNome(usuarioNome);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
