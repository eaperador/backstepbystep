/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.edu.backstepbystep.front.dtos;

import com.uniandes.edu.backstepbystep.entities.BookEntity;
import com.uniandes.edu.backstepbystep.entities.ReviewEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Efrain Aperador
 */
public class BookDetailDTO extends BookDTO{
  private List<ReviewDTO> reviewsList = new ArrayList<>();

  public BookDetailDTO() {
    super();
  }
  
  public BookDetailDTO(BookEntity entity) {
    super(entity);
    if(entity != null){
      reviewsList = new ArrayList<>();
      for(ReviewEntity review : entity.getReviews()){
        reviewsList.add(new ReviewDTO(review));
      }
    }
  }

  public List<ReviewDTO> getReviewsList() {
    return reviewsList;
  }

  public void setReviewsList(List<ReviewDTO> reviewsList) {
    this.reviewsList = reviewsList;
  }
  
  public BookEntity toEntity(BookDTO book){
    BookEntity bookE = new BookEntity();
    bookE.setId(book.getId());
    bookE.setIsbn(book.getIsbn());
    bookE.setPublishDate(book.getPublishDate());
    bookE.setDescription(book.getDescription());
    bookE.setEditorial(book.getEditorial());
    bookE.setAuthor(book.getAuthor().toEntity());
    bookE.setImage(book.getImage());
    bookE.setReviews(ReviewDTO.toEntityList(reviewsList));
    return bookE;
  }
  
  public static List<BookEntity> toEntityList(List<BookDTO> lista){
    List<BookEntity> entitiesList = new ArrayList<>();
    for (BookDTO book : lista) {
      BookEntity bookEntity = book.toEntity();
      entitiesList.add(bookEntity);
    }
    return entitiesList;
  }
  
  public static List<BookDetailDTO> toBookList(List<BookEntity> entityList){
    List<BookDetailDTO> listaBooks = new ArrayList<>();
    for(int i=0; i < entityList.size(); i++){
      listaBooks.add(new BookDetailDTO(entityList.get(i)));
    }
    return listaBooks;
  }
}
