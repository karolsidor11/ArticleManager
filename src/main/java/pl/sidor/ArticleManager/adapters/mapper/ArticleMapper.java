package pl.sidor.ArticleManager.adapters.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.sidor.ArticleManager.adapters.response.ArticleResponse;
import pl.sidor.ArticleManager.domain.model.entity.Article;

import java.time.ZonedDateTime;

import static pl.sidor.ArticleManager.utils.ApplicationUtils.APPLICATION_NAME;
import static pl.sidor.ArticleManager.utils.ApplicationUtils.APPLICATION_VERSION;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArticleMapper {

    public static ArticleResponse map(Article article) {
        return ArticleResponse.builder()
                .applicationName(APPLICATION_NAME)
                .applicationVersion(APPLICATION_VERSION)
                .actualDate(ZonedDateTime.now())
                .title(article.getTitle())
                .author(article.getAuthor())
                .content(article.getContent())
                .build();
    }

    public static Article modifyArticle(Article actualArticle, Article modifyArticle){
        actualArticle.setTitle(modifyArticle.getTitle());
        actualArticle.setAuthor(modifyArticle.getAuthor());
        actualArticle.setContent(modifyArticle.getContent());
        return actualArticle;
    }
}
