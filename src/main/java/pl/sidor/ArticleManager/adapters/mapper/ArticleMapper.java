package pl.sidor.ArticleManager.adapters.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.sidor.ArticleManager.adapters.response.ArticleResponse;
import pl.sidor.ArticleManager.domain.model.entity.Article;

import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArticleMapper {

    public static ArticleResponse map(Article article) {
        return ArticleResponse.builder().
                applicationName("Article Manager")
                .applicationVersion("1.0.0 SNAPSHOT")
                .actualDate(ZonedDateTime.now())
                .title(article.getTitle())
                .author(article.getAuthor())
                .content(article.getContent())
                .build();
    }
}
