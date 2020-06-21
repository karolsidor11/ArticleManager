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
        Content actualContent = getById(content.getId()).getOrNull();
        Content modifyContent = ContentMapper.modifyContent(actualContent, content);
        return entityManager.merge(modifyContent);
    }

    @Override
    public void delete(Long id) {
        getById(id).toJavaOptional().ifPresent(entityManager::remove);
    }
}
