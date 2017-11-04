package br.com.ardaexperience.service;

import br.com.clienteejb.bean.ClienteRemote;
import br.com.clienteejb.entidade.Cliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("clientes")
public class ClientesResource {

    @EJB
    private ClienteRemote clienteRemote;

    List<Cliente> clientes = new ArrayList<>();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ClientesResource() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws Exception {
        return gson.toJson(clienteRemote.consultarTodos());
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCliente(@PathParam("id") String idCliente) {
        Long id = Long.valueOf(idCliente);
        return gson.toJson(clienteRemote.consultarPorId(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String salvarCliente(String clienteJson) {
        try {
            Cliente cliente = gson.fromJson(clienteJson, Cliente.class);
            return gson.toJson(clienteRemote.registrar(cliente));
        } catch (Exception e) {
            return null;
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putCliente(String clienteJson) throws Exception {
        Cliente cliente = gson.fromJson(clienteJson, Cliente.class);
        return gson.toJson(clienteRemote.atualizar(cliente));
    }

}
