package pl.sidor.ArticleManager.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.mapper.AuthorMapper;
import pl.sidor.ArticleManager.adapters.response.AuthorResponse;
import pl.sidor.ArticleManager.adapters.service.AuthorService;
import pl.sidor.ArticleManager.domain.model.entity.Author;

@Component
@RequiredArgsConstructor
public class AuthorFasade {

    private final AuthorService authorService;

    AuthorResponse getById(Long id) {
        Author author = authorService.getById(id).getOrNull();
        return AuthorMapper.map(author);
    }

    AuthorResponse save(Author author) {
        Author savedAuthor = authorService.save(author);
        return AuthorMapper.map(savedAuthor);
    }

    AuthorResponse findByNameAndLastName(String name, String lastName) {
        Author author = authorService.getByNameAndLastName(name, lastName).getOrNull();
        return AuthorMapper.map(author);
    }

    AuthorResponse delete(Long id) {
        authorService.delete(id);
        return AuthorMapper.map(Author.builder().build());
    }

    AuthorResponse modify(Author author) {
        Author modifiedAuthor = authorService.modify(author);
        return AuthorMapper.map(modifiedAuthor);
    }
}
