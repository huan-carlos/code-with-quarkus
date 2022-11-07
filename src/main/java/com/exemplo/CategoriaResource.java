package com.exemplo;

import com.exemplo.model.Categoria;
import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @GET
    @Path("/{id}")
    public Categoria getById(@PathParam("id") long id){
        return Categoria.findById(id);
    }

    @GET
    public List<Categoria> getAll() {
        return Categoria.listAll();
    }

    @Transactional
    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") long id){
        Categoria.deleteById(id);
    }

    @Transactional
    @POST
    public void insert(Categoria categoria){
        categoria.persist(categoria);

        //request precisa de um header = content-type: application/json
    }

    @Transactional
    @Path("/{id}")
    @PUT
    public void update(@PathParam("id") Long id, Categoria categoria){
        /*var categoriaLocalizada = (Categoria)Categoria.findById(id);
        categoriaLocalizada.descricao = categoria.descricao;
        categoriaLocalizada.sigla = categoria.sigla;
        categoriaLocalizada.persist();*/

        //implement Lock Optimistic
        try {
            var em = JpaOperations.INSTANCE.getEntityManager();
            em.merge(categoria);
        } catch (Exception e) {
            throw new WebApplicationException("Registro excluido ou alterado por outro Usuário!");
        }
    }
}