package pl.sidor.ArticleManager.adapters.api;

import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.mapper.ContentMapper;
import pl.sidor.ArticleManager.adapters.response.ContentResponse;
import pl.sidor.ArticleManager.adapters.service.ContentService;
import pl.sidor.ArticleManager.domain.model.entity.Content;
import pl.sidor.ArticleManager.exception.MessageException;

import static java.util.Objects.isNull;
import static pl.sidor.ArticleManager.exception.MessageException.*;

@Component
@RequiredArgsConstructor
public class ContentFasade {

    private final ContentService contentService;
    private final ContentResponse contentResponse;

    ContentResponse getById(Long id) {
        Option<Content> content = contentService.getById(id);
        return contentResponse.createResponse(content, MessageException.NOT_FOUND_CONTENT_BY_ID.getMessage());
    }

    ContentResponse save(Content content) {
        return isNull(content.getValue()) ? contentResponse.createFailsResponse(NOT_SAVE_CONTENT.getMessage()) : saveContent(content);
    }

    ContentResponse modify(Content content) {
        Option<Content> currentContent = Option.of(contentService.modify(content));
        String message = currentContent.isEmpty() ? NOT_MODIFY_CONTENT.getMessage() : MODIFY_CONTENT.getMessage();
        return contentResponse.createResponse(currentContent, message);
    }

    ContentResponse delete(Long id) {
        Option<Content> content = contentService.delete(id);
        String message = content.isEmpty() ? NOT_DELETE_CONTENT_BY_ID.getMessage() : DELETE_BY_CONTENT_ID.getMessage();
        return contentResponse.createResponse(content, message);
    }

    private ContentResponse saveContent(Content content) {
        Content currentContent = contentService.save(content);
        return ContentMapper.map(currentContent);
    }
}
