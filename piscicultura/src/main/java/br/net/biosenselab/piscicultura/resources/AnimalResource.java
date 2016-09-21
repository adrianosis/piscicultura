package br.net.biosenselab.piscicultura.resources;

import br.net.biosenselab.piscicultura.models.Animal;
import br.net.biosenselab.piscicultura.services.AnimalService;
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
@Path("/animal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@RolesAllowed({"admin"})
public class AnimalResource extends BasicResource {

    @EJB
    private AnimalService animalService;

    @POST
    public Animal adicionar(Animal animal) {
        try {
            return animalService.adicionar(animal, getUsuario());
        } catch (Exception e) {
            throw e;
        }
    }

    @GET
    @Path("/{animalId}")
    public Animal find(@PathParam("animalId") long animalId) {
        try {
            return animalService.find(animalId);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @GET
    public List<Animal> find() {
        try {
            return animalService.find();
        } catch (Exception e) {
            throw e;
        }
    }

}
