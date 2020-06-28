package pl.sidor.ArticleManager.adapters.response;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.mapper.ContentMapper;
import pl.sidor.ArticleManager.domain.model.entity.Content;
import pl.sidor.ArticleManager.utils.ApplicationUtils;

import java.time.ZonedDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public final class ContentResponse {

    private String applicationName;
    private String applicationVersion;
    private ZonedDateTime actualDate;
    private String value;
    private String message;

    public ContentResponse createResponse(Option<Content> content, String message){
        return content.isEmpty()? buildFailsResponse(message):createSuccesResponse(content.get());
    }

    public ContentResponse createFailsResponse(String message){
        return buildFailsResponse(message);
    }

    private ContentResponse createSuccesResponse(Content content){
        return ContentMapper.map(content);
    }

    private ContentResponse buildFailsResponse(String message){
        return ContentResponse.builder()
                .applicationName(ApplicationUtils.APPLICATION_NAME)
                .applicationVersion(ApplicationUtils.APPLICATION_VERSION)
                .actualDate(ZonedDateTime.now())
                .message(message)
                .build();
    }
}
