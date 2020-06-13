package pl.sidor.ArticleManager.adapters.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.sidor.ArticleManager.adapters.response.AuthorResponse;
import pl.sidor.ArticleManager.domain.model.entity.Author;

import static pl.sidor.ArticleManager.utils.ApplicationUtils.APPLICATION_NAME;
import static pl.sidor.ArticleManager.utils.ApplicationUtils.APPLICATION_VERSION;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AuthorMapper {

    public static AuthorResponse map(Author author) {
        return AuthorResponse.builder()
                .applicationName(APPLICATION_NAME)
                .applicationVersion(APPLICATION_VERSION)
                .name(author.getName())
                .lastName(author.getLastName())
                .email(author.getEmail())
                .build();
    }

    public static Author modifyAuthor(Author actualAuthor, Author modifyAuthor){
        actualAuthor.setName(modifyAuthor.getName());
        actualAuthor.setLastName(modifyAuthor.getLastName());
        actualAuthor.setEmail(modifyAuthor.getEmail());
        return actualAuthor;
    }
}
