package pl.sidor.ArticleManager.adapters.service;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sidor.ArticleManager.adapters.mapper.ArticleMapper;
import pl.sidor.ArticleManager.domain.model.entity.Article;
import pl.sidor.ArticleManager.domain.ports.ArticleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService implements ArticleRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Option<Article> getById(Long id) {
        return Option.of(entityManager.find(Article.class, id));
    }

    @Override
    public Option<Article> getByTitle(String title) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Article> query = criteriaBuilder.createQuery(Article.class);
        Root<Article> root = query.from(Article.class);
        Predicate titlePredicate = criteriaBuilder.equal(root.get("title"), title);
        query.where(titlePredicate);

        return Option.of(entityManager.createQuery(query).getSingleResult());
    }

    @Override
    public Article save(Article article) {
        entityManager.persist(article);
        return article;
    }

    @Override
    public Article modify(Article article) {
        Article actualArticle = getById(article.getId()).getOrNull();
        Article modifyArticle = ArticleMapper.modifyArticle(actualArticle, article);
        return entityManager.merge(modifyArticle);
    }

    @Override
    public void delete(Long id) {
        getById(id).toJavaOptional().ifPresent(entityManager::remove);
    }
}
