package pl.sidor.ArticleManager.adapters.service;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sidor.ArticleManager.domain.model.entity.Content;
import pl.sidor.ArticleManager.domain.ports.ContentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService implements ContentRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Option<Content> getById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Content> query = criteriaBuilder.createQuery(Content.class);
        Root<Content> root = query.from(Content.class);
        Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
        query.where(idPredicate);

        return Option.of(entityManager.createQuery(query).getSingleResult());
    }

    @Override
    public Content save(Content content) {
        entityManager.persist(content);
        return content;
    }

    @Override
    public Content modify(Content content) {
        return entityManager.merge(content);
    }

    @Override
    public void delete(Long id) {
        getById(id).toJavaOptional().ifPresent(entityManager::remove);
    }
}
