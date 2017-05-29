/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.edu.backstepbystep.front.resources;

import com.uniandes.edu.backstepbystep.ejb.AuthorLogic;
import com.uniandes.edu.backstepbystep.entities.AuthorEntity;
import com.uniandes.edu.backstepbystep.front.dtos.AuthorDTO;
import com.uniandes.edu.backstepbystep.front.dtos.AuthorDetailDTO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Efrain Aperador
 */
@Path("authors")
@Produces("application/json")
@Consumes("application/json")
public class AuthorResource {
  @Inject AuthorLogic authorLogic;
  
  @GET
  public List<AuthorDetailDTO> getAuthorsList() {
    List<AuthorEntity> entities = authorLogic.getAuthor();
    return AuthorDetailDTO.toAuthorList(entities);
  }
  
  @GET
  @Path("{id: \\d+}")
  public AuthorDTO getAuthor(@PathParam("id") Long id) {
    AuthorEntity entity = authorLogic.getAuthor(id);
    if (entity == null) {
      throw new RuntimeException("El libro no existe");
    }
    return new AuthorDetailDTO(entity);
  }

  @POST
  public AuthorDTO createAuthor(AuthorDTO author) {
    return new AuthorDTO(authorLogic.createAuthor(author.toEntity()));
  }

  @DELETE
  @Path("{authorId: \\d+}")
  public void deleteAuthor(@PathParam("authorId") Long id) {
    AuthorEntity entity = authorLogic.getAuthor(id);
    if (entity == null) {
      throw new RuntimeException("El Autor no existe");
    }
    authorLogic.deleteAuthor(id);
  }
  
  @PUT
  @Path("{id: \\d+}")
  public AuthorDTO updateAuthor(@PathParam("id") Long id, AuthorDTO author){
    AuthorEntity entity = authorLogic.getAuthor(id);
    if (entity == null) {
      throw new RuntimeException("El autor no existe");
    }
    return new AuthorDTO(authorLogic.updateAuthor(id, author.toEntity()));
  }
}
