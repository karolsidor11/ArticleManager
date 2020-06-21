package pl.sidor.ArticleManager.adapters.service

import pl.sidor.ArticleManager.domain.model.entity.Article
import spock.lang.Shared
import spock.lang.Specification
import utils.ArticleUtils

import javax.persistence.EntityManager

class ArticleServiceTest extends Specification {

    ArticleService articleService = []
    EntityManager entityManager

    @Shared
    Long id = 1L

    void setup() {
        entityManager = Stub(EntityManager.class)
    }

    def "should find Article by ID"() {
        when:
        entityManager.find(Article.class, id) >> ArticleUtils.getArticle1()
        articleService.setEntityManager(entityManager)

        def result = articleService.getById(id)

        then:
        noExceptionThrown()
        result != null
        result.get().title == ArticleUtils.getArticle1().title
        result.get().author.name == ArticleUtils.getArticle1().author.name
        result.get().author.lastName == ArticleUtils.getArticle1().author.lastName
        result.get().author.email == ArticleUtils.getArticle1().author.email
        result.get().content.value == ArticleUtils.getArticle1().content.value
    }

    def "should save Article"() {
        when:
        entityManager.persist(ArticleUtils.getArticle2())
        articleService.setEntityManager(entityManager)

        def result = articleService.save(ArticleUtils.getArticle2())

        then:
        noExceptionThrown()
        result != null
        result.getTitle()==ArticleUtils.getArticle2().title
    }

    def "should delete Article by ID"() {
        when:
        entityManager.find(Article.class, id) >> ArticleUtils.getArticle1()
        articleService.setEntityManager(entityManager)
        articleService.delete(id)

        then:
        noExceptionThrown()
    }
}
