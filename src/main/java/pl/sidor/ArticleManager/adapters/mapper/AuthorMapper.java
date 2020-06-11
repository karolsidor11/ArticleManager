package pl.sidor.ArticleManager.adapters.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.sidor.ArticleManager.adapters.response.AuthorResponse;
import pl.sidor.ArticleManager.domain.model.entity.Author;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AuthorMapper {

    public static AuthorResponse map(Author author) {
        return AuthorResponse.builder()
                .applicationName("Article Manager")
                .applicationVersion("1.0.0 SNAPSHOT")
                .name(author.getName())
                .lastName(author.getLastName())
                .email(author.getEamil())
                .build();
    }

    public static Author modifyAuthor(Author actualAuthor, Author modifyAuthor){
        actualAuthor.setName(modifyAuthor.getName());
        actualAuthor.setLastName(modifyAuthor.getLastName());
        actualAuthor.setEamil(modifyAuthor.getEamil());
        return actualAuthor;
    }
}
