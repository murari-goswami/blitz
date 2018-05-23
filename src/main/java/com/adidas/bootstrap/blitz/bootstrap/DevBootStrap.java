package com.adidas.bootstrap.blitz.bootstrap;

import com.adidas.bootstrap.blitz.model.Author;
import com.adidas.bootstrap.blitz.model.Book;
import com.adidas.bootstrap.blitz.model.Publisher;
import com.adidas.bootstrap.blitz.repositories.AuthorRepository;
import com.adidas.bootstrap.blitz.repositories.BookRepository;
import com.adidas.bootstrap.blitz.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/** Created by MG */
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  public DevBootStrap(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {

    Publisher publisherDdd = new Publisher();
    publisherDdd.setName("penguin");
    publisherDdd.setAddress("usa");
    publisherRepository.save(publisherDdd);
    // Eric
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", publisherDdd);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Publisher publishernoEJB = new Publisher();
    publishernoEJB.setName("worx");
    publishernoEJB.setAddress("uk");
    publisherRepository.save(publishernoEJB);
    // Rod
    Author rod = new Author("Rod", "johnson");
    Publisher worx = new Publisher("worx", "UK");
    Book noEJB = new Book("J2EE development without EJB", "23444", publishernoEJB);
    rod.getBooks().add(noEJB);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }
}
