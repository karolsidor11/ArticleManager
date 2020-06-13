package pl.sidor.ArticleManager.adapters.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.sidor.ArticleManager.adapters.response.ContentResponse;
import pl.sidor.ArticleManager.domain.model.entity.Content;
import java.time.ZonedDateTime;

import static pl.sidor.ArticleManager.utils.ApplicationUtils.APPLICATION_NAME;
import static pl.sidor.ArticleManager.utils.ApplicationUtils.APPLICATION_VERSION;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ContentMapper {

    public static ContentResponse map(Content content) {
        return ContentResponse.builder()
                .applicationName(APPLICATION_NAME)
                .applicationVersion(APPLICATION_VERSION)
                .actualDate(ZonedDateTime.now())
                .value(content.getValue())
                .build();
    }

    public static Content modifyContent(Content actualContent, Content modifyContent){
        actualContent.setValue(modifyContent.getValue());
        return actualContent;
    }
}
