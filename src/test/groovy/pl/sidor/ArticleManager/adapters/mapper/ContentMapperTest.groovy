package pl.sidor.ArticleManager.adapters.mapper

import pl.sidor.ArticleManager.domain.model.entity.Content
import pl.sidor.ArticleManager.utils.ApplicationUtils
import spock.lang.Specification
import utils.ContentUtils

class ContentMapperTest extends Specification {

    def "should map Content to ContentResponse"() {
        given:
        Content content = ContentUtils.getContent1()

        when:
        def result = ContentMapper.map(content)

        then:
        result != null
        noExceptionThrown()
        result.value == content.value
        result.applicationName== ApplicationUtils.APPLICATION_NAME
        result.applicationVersion== ApplicationUtils.APPLICATION_VERSION
    }

    def "should modify Content"() {
        given:
        Content content = ContentUtils.getContent1()
        and:
        Content content2 = ContentUtils.getContent2()

        when:
        def result = ContentMapper.modifyContent(content, content2)

        then:
        result != null
        noExceptionThrown()
        result.value == content2.value
    }
}
