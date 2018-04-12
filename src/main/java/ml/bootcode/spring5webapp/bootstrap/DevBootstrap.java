package ml.bootcode.spring5webapp.bootstrap;

import ml.bootcode.spring5webapp.model.Author;
import ml.bootcode.spring5webapp.model.Book;
import ml.bootcode.spring5webapp.repositories.AuthorRepository;
import ml.bootcode.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        // Ashish
        Author ashish = new Author("Ashish", "Roy");
        Book spring = new Book("Spring Framework tutorial", "12345", "Westland");
        ashish.getBooks().add(spring);
        spring.getAuthors().add(ashish);

        authorRepository.save(ashish);
        bookRepository.save(spring);

        // Soma
        Author soma = new Author("Soma", "Hazra");
        Book angular = new Book("Angular 4 tutorial", "67890", "Westland");
        soma.getBooks().add(angular);

        authorRepository.save(soma);
        bookRepository.save(angular);
    }
}
