package pl.sidor.ArticleManager.adapters.api;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.response.AuthorResponse;
import pl.sidor.ArticleManager.adapters.service.AuthorService;
import pl.sidor.ArticleManager.domain.model.entity.Author;

import static java.util.Objects.isNull;
import static pl.sidor.ArticleManager.exception.MessageException.*;

@Component
@RequiredArgsConstructor
public class AuthorFasade {

    private final AuthorService authorService;
    private final AuthorResponse authorResponse;

    AuthorResponse getById(Long id) {
        Option<Author> author = authorService.getById(id);
        return authorResponse.createResponse(author, NOT_FOUND_AUTHOR_BY_ID.getMessage());
    }

    AuthorResponse save(Author author) {
        return isNull(author.getEmail()) ? authorResponse.createFailsResponse(NOT_SAVE_AUTHOR.getMessage()) : saveAuthor(author);
    }

    AuthorResponse findByNameAndLastName(String name, String lastName) {
        Option<Author> author = authorService.getByNameAndLastName(name, lastName);
        return authorResponse.createResponse(author, NOT_FOUND_BY_NAME_LASTNAME.getMessage());
    }

    AuthorResponse delete(Long id) {
        Option<Author> author = authorService.delete(id);
        return author.isEmpty() ? authorResponse.createFailsResponse(NOT_DELETE_AUTHOR_BY_ID.getMessage()) : authorResponse.createResponse(author, DELETE_BY_AUTHOR_ID.getMessage());
    }

    AuthorResponse modify(Author author) {
        Option<Author> authorOption = Option.of(authorService.modify(author));
        String message = authorOption.isEmpty() ? NOT_MODIFY_AUTHOR.getMessage() : MODIFY_AUTHOR.getMessage();
        return authorResponse.createResponse(authorOption, message);
    }

    private AuthorResponse saveAuthor(Author author) {
        Option<Author> authorOption = Option.of(authorService.save(author));
        return authorResponse.createResponse(authorOption, null);
    }
}
