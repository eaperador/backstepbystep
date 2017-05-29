/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.edu.backstepbystep.front.dtos;

import com.uniandes.edu.backstepbystep.entities.AuthorEntity;
import com.uniandes.edu.backstepbystep.entities.BookEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Efrain Aperador
 */
public class AuthorDetailDTO extends AuthorDTO{
  
  private List<BookDTO> bookList = new ArrayList<>();

  public AuthorDetailDTO() {
    super();
  }
  
  public AuthorDetailDTO(AuthorEntity entity){
    super(entity);
    if(entity != null){
      bookList = new ArrayList<>();
      for(BookEntity book : entity.getBooks()){
        bookList.add(new BookDTO(book));
      }
    }
  }
  
  @Override
  public AuthorEntity toEntity(AuthorDTO dto){
    AuthorEntity author = new AuthorEntity();
    author.setId(dto.getId());
    author.setName(dto.getName());
    author.setBirthDate(dto.getBirthDate());
    author.setDescription(dto.getDescription());
    author.setImage(dto.getImage());
    author.setBooks(BookDetailDTO.toEntityList(bookList));
    
    return author;
  }

  public List<BookDTO> getBookList() {
    return bookList;
  }

  public void setBookList(List<BookDTO> bookList) {
    this.bookList = bookList;
  }
  
  public static List<AuthorEntity> toEntityList(List<AuthorDTO> lista){
    List<AuthorEntity> entitiesList = new ArrayList<>();
    for (AuthorDTO author : lista) {
      AuthorEntity authorEntity = author.toEntity();
      entitiesList.add(authorEntity);
    }
    return entitiesList;
  }
  
  public static List<AuthorDetailDTO> toAuthorList(List<AuthorEntity> entities){
    List<AuthorDetailDTO> lista = new ArrayList<>();
    for(AuthorEntity author : entities){
      lista.add(new AuthorDetailDTO(author));
    }
    return lista;
  }
}
