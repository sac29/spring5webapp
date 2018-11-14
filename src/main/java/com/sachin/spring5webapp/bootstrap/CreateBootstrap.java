package com.sachin.spring5webapp.bootstrap;

import com.sachin.spring5webapp.model.Author;
import com.sachin.spring5webapp.model.Book;
import com.sachin.spring5webapp.model.Publisher;
import com.sachin.spring5webapp.repositories.AuthorRepository;
import com.sachin.spring5webapp.repositories.BookRepository;
import com.sachin.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class CreateBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public CreateBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        saveData();
    }


    public void saveData(){

        Publisher pub1 = new Publisher("Mc grawHill", "221 Baker street");
        publisherRepository.save(pub1);
        Author auth1 = new Author("Matz", "Yukihiro");

        Book book1 = new Book("Ruby","31213",pub1);

        auth1.getBooks().add(book1);
        book1.getAuthors().add(auth1);

        authorRepository.save(auth1);
        bookRepository.save(book1);

        Author auth2 = new Author("Eric", "Damoen");

        Book book2 = new Book("Java","41213",pub1);

        auth2.getBooks().add(book2);
        book2.getAuthors().add(auth2);

        authorRepository.save(auth2);
        bookRepository.save(book2);
    }
}
