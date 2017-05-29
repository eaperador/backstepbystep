package com.uniandes.edu.backstepbystep.ejb;

import com.uniandes.edu.backstepbystep.entities.ReviewEntity;
import com.uniandes.edu.backstepbystep.persistence.ReviewPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ReviewLogic {

  @Inject
  private ReviewPersistence persistence;

  public List<ReviewEntity> getReviews() {
    List<ReviewEntity> reviews = persistence.findAll();
    return reviews;
  }

  public ReviewEntity getReview(Long id) {
    ReviewEntity review = persistence.find(id);
    if (review == null) {
      throw new IllegalArgumentException("La revisión solicitada no existe");
    }
    return review;
  }

  public ReviewEntity createReview(ReviewEntity entity) {
    persistence.create(entity);
    return entity;
  }

  public ReviewEntity updateReview(Long id, ReviewEntity entity) {
    ReviewEntity newEntity = persistence.update(entity);
    return newEntity;
  }

  public void deleteReview(Long id) {
    persistence.delete(id);
  }
}
