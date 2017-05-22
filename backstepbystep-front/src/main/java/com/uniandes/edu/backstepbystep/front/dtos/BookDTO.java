package com.uniandes.edu.backstepbystep.front.dtos;

import com.uniandes.edu.backstepbystep.entities.BookEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Efrain Aperador
 */
@XmlRootElement
public class BookDTO {
  private Long id;
  private String isbn;
  private Date publishDate;
  private String description;
  private String editorial;
  private String author;
  private String image;

  public BookDTO() {
  }

  public BookDTO(BookEntity bookE) {
    this.id = bookE.getId();
    this.isbn = bookE.getIsbn();
    this.publishDate = bookE.getPublishDate();
    this.description = bookE.getDescription();
    this.editorial = bookE.getEditorial();
    this.author = bookE.getAuthor();
    this.image = bookE.getImage();
  }
  
  public BookEntity toEntity(){
    BookEntity bookE = new BookEntity();
    bookE.setId(this.id);
    bookE.setIsbn(this.isbn);
    bookE.setPublishDate(this.publishDate);
    bookE.setDescription(this.description);
    bookE.setEditorial(this.editorial);
    bookE.setAuthor(this.author);
    bookE.setImage(this.image);
    return bookE;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
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

  public String getEditorial() {
    return editorial;
  }

  public void setEditorial(String editorial) {
    this.editorial = editorial;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
  
  public static List<BookDTO> toBookList(List<BookEntity> entityList){
    List<BookDTO> listaBooks = new ArrayList<>();
    for(int i=0; i < entityList.size(); i++){
      listaBooks.add(new BookDTO(entityList.get(i)));
    }
    return listaBooks;
  }
}
