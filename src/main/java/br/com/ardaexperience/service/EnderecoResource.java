package br.com.ardaexperience.service;

import br.com.ardaexperience.bean.EnderecoRemote;
import br.com.ardaexperience.entidade.Endereco;
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

@Path("clientes/enderecos")
public class EnderecoResource {

    @EJB
    private EnderecoRemote enderecoRemote;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(enderecoRemote.consultarTodos());
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCliente(@PathParam("id") String idEndereco) {
        Long id = Long.valueOf(idEndereco);
        return gson.toJson(enderecoRemote.consultarPorId(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String enderecoJson) throws Exception {
        Endereco endereco = gson.fromJson(enderecoJson, Endereco.class);
        return gson.toJson(enderecoRemote.atualizar(endereco));
    }

}
