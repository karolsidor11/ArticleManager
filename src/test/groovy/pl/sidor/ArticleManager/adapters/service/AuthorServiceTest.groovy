package pl.sidor.ArticleManager.adapters.service

import pl.sidor.ArticleManager.domain.model.entity.Author
import spock.lang.Shared
import spock.lang.Specification
import utils.AuthorUtils

import javax.persistence.EntityManager

class AuthorServiceTest extends Specification {

    AuthorService authorService = []
    EntityManager entityManager

    @Shared
    Long id = 1L

    void setup() {
        entityManager = Stub(EntityManager.class)
    }

    def "should save Author"() {
        given:
        entityManager.persist(AuthorUtils.getAuthor1())
        authorService.setEntityManager(entityManager)

        when:
        def result = authorService.save(AuthorUtils.getAuthor1())

        then:
        noExceptionThrown()
        result != null
        result.name == AuthorUtils.getAuthor1().name
        result.lastName == AuthorUtils.getAuthor1().lastName
        result.email == AuthorUtils.getAuthor1().email
    }

    def "should find Author by ID"() {
        given:
        entityManager.find(Author.class, id) >> AuthorUtils.getAuthor1()
        authorService.setEntityManager(entityManager)

        when:
        def result = authorService.getById(id)

        then:
        noExceptionThrown()
        result != null
        result.get().name == AuthorUtils.getAuthor1().name
        result.get().lastName == AuthorUtils.getAuthor1().lastName
        result.get().email == AuthorUtils.getAuthor1().email
    }

    def "should modify Author"() {
        given:
        entityManager.find(Author.class, id) >> AuthorUtils.getFullAuthor()
        entityManager.merge(_ as Author) >> AuthorUtils.getFullAuthorSecond()

        authorService.setEntityManager(entityManager)

        when:
        def result = authorService.modify(AuthorUtils.getFullAuthor())

        then:
        noExceptionThrown()
        result != null
        result.name == AuthorUtils.getFullAuthorSecond().name
        result.lastName == AuthorUtils.getFullAuthorSecond().lastName
        result.email == AuthorUtils.getFullAuthorSecond().email
    }

    def "should delete Author  by ID"() {
        given:
        entityManager.find(Author.class, id) >> AuthorUtils.getAuthor2()
        authorService.setEntityManager(entityManager)

        when:
        authorService.delete(id)

        then:
        noExceptionThrown()
    }
}
