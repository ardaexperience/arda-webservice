package br.com.ardaexperience.service;

import br.com.ardaexperience.bean.DetalhesRoteiroRemote;
import br.com.ardaexperience.entidade.DetalhesRoteiro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("roteiros/detalhesroteiros")
public class DetalhesRoteirosResource {

    @EJB
    private DetalhesRoteiroRemote detalhesRoteiroRemote;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(detalhesRoteiroRemote.consultarTodos());
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarPorId(@PathParam("id") String idDetalhesRoteiro) {
        Long id = Long.valueOf(idDetalhesRoteiro);
        return gson.toJson(detalhesRoteiroRemote.consultarPorId(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String detalhesRoteirosJson) throws Exception {
        DetalhesRoteiro detalhesRoteiro = gson.fromJson(detalhesRoteirosJson, DetalhesRoteiro.class);
        return gson.toJson(detalhesRoteiroRemote.atualizar(detalhesRoteiro));
    }

}
