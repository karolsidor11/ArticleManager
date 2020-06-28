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
        return Option.ofOptional(entityManager.createQuery(query).getResultStream().findFirst());
    }

    @Override
    public Author modify(Author author) {
        Option<Author> authorOption = getById(author.getId());
        return authorOption.isEmpty() ? null : updateAuthor(authorOption.get(), author);
    }

    @Override
    public Option<Author> delete(Long id) {
        Option<Author> author = getById(id);
        author.toJavaOptional().ifPresent(entityManager::remove);
        return author;
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

    private Author updateAuthor(Author author, Author currentAuthor) {
        Author modifyAuthor = AuthorMapper.modifyAuthor(currentAuthor, author);
        return entityManager.merge(modifyAuthor);
    }
}
