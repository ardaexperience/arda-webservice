package br.com.ardaexperience.service;

import br.com.ardaexperience.bean.UsuarioRemote;
import br.com.ardaexperience.entidade.Usuario;
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

@Path("clientes/usuarios")
public class UsuariosResource {

    @EJB
    private UsuarioRemote usuarioRemote;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(usuarioRemote.consultarTodos());
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsuario(@PathParam("id") String idUsuario) {
        Long id = Long.valueOf(idUsuario);
        return gson.toJson(usuarioRemote.consultarPorId(id));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String usuarioJson) throws Exception {
        Usuario usuario = gson.fromJson(usuarioJson, Usuario.class);
        return gson.toJson(usuarioRemote.atualizar(usuario));
    }

}
