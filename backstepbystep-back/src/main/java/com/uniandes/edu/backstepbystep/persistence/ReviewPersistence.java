/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.edu.backstepbystep.persistence;

import com.uniandes.edu.backstepbystep.entities.ReviewEntity;
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
public class ReviewPersistence {

  @PersistenceContext(unitName = "BookStorePU")
  protected EntityManager em;

  public ReviewEntity find(Long id) {
    return em.find(ReviewEntity.class, id);
  }

  public List<ReviewEntity> findAll() {
    Query q = em.createQuery("select u from ReviewEntity u");
    return q.getResultList();
  }

  public ReviewEntity create(ReviewEntity entity) {
    em.persist(entity);
    return entity;
  }

  public ReviewEntity update(ReviewEntity entity) {
    return em.merge(entity);
  }

  public void delete(Long id) {
    ReviewEntity entity = em.find(ReviewEntity.class, id);
    em.remove(entity);
  }
}
