package pl.sidor.ArticleManager.adapters.service;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sidor.ArticleManager.adapters.mapper.AuthorMapper;
import pl.sidor.ArticleManager.domain.model.entity.Author;
import pl.sidor.ArticleManager.domain.ports.AuthorRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
@Setter
@Transactional
@RequiredArgsConstructor
public class AuthorService implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author save(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public Option<Author> getById(Long id) {
        return Option.of(entityManager.find(Author.class, id));
    }

    @Override
    public Option<Author> getByNameAndLastName(String name, String lastName) {
        CriteriaQuery<Author> query = prepareQuery(name, lastName);
        return Option.of(entityManager.createQuery(query).getSingleResult());
    }

    @Override
    public Author modify(Author author) {
        Author actualAuthor = getById(author.getId()).getOrNull();
        Author modifyAuthor = AuthorMapper.modifyAuthor(actualAuthor, author);
        return entityManager.merge(modifyAuthor);
    }

    @Override
    public void delete(Long id) {
        getById(id).toJavaOptional().ifPresent(entityManager::remove);
    }

    private CriteriaQuery<Author> prepareQuery(String name, String lastName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> query = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = query.from(Author.class);
        Predicate namePredicate = criteriaBuilder.equal(root.get("name"), name);
        Predicate lastNamePredicate = criteriaBuilder.equal(root.get("lastName"), lastName);
        query.where(namePredicate, lastNamePredicate);
        return query;
    }
}
