package pl.sidor.ArticleManager.adapters.response;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.mapper.AuthorMapper;
import pl.sidor.ArticleManager.domain.model.entity.Author;
import pl.sidor.ArticleManager.utils.ApplicationUtils;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public final class AuthorResponse {

    private String applicationName;
    private String applicationVersion;
    private String name;
    private String lastName;
    private String email;
    private String message;

    public AuthorResponse createResponse(Option<Author> author, String message) {
        return author.isEmpty() ? buildFailsResponse(message) : createSuccessResponse(author.get());
    }

    public AuthorResponse createFailsResponse(String message){
        return buildFailsResponse(message);
    }

    private AuthorResponse createSuccessResponse(Author author) {
        return AuthorMapper.map(author);
    }

    private AuthorResponse buildFailsResponse(String message) {
        return AuthorResponse.builder()
                .applicationName(ApplicationUtils.APPLICATION_NAME)
                .applicationVersion(ApplicationUtils.APPLICATION_VERSION)
                .message(message)
                .build();
    }
}
