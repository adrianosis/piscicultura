package br.net.biosenselab.piscicultura.resources;

import br.net.biosenselab.piscicultura.models.Cruzamento;
import br.net.biosenselab.piscicultura.services.CruzamentoService;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Francisco Adriano da Silva
 */
@Path("/cruzamento")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@RolesAllowed({"admin"})
public class CruzamentoResource extends BasicResource {

    @EJB
    private CruzamentoService cruzamentoService;

    @POST
    public Cruzamento adicionar(Cruzamento cruzamento) {
        try {
            return cruzamentoService.adicionar(cruzamento, getUsuario());
        } catch (Exception e) {
            throw e;
        }
    }

    @GET
    public List<Cruzamento> find() {
        try {
            return cruzamentoService.find();
        } catch (Exception e) {
            throw e;
        }
    }

}
