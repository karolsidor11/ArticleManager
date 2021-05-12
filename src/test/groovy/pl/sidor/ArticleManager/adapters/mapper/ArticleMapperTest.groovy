package pl.sidor.ArticleManager.adapters.mapper

import pl.sidor.ArticleManager.domain.model.entity.Article
import pl.sidor.ArticleManager.utils.ApplicationUtils
import spock.lang.Specification
import utils.ArticleUtils

class ArticleMapperTest extends Specification {

    def "should map Article  to ArticleResponse"() {
        given:
        Article article = ArticleUtils.getArticle1()

        when:
        def result = ArticleMapper.buildSuccessResponse(article)

        then:
        result != null
        noExceptionThrown()
        result.getTitle() == article.title
        result.applicationName== ApplicationUtils.APPLICATION_NAME
        result.applicationVersion== ApplicationUtils.APPLICATION_VERSION
    }

    def "should modify Article"() {
        given:
        Article article = ArticleUtils.getArticle1()
        and:
        Article article2 = ArticleUtils.getArticle2()

        when:
        def result = ArticleMapper.modifyArticle(article, article2)

        then:
        result != null
        noExceptionThrown()
        result.title == article2.title
        result.author==article2.author
        result.content==article2.content
    }
}
