package pl.sidor.ArticleManager.adapters.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.sidor.ArticleManager.domain.model.entity.Author;
import pl.sidor.ArticleManager.domain.model.entity.Content;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder(toBuilder = true)
public final class ArticleResponse {

    private String applicationName;
    private String applicationVersion;
    private ZonedDateTime actualDate;
    private String title;
    private Author author;
    private Content content;
}
