/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.edu.backstepbystep.front.dtos;

import com.uniandes.edu.backstepbystep.entities.AuthorEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Efrain Aperador
 */
@XmlRootElement
public class AuthorDTO {
  private Long id;
  private String name;
  private Date birthDate;
  private String description;
  private String image;
  private List<BookDTO> books;

  public AuthorDTO() {
  }
  
  public AuthorDTO(AuthorEntity entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.birthDate = entity.getBirthDate();
    this.description = entity.getDescription();
    this.image = entity.getImage();
    this.books = BookDTO.toBookList(entity.getBooks());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<BookDTO> getBooks() {
    return books;
  }

  public void setBooks(List<BookDTO> books) {
    this.books = books;
  }
  
  public static AuthorEntity toEntity(AuthorDTO dto){
    AuthorEntity author = new AuthorEntity();
    author.setId(dto.getId());
    author.setName(dto.getName());
    author.setBirthDate(dto.getBirthDate());
    author.setDescription(dto.getDescription());
    author.setImage(dto.getImage());
    author.setBooks(BookDTO.toEntityList(dto.getBooks()));
    
    return author;
  }
  
  public static List<AuthorDTO> toAuthorList(List<AuthorEntity> entities){
    List<AuthorDTO> lista = new ArrayList<>();
    for(AuthorEntity author : entities){
      lista.add(new AuthorDTO(author));
    }
    return lista;
  }
}
