package pl.sidor.ArticleManager.adapters.response;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.mapper.ArticleMapper;
import pl.sidor.ArticleManager.domain.model.entity.Article;
import pl.sidor.ArticleManager.domain.model.entity.Author;
import pl.sidor.ArticleManager.domain.model.entity.Content;

import java.time.ZonedDateTime;

@Getter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public final class ArticleResponse {

    private String applicationName;
    private String applicationVersion;
    private ZonedDateTime actualDate;
    private String title;
    private Author author;
    private Content content;
    private String message;

    public ArticleResponse createResponse(Option<Article> article, String message) {
        return article.isEmpty() ? createFailsResponse(message) : createSuccessResponse(article.get());
    }

    public ArticleResponse createFailsResponse(String message) {
        return ArticleMapper.buildFailsResponse(message);
    }

    protected ArticleResponse createSuccessResponse(Article article) {
        return ArticleMapper.buildSuccessResponse(article);
    }
}
