package pl.sidor.ArticleManager.adapters.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.sidor.ArticleManager.adapters.response.ContentResponse;
import pl.sidor.ArticleManager.domain.model.entity.Content;

import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ContentMapper {

    public static ContentResponse map(Content content) {
        return ContentResponse.builder()
                .applicationName("Article Manager")
                .applicationVersion("1.0.0 SNAPSHOT")
                .actualDate(ZonedDateTime.now())
                .value(content.getValue())
                .build();
    }
}
