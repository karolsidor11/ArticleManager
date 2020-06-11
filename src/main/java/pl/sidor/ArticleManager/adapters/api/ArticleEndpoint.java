package pl.sidor.ArticleManager.adapters.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.sidor.ArticleManager.adapters.response.ArticleResponse;
import pl.sidor.ArticleManager.domain.model.entity.Article;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleEndpoint {

    private final ArticleFasade articleFasade;

    @GetMapping(value = "/{id}")
    public ArticleResponse findById(@PathVariable Long id) {
        return articleFasade.findById(id);
    }

    @GetMapping(value = "/title/{title}")
    public ArticleResponse findByTitle(@PathVariable String title) {
        return articleFasade.findByTitle(title);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleResponse save(@RequestBody Article article) {
        return articleFasade.save(article);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleResponse modify(@RequestBody Article article) {
        return articleFasade.modify(article);
    }

    @DeleteMapping(value = "/{id}")
    public ArticleResponse delete(@PathVariable Long id) {
        return articleFasade.delete(id);
    }
}
