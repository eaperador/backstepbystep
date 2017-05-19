/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.edu.backstepbystep.front.resources;

import com.uniandes.edu.backstepbystep.ejb.BookLogic;
import com.uniandes.edu.backstepbystep.entities.BookEntity;
import com.uniandes.edu.backstepbystep.front.dtos.BookDTO;
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
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Efrain Aperador
 */
@Path("books")
@Produces("application/json")
@Consumes("application/json")
public class BookResource {

  @Inject
  private BookLogic bookLogic;

  @GET
  public List<BookDTO> getBookList() {
    List<BookEntity> entities = bookLogic.getBooks();
    return BookDTO.toBookList(entities);
  }
  
  @GET
  @Path("{id: \\d+}")
  public BookDTO getBook(@PathParam("id") Long id) {
    BookEntity entity = bookLogic.getBook(id);
    if (entity == null) {
      throw new RuntimeException("El libro no existe");
    }
    return new BookDTO(entity);
  }

  @POST
  public BookDTO createBook(BookDTO book) {
    return new BookDTO(bookLogic.createBook(book.toEntity()));
  }

  @DELETE
  @Path("{bookId: \\d+}")
  public void deleteBook(@PathParam("bookId") Long id) {
    BookEntity entity = bookLogic.getBook(id);
    if (entity == null) {
      throw new RuntimeException("El libro no existe");
    }
    bookLogic.deleteBook(id);
  }
  
  @PUT
  @Path("{id: \\d+}")
  public BookDTO updateBook(@PathParam("id") Long id, BookDTO book){
    BookEntity entity = bookLogic.getBook(id);
    if (entity == null) {
      throw new RuntimeException("El libro no existe");
    }
    return new BookDTO(bookLogic.updateBook(id, book.toEntity()));
  }
}
