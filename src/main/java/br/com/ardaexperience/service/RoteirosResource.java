package br.com.ardaexperience.service;

import br.com.ardaexperience.bean.RoteiroRemote;
import br.com.ardaexperience.entidade.Roteiro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("roteiros")
public class RoteirosResource {

    @EJB
    private RoteiroRemote roteiroRemote;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws Exception {
        return gson.toJson(roteiroRemote.consultarTodos());
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCliente(@PathParam("id") String idRoteiro) {
        Long id = Long.valueOf(idRoteiro);
        return gson.toJson(roteiroRemote.consultarPorId(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String salvarCliente(String roteiroJson) {
        try {
            Roteiro roteiro = gson.fromJson(roteiroJson, Roteiro.class);
            return gson.toJson(roteiroRemote.registrar(roteiro));
        } catch (Exception e) {
            return null;
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putCliente(String roteiroJson) throws Exception {
        Roteiro roteiro = gson.fromJson(roteiroJson, Roteiro.class);
        return gson.toJson(roteiroRemote.atualizar(roteiro));
    }

}
