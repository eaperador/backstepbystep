package com.uniandes.edu.backstepbystep.front.dtos;

import com.uniandes.edu.backstepbystep.entities.ReviewEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Efrain Aperador
 */
public class ReviewDTO {
  private Long id;
  private Date publishDate;
  private String description;
  private BookDTO book;

  public ReviewDTO() {
  }

  public ReviewDTO(ReviewEntity reviewE) {
    this.id = reviewE.getId();
    this.publishDate = reviewE.getPublishDate();
    this.description = reviewE.getDescription();
    this.book = new BookDTO(reviewE.getBook());
  }
  
  public static ReviewDTO toReviewDTO(ReviewEntity reviewE) {
    ReviewDTO review = new ReviewDTO();
    review.setId(reviewE.getId());
    review.setPublishDate(reviewE.getPublishDate());
    review.setDescription(reviewE.getDescription());
    BookDTO book = new BookDTO(reviewE.getBook());
    review.setBook(book);
    return review;
  }
  
  public ReviewEntity toEntity(){
    ReviewEntity reviewE = new ReviewEntity();
    reviewE.setId(this.id);
    reviewE.setPublishDate(this.publishDate);
    reviewE.setDescription(this.description);
    reviewE.setBook(this.getBook().toEntity());
    return reviewE;
  }
  
  public static List<ReviewEntity> toEntityList(List<ReviewDTO> lista){
    List<ReviewEntity> entitiesList = new ArrayList<>();
    for (ReviewDTO review : lista) {
      ReviewEntity reviewEntity = review.toEntity();
      entitiesList.add(reviewEntity);
    }
    return entitiesList;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
  public static List<ReviewDTO> toReviewList(List<ReviewEntity> entityList){
    List<ReviewDTO> listaReviews = new ArrayList<>();
    for(int i=0; i < entityList.size(); i++){
      listaReviews.add(toReviewDTO(entityList.get(i)));
    }
    return listaReviews;
  }

  public void setBook(BookDTO book) {
    this.book = book;
  }

  public BookDTO getBook() {
    return book;
  }
}