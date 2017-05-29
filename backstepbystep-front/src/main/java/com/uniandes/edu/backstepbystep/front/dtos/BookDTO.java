package com.uniandes.edu.backstepbystep.front.dtos;

import com.uniandes.edu.backstepbystep.entities.BookEntity;
import java.util.Date;

/**
 *
 * @author Efrain Aperador
 */
public class BookDTO {
  private Long id;
  private String isbn;
  private Date publishDate;
  private String description;
  private String editorial;
  private String image;

  public BookDTO() {
  }

  public BookDTO(BookEntity bookE) {
    this.id = bookE.getId();
    this.isbn = bookE.getIsbn();
    this.publishDate = bookE.getPublishDate();
    this.description = bookE.getDescription();
    this.editorial = bookE.getEditorial();
    this.image = bookE.getImage();
  }
  
  public static BookDTO toBookDTO(BookEntity bookE) {
    BookDTO book = new BookDTO();
    book.setId(bookE.getId());
    book.setIsbn(bookE.getIsbn());
    book.setPublishDate(bookE.getPublishDate());
    book.setDescription(bookE.getDescription());
    book.setEditorial(bookE.getEditorial());
    book.setImage(bookE.getImage());
    AuthorDTO author = new AuthorDTO();
    author.setId(bookE.getId());
    return book;
  }
  
  public BookEntity toEntity(){
    BookEntity bookE = new BookEntity();
    bookE.setId(this.id);
    bookE.setIsbn(this.isbn);
    bookE.setPublishDate(this.publishDate);
    bookE.setDescription(this.description);
    bookE.setEditorial(this.editorial);
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
