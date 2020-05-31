package pl.sidor.ArticleManager.domain.ports;

import io.vavr.control.Option;
import pl.sidor.ArticleManager.domain.model.entity.Author;

public interface AuthorRepository {

    Author save(Author author);

    Option<Author> getById(Long id);

    Option<Author> getByNameAndLastName(String name, String lastName);

    Author modify(Author author);

    void delete(Long id);
}
