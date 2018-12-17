package com.afifasoft.springwebapp.bootstrap;

import com.afifasoft.springwebapp.model.Author;
import com.afifasoft.springwebapp.model.Book;
import com.afifasoft.springwebapp.model.Publisher;
import com.afifasoft.springwebapp.repositories.AuthorRepository;
import com.afifasoft.springwebapp.repositories.BookRepository;
import com.afifasoft.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        Publisher wrox = new Publisher();
        wrox.setName("wrox");
        publisherRepository.save(wrox);


        Author eric = new Author("Eric", "Evas");
        Book ddd = new Book("Domain Driven Design", "1234", wrox);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        authorRepository.save(eric);
        bookRepository.save(ddd);



        Author rod = new Author("Rod", "Johnson");
        Book  noEJB = new Book("J2EE Development without EJB","123",wrox);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }


}
