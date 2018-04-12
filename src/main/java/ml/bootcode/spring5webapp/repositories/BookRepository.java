package ml.bootcode.spring5webapp.repositories;

import ml.bootcode.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
