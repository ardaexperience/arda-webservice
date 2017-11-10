package br.com.ardaexperience.service;

import br.com.ardaexperience.bean.CartaoCreditoRemote;
import br.com.ardaexperience.entidade.CartaoCredito;
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

@Path("clientes/cartoescredito")
public class CartoescreditoResource {

    @EJB
    private CartaoCreditoRemote cartaoCreditoRemote;
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(cartaoCreditoRemote.consultarTodos());
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String consultarCartaoCreditoPorId(@PathParam("id") String idCartaoCredito) {
        Long id = Long.valueOf(idCartaoCredito);
        return gson.toJson(cartaoCreditoRemote.consultarPorId(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String cartaoCreditoJson) throws Exception {
        CartaoCredito contato = gson.fromJson(cartaoCreditoJson, CartaoCredito.class);
        return gson.toJson(cartaoCreditoRemote.atualizar(contato));
    }
    
}
