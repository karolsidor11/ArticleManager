package pl.sidor.ArticleManager.adapters.service;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sidor.ArticleManager.adapters.mapper.ContentMapper;
import pl.sidor.ArticleManager.domain.model.entity.Content;
import pl.sidor.ArticleManager.domain.ports.ContentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Setter
@Transactional
@RequiredArgsConstructor
public class ContentService implements ContentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Option<Content> getById(Long id) {
        return Option.of(entityManager.find(Content.class, id));
    }

    @Override
    public Content save(Content content) {
        entityManager.persist(content);
        return content;
    }

    @Override
    public Content modify(Content content) {
        Option<Content> contentOption = getById(content.getId());
        return contentOption.isEmpty() ? null : updateContent(contentOption.get(), content);
    }

    @Override
    public Option<Content> delete(Long id) {
        Option<Content> content = getById(id);
        content.toJavaOptional().ifPresent(entityManager::remove);
        return content;
    }

    private Content updateContent(Content content, Content currentContent) {
        Content modifyContent = ContentMapper.modifyContent(currentContent, content);
        return entityManager.merge(modifyContent);
    }
}
