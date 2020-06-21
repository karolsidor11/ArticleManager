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

    public static Content getFullContent(){
        Content content = new Content();
        content.setId(1L);
        content.setValue("Treść podstawowa");
        return content;
    }

    public static Content getFullContentSecond(){
        Content content = new Content();
        content.setId(1L);
        content.setValue("Treść zmieniona");
        return content;
    }
}
