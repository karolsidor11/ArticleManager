package pl.sidor.ArticleManager.adapters.response;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.mapper.AuthorMapper;
import pl.sidor.ArticleManager.domain.model.entity.Author;

@Getter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public final class AuthorResponse {

    private String applicationName;
    private String applicationVersion;
    private String name;
    private String lastName;
    private String email;
    private String message;

    public AuthorResponse createResponse(Option<Author> author, String message) {
        return author.isEmpty() ? createFailsResponse(message) : createSuccessResponse(author.get());
    }

    public AuthorResponse createFailsResponse(String message){
        return AuthorMapper.buildFailsResponse(message);
    }

    protected AuthorResponse createSuccessResponse(Author author) {
        return AuthorMapper.buildSuccessResponse(author);
    }
}
