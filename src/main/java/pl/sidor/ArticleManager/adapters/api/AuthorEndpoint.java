package pl.sidor.ArticleManager.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sidor.ArticleManager.adapters.response.AuthorResponse;
import pl.sidor.ArticleManager.domain.model.entity.Author;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorEndpoint {

    private final AuthorFasade authorFasade;

    @GetMapping("{id}")
    public AuthorResponse getAuthorById(@PathVariable Long id) {
        return authorFasade.getById(id);
    }

    @GetMapping("/personData/{name} {lastName}")
    public AuthorResponse getAuthorByPersonalData(@PathVariable String name, @PathVariable String lastName) {
        return authorFasade.findByNameAndLastName(name, lastName);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public AuthorResponse saveAuthor(@RequestBody Author author) {
        return authorFasade.save(author);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public AuthorResponse modifyAuthor(@RequestBody Author author) {
        return authorFasade.modify(author);
    }

    @DeleteMapping("{id}")
    public AuthorResponse deleteAuthor(@PathVariable Long id) {
        return authorFasade.delete(id);
    }
}
