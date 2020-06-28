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
import pl.sidor.ArticleManager.utils.ApplicationUtils;

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
        return article.isEmpty() ? createFailsResponse(message) : createSuccesResponse(article.get());
    }

    public ArticleResponse createFailsResponse(String message) {
        return buildResponse(message);
    }

    private ArticleResponse createSuccesResponse(Article article) {
        return ArticleMapper.map(article);
    }

    private ArticleResponse buildResponse(String message) {
        return ArticleResponse.builder()
                .applicationName(ApplicationUtils.APPLICATION_NAME)
                .applicationVersion(ApplicationUtils.APPLICATION_VERSION)
                .actualDate(ZonedDateTime.now())
                .message(message)
                .build();
    }
}
