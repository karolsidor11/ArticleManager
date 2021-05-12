package pl.sidor.ArticleManager.adapters.api;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.response.ArticleResponse;
import pl.sidor.ArticleManager.adapters.service.ArticleService;
import pl.sidor.ArticleManager.domain.model.entity.Article;

import static java.util.Objects.isNull;
import static pl.sidor.ArticleManager.exception.MessageException.*;

@Component
@RequiredArgsConstructor
public class ArticleFasade {

    private final ArticleService articleService;
    private final ArticleResponse articleResponse;

    ArticleResponse findById(Long id) {
        Option<Article> article = articleService.getById(id);
        return articleResponse.createResponse(article, NOT_FOUND_BY_ID.getMessage());
    }

    ArticleResponse findByTitle(String title) {
        Option<Article> article = articleService.getByTitle(title);
        return articleResponse.createResponse(article, NOT_FOUND_BY_TITLE.getMessage());
    }

    ArticleResponse save(Article article) {
        return isNull(article.getAuthor()) ? articleResponse.createFailsResponse(NOT_SAVE.getMessage()) : saveArticle(article);
    }

    ArticleResponse modify(Article article) {
        Option<Article> articleOption = Option.of(articleService.modify(article));
        String message = articleOption.isEmpty() ? NOT_MODIFY.getMessage() : MODIFY_ARTICLE.getMessage();
        return articleResponse.createResponse(articleOption, message);
    }

    ArticleResponse delete(Long id) {
        Option<Article> article = articleService.delete(id);
        String message = article.isEmpty() ? NOT_DELETE_BY_ID.getMessage() : DELETE_BY_ID.getMessage();
        return articleResponse.createFailsResponse(message);
    }

    private ArticleResponse saveArticle(Article article) {
        Option<Article> articleOption = Option.of(articleService.save(article));
        return articleResponse.createResponse(articleOption, null);
    }
}
