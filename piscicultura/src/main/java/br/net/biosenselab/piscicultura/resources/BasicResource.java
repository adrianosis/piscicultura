package br.net.biosenselab.piscicultura.resources;

import java.security.Principal;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Francisco Adriano da Silva
 */
public abstract class BasicResource {

    @Context
    protected SecurityContext securityContext;

    protected String getUsuario() {
        return securityContext.getUserPrincipal().getName();
    }

    protected Principal getPrincipal() {
        return securityContext.getUserPrincipal();
    }

}
