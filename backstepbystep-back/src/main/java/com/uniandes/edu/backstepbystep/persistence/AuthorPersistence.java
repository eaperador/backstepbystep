/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.edu.backstepbystep.persistence;

import com.uniandes.edu.backstepbystep.entities.AuthorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Efrain Aperador
 */
@Stateless
public class AuthorPersistence {
  @PersistenceContext(unitName = "BookStorePU")
  protected EntityManager em;

  public AuthorEntity find(Long id) {
    return em.find(AuthorEntity.class, id);
  }

  public List<AuthorEntity> findAll() {
    Query q = em.createQuery("select u from AuthorEntity u");
    return q.getResultList();
  }

  public AuthorEntity create(AuthorEntity entity) {
    em.persist(entity);
    return entity;
  }

  public AuthorEntity update(AuthorEntity entity) {
    return em.merge(entity);
  }

  public void delete(Long id) {
    AuthorEntity entity = em.find(AuthorEntity.class, id);
    em.remove(entity);
  }
}
