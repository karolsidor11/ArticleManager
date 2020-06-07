package pl.sidor.ArticleManager.adapters.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
public final class ContentResponse {

    private String applicationName;
    private String applicationVersion;
    private ZonedDateTime actualDate;
    private String value;
}
