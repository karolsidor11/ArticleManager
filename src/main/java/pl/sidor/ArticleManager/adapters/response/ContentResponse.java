package pl.sidor.ArticleManager.adapters.response;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.mapper.ContentMapper;
import pl.sidor.ArticleManager.domain.model.entity.Content;

import java.time.ZonedDateTime;

@Getter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public final class ContentResponse {

    private String applicationName;
    private String applicationVersion;
    private ZonedDateTime actualDate;
    private String value;
    private String message;

    public ContentResponse createResponse(Option<Content> content, String message){
        return content.isEmpty() ? createFailsResponse(message) : createSuccesResponse(content.get());
    }

    public ContentResponse createFailsResponse(String message){
        return ContentMapper.buildFailsResponse(message);
    }

    protected ContentResponse createSuccesResponse(Content content){
        return ContentMapper.buildSuccessResponse(content);
    }
}
