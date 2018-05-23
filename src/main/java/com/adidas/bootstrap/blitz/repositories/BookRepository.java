package com.adidas.bootstrap.blitz.repositories;

import com.adidas.bootstrap.blitz.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
}
