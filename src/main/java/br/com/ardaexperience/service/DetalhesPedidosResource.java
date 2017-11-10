package br.com.ardaexperience.service;

import br.com.ardaexperience.bean.DetalhesPedidoRemote;
import br.com.ardaexperience.entidade.DetalhesPedido;
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

@Path("clientes/detalhespedidos")
public class DetalhesPedidosResource {

    @EJB
    private DetalhesPedidoRemote detalhesPedidoRemote;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(detalhesPedidoRemote.consultarTodos());
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCliente(@PathParam("id") String idEndereco) {
        Long id = Long.valueOf(idEndereco);
        return gson.toJson(detalhesPedidoRemote.consultarPorId(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String detalhesPedidosJson) throws Exception {
        DetalhesPedido detalhesPedido = gson.fromJson(detalhesPedidosJson, DetalhesPedido.class);
        return gson.toJson(detalhesPedidoRemote.atualizar(detalhesPedido));
    }
    
}
