package pl.sidor.ArticleManager.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.ArticleManager.adapters.mapper.ContentMapper;
import pl.sidor.ArticleManager.adapters.response.ContentResponse;
import pl.sidor.ArticleManager.adapters.service.ContentService;
import pl.sidor.ArticleManager.domain.model.entity.Content;

@Component
@RequiredArgsConstructor
public class ContentFasade {

    private final ContentService contentService;

    ContentResponse getById(Long id) {
        Content content = contentService.getById(id).getOrNull();
        return ContentMapper.map(content);
    }

    ContentResponse save(Content content) {
        Content currentContent = contentService.save(content);
        return ContentMapper.map(currentContent);
    }

    ContentResponse modify(Content content) {
        contentService.modify(content);
        return ContentMapper.map(content);
    }

    ContentResponse delete(Long id) {
        contentService.delete(id);
        return ContentMapper.map(Content.builder().value(String.valueOf(id)).build());
    }
}
