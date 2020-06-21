package pl.sidor.ArticleManager.adapters.service

import pl.sidor.ArticleManager.domain.model.entity.Content
import spock.lang.Shared
import spock.lang.Specification
import utils.ContentUtils

import javax.persistence.EntityManager

class ContentServiceTest extends Specification {

    ContentService contentService = []
    EntityManager entityManager

    @Shared
    Long id = 1L

    void setup() {
        entityManager = Stub(EntityManager.class)
    }

    def "should find Content by ID"() {
        given:
        entityManager.find(Content.class, id) >> ContentUtils.getContent1()
        contentService.setEntityManager(entityManager)

        when:
        def result = contentService.getById(id)

        then:
        noExceptionThrown()
        result != null
        result.get().value == ContentUtils.getContent1().value
    }

    def "should save Content"() {
        given:
        Content content = ContentUtils.getContent1()

        when:
        entityManager.persist(content)
        contentService.setEntityManager(entityManager)
        def result = contentService.save(content)

        then:
        noExceptionThrown()
        result != null
        result.value == content.value
    }

    def "should delete Content by ID"() {
        given:
        entityManager.find(Content.class, id) >> ContentUtils.getContent1()
        entityManager.remove(ContentUtils.getContent1())
        contentService.setEntityManager(entityManager)

        when:
        contentService.delete(id)

        then:
        noExceptionThrown()
    }

    def "should modify Content"() {
        given:
        entityManager.find(Content.class, id) >> ContentUtils.getFullContent()
        entityManager.merge(_ as Content) >> ContentUtils.getFullContentSecond()
        contentService.setEntityManager(entityManager)

        when:
        def result = contentService.modify(ContentUtils.getFullContentSecond())

        then:
        noExceptionThrown()
        result != null
    }
}
