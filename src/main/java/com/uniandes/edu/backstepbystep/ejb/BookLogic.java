package com.uniandes.edu.backstepbystep.ejb;

import com.uniandes.edu.backstepbystep.entities.BookEntity;
import com.uniandes.edu.backstepbystep.persistence.BookPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BookLogic {

  @Inject
  private BookPersistence persistence;

  public List<BookEntity> getBooks() {
    List<BookEntity> books = persistence.findAll();
    return books;
  }

  public BookEntity getBook(Long id) {
    BookEntity book = persistence.find(id);
    if (book == null) {
      throw new IllegalArgumentException("El libro solicitado no existe");
    }
    return book;
  }

  public BookEntity createBook(BookEntity entity) {
    persistence.create(entity);
    return entity;
  }

  public BookEntity updateBook(Long id, BookEntity entity) {
    BookEntity newEntity = persistence.update(entity);
    return newEntity;
  }

  public void deleteBook(Long id) {
    persistence.delete(id);
  }
}
