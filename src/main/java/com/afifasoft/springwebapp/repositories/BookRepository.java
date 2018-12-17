package com.afifasoft.springwebapp.repositories;

import com.afifasoft.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
