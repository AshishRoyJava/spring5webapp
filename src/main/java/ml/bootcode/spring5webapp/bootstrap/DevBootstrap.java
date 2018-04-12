package ml.bootcode.spring5webapp.bootstrap;

import ml.bootcode.spring5webapp.model.Author;
import ml.bootcode.spring5webapp.model.Book;
import ml.bootcode.spring5webapp.model.Publisher;
import ml.bootcode.spring5webapp.repositories.AuthorRepository;
import ml.bootcode.spring5webapp.repositories.BookRepository;
import ml.bootcode.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

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

    private void initData() {
        // Ashish
        Author ashish = new Author("Ashish", "Roy");
        Publisher westland = new Publisher("Westland", "Kolkata");
        publisherRepository.save(westland);
        Book spring = new Book("Spring Framework tutorial", "12345", westland);
        ashish.getBooks().add(spring);
        spring.getAuthors().add(ashish);

        authorRepository.save(ashish);
        bookRepository.save(spring);

        // Soma
        Author soma = new Author("Soma", "Hazra");
        Publisher oriely = new Publisher("Oriely", "Kolkata");
        publisherRepository.save(oriely);
        Book angular = new Book("Angular 4 tutorial", "67890", oriely);
        soma.getBooks().add(angular);

        authorRepository.save(soma);
        bookRepository.save(angular);
    }
}
