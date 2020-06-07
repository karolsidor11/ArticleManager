package pl.sidor.ArticleManager.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.mapper.ArticleMapper;
import pl.sidor.ArticleManager.adapters.response.ArticleResponse;
import pl.sidor.ArticleManager.adapters.service.ArticleService;
import pl.sidor.ArticleManager.domain.model.entity.Article;

@Component
@RequiredArgsConstructor
public class ArticleFasade {

    private final ArticleService articleService;

    ArticleResponse findById(Long id) {
        Article article = articleService.getById(id).getOrNull();
        return ArticleMapper.map(article);
    }

    ArticleResponse findByTitle(String title) {
        Article article = articleService.getByTitle(title).getOrNull();
        return ArticleMapper.map(article);
    }

    ArticleResponse save(Article article) {
        Article saveArticle = articleService.save(article);
        return ArticleMapper.map(saveArticle);
    }

    ArticleResponse modify(Article article) {
        Article modifyArticle = articleService.modify(article);
        return ArticleMapper.map(modifyArticle);
    }

    ArticleResponse delete(Long id) {
        articleService.delete(id);
        return ArticleMapper.map(Article.builder().build());
    }
}
