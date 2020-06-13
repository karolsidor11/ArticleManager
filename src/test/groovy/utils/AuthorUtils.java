package utils;

import pl.sidor.ArticleManager.domain.model.entity.Author;

public class AuthorUtils {

    public static Author getAuthor1(){
        return Author.builder()
                .name("Jan")
                .lastName("Nowak")
                .email("nowak@wp.pl")
                .build();
    }

    public static Author getAuthor2(){
        return Author.builder()
                .name("Jan")
                .lastName("Kowalski")
                .email("kowalski@wp.pl")
                .build();
    }
}
