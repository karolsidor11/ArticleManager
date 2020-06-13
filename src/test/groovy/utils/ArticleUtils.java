package utils;

import pl.sidor.ArticleManager.domain.model.entity.Article;

public class ArticleUtils {

    public static Article getArticle1() {
        return Article.builder()
                .title("JAVA 14")
                .author(AuthorUtils.getAuthor1())
                .content(ContentUtils.getContent1())
                .build();
    }

    public static Article getArticle2() {
        return Article.builder()
                .title("JAVA 15")
                .author(AuthorUtils.getAuthor2())
                .content(ContentUtils.getContent2())
                .build();
    }
}
