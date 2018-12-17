package com.afifasoft.springwebapp.repositories;

import com.afifasoft.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
