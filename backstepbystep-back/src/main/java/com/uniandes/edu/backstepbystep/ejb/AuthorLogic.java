/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.edu.backstepbystep.ejb;

import com.uniandes.edu.backstepbystep.entities.AuthorEntity;
import com.uniandes.edu.backstepbystep.persistence.AuthorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Efrain Aperador
 */
@Stateless
public class AuthorLogic {

  @Inject
  private AuthorPersistence persistence;

  public List<AuthorEntity> getAuthor() {
    List<AuthorEntity> authors = persistence.findAll();
    return authors;
  }

  public AuthorEntity getAuthor(Long id) {
    AuthorEntity author = persistence.find(id);
    if (author == null) {
      throw new IllegalArgumentException("El autor solicitado no existe");
    }
    return author;
  }

  public AuthorEntity createAuthor(AuthorEntity entity) {
    persistence.create(entity);
    return entity;
  }

  public AuthorEntity updateAuthor(Long id, AuthorEntity entity) {
    AuthorEntity newEntity = persistence.update(entity);
    return newEntity;
  }

  public void deleteAuthor(Long id) {
    persistence.delete(id);
  }
}
