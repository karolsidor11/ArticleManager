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

    public static Author getFullAuthor(){
        Author author= new Author();
        author.setId(1L);
        author.setName("Jan");
        author.setLastName("Kowalski");
        author.setEmail("kowalski@wp.pl");

        return author;
    }

    public static Author getFullAuthorSecond(){
        Author author= new Author();
        author.setId(1L);
        author.setName("Jan");
        author.setLastName("Nowak");
        author.setEmail("nowak@wp.pl");

        return author;
    }
}
