package pl.sidor.ArticleManager.domain.ports;

import io.vavr.control.Option;
import pl.sidor.ArticleManager.domain.model.entity.Content;

public interface ContentRepository {

    Content save(Content content);

    Option<Content> getById(Long id);

    Content modify(Content content);

    Option<Content> delete(Long id);
}
