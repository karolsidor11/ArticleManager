package pl.sidor.ArticleManager.adapters.mapper

import pl.sidor.ArticleManager.domain.model.entity.Author
import pl.sidor.ArticleManager.utils.ApplicationUtils
import spock.lang.Specification
import utils.AuthorUtils

class AuthorMapperTest extends Specification {

    def "should map Author to AuthorResponse"() {
        given:
        Author author = AuthorUtils.getAuthor1()

        when:
        def result = AuthorMapper.map(author)

        then:
        noExceptionThrown()
        result != null
        result.name == author.name
        result.lastName == author.lastName
        result.email == author.email
        result.applicationName== ApplicationUtils.APPLICATION_NAME
        result.applicationVersion== ApplicationUtils.APPLICATION_VERSION
    }

    def "should modify Author"() {
        given:
        Author author = AuthorUtils.getAuthor1()
        and:
        Author author2 = AuthorUtils.getAuthor2()

        when:
        def result = AuthorMapper.modifyAuthor(author, author2)

        then:
        result != null
        noExceptionThrown()
        result.name == author2.name
        result.lastName == author2.lastName
        result.email == author2.email

    }
}
