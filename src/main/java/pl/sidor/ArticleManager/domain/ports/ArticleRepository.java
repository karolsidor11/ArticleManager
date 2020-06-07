package pl.sidor.ArticleManager.domain.ports;

import io.vavr.control.Option;
import pl.sidor.ArticleManager.domain.model.entity.Article;

public interface ArticleRepository {

    Article save(Article article);

    Option<Article> getById(Long id);

    Option<Article> getByTitle(String title);

    Article modify(Article article);

    void delete(Long id);
}
