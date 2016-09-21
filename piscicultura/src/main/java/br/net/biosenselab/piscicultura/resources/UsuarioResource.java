package br.net.biosenselab.piscicultura.resources;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Francisco Adriano da Silva
 */
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@RolesAllowed({"admin"})
public class UsuarioResource {

    @Inject
    HttpSession httpSession;

    @GET
    @Path("/logout")
    public void findMedicao() {
        try {            
            httpSession.invalidate();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
