package pl.sidor.ArticleManager.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.sidor.ArticleManager.adapters.response.ContentResponse;
import pl.sidor.ArticleManager.domain.model.entity.Content;

@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentEndpoint {

    private final ContentFasade contentFasade;

    @GetMapping(value = "/{id}")
    public ContentResponse getById(@PathVariable Long id) {
        return contentFasade.getById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContentResponse saveContent(@RequestBody Content content) {
        return contentFasade.save(content);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContentResponse modifyContent(@RequestBody Content content) {
        return contentFasade.modify(content);
    }

    @DeleteMapping(value = "/{id}")
    public ContentResponse removeById(@PathVariable Long id) {
        return contentFasade.delete(id);
    }
}
