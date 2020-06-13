package utils;

import pl.sidor.ArticleManager.domain.model.entity.Content;

public class ContentUtils {

    public static Content getContent1(){
        return Content.builder()
                .value("Treść testowa")
                .build();
    }

    public static Content getContent2(){
        return Content.builder()
                .value("Zmieniona treść testowa")
                .build();
    }
}
