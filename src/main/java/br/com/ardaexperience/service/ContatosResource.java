package br.com.ardaexperience.service;

import br.com.ardaexperience.bean.ContatoRemote;
import br.com.ardaexperience.entidade.Contato;
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

@Path("clientes/contatos")
public class ContatosResource {
    
    @EJB
    private ContatoRemote contatoRemote;
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(contatoRemote.consultarTodos());
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarContatoPorId(@PathParam("id") String idContato) {
        Long id = Long.valueOf(idContato);
        return gson.toJson(contatoRemote.consultarPorId(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String contatoJson) throws Exception {
        Contato contato = gson.fromJson(contatoJson, Contato.class);
        return gson.toJson(contatoRemote.atualizar(contato));
    }
}
