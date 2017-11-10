package br.com.ardaexperience.service;

import br.com.ardaexperience.bean.PaginaRemote;
import br.com.ardaexperience.entidade.Pagina;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("roteiros/paginas")
public class PaginasResource {
    
    @EJB
    private PaginaRemote paginaRemote;
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(paginaRemote.consultarTodos());
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarContatoPorId(@PathParam("id") String idPagina) {
        Long id = Long.valueOf(idPagina);
        return gson.toJson(paginaRemote.consultarPorId(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String paginaJson) throws Exception {
        Pagina pagina = gson.fromJson(paginaJson, Pagina.class);
        return gson.toJson(paginaRemote.atualizar(pagina));
    }
}
