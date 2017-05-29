/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.edu.backstepbystep.front.resources;

import com.uniandes.edu.backstepbystep.ejb.ReviewLogic;
import com.uniandes.edu.backstepbystep.entities.ReviewEntity;
import com.uniandes.edu.backstepbystep.front.dtos.ReviewDTO;
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
@Path("reviews")
@Produces("application/json")
@Consumes("application/json")
public class ReviewResource {

  @Inject ReviewLogic reviewLogic;

  @GET
  public List<ReviewDTO> getReviewList() {
    List<ReviewEntity> entities = reviewLogic.getReviews();
    return ReviewDTO.toReviewList(entities);
  }
  
  @GET
  @Path("{id: \\d+}")
  public ReviewDTO getReview(@PathParam("id") Long id) {
    ReviewEntity entity = reviewLogic.getReview(id);
    if (entity == null) {
      throw new RuntimeException("El review no existe");
    }
    return new ReviewDTO(entity);
  }

  @POST
  public ReviewDTO createReview(ReviewDTO review) {
    return new ReviewDTO(reviewLogic.createReview(review.toEntity()));
  }

  @DELETE
  @Path("{reviewId: \\d+}")
  public void deleteReview(@PathParam("reviewId") Long id) {
    ReviewEntity entity = reviewLogic.getReview(id);
    if (entity == null) {
      throw new RuntimeException("El review no existe");
    }
    reviewLogic.deleteReview(id);
  }
  
  @PUT
  @Path("{id: \\d+}")
  public ReviewDTO updateReview(@PathParam("id") Long id, ReviewDTO review){
    ReviewEntity entity = reviewLogic.getReview(id);
    if (entity == null) {
      throw new RuntimeException("El review no existe");
    }
    return new ReviewDTO(reviewLogic.updateReview(id, review.toEntity()));
  }
}