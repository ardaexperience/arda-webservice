package br.com.ardaexperience.service;

import br.com.ardaexperience.bean.PedidoRemote;
import br.com.ardaexperience.entidade.Pedido;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("clientes/pedidos")
public class PedidosResource {

    @EJB
    private PedidoRemote pedidoRemote;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws Exception {
        return gson.toJson(pedidoRemote.consultarTodos());
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPedido(@PathParam("id") String idPedido) {
        Long id = Long.valueOf(idPedido);
        return gson.toJson(pedidoRemote.consultarPorId(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String salvarPedido(String pedidoJson) {
        try {
            Pedido pedido = gson.fromJson(pedidoJson, Pedido.class);
            return gson.toJson(pedidoRemote.registrar(pedido));
        } catch (Exception e) {
            return null;
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putPedido(String pedidoJson) throws Exception {
        Pedido pedido = gson.fromJson(pedidoJson, Pedido.class);
        return gson.toJson(pedidoRemote.atualizar(pedido));
    }
    
}
