package br.net.biosenselab.piscicultura.resources;

import br.net.biosenselab.piscicultura.models.Medicao;
import br.net.biosenselab.piscicultura.services.MedicaoService;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Francisco Adriano da Silva
 */
@Path("/animal/{animalId}/medicao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@RolesAllowed({"admin"})
public class MedicaoResource extends BasicResource {

    @EJB
    private MedicaoService medicaoService;

    @POST
    public Medicao adicionar(@PathParam("animalId") long animalId, Medicao medicao) {
        try {
            return medicaoService.adicionar(animalId, medicao, getUsuario());
        } catch (Exception e) {
            throw e;
        }
    }

    @GET
    public List<Medicao> findMedicao(@PathParam("animalId") long animalId) {
        try {
            return medicaoService.findMedicao(animalId);
        } catch (Exception e) {
            throw e;
        }
    }
}
