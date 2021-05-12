package pl.sidor.ArticleManager.adapters.service;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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
import java.util.Optional;

@Service
@Setter
@Transactional
@RequiredArgsConstructor
public class ArticleService implements ArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Option<Article> getById(Long id) {
        return Option.of(entityManager.find(Article.class, id));
    }

    @Override
    public Option<Article> getByTitle(String title) {
        Optional<Article> article = tryFindByTitle(title);
        return Option.ofOptional(article);
    }

    @Override
    public Article save(Article article) {
        entityManager.persist(article);
        return article;
    }

    @Override
    public Article modify(Article article) {
        Option<Article> currentArticle = getById(article.getId());
        return currentArticle.isEmpty() ? null : updateArticle(article, currentArticle.get());
    }

    @Override
    public Option<Article> delete(Long id) {
        Option<Article> article = getById(id);
        article.toJavaOptional().ifPresent(entityManager::remove);
        return article;
    }

    private Optional<Article> tryFindByTitle(String title) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Article> query = criteriaBuilder.createQuery(Article.class);
        Root<Article> root = query.from(Article.class);
        Predicate titlePredicate = criteriaBuilder.equal(root.get("title"), title);
        query.where(titlePredicate);

         return entityManager.createQuery(query).getResultStream().findFirst();
    }

    private Article updateArticle(Article article, Article currentArticle) {
        Article modifyArticle = ArticleMapper.modifyArticle(currentArticle, article);
        return entityManager.merge(modifyArticle);
    }
}
