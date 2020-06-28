package pl.sidor.ArticleManager.exception;

import lombok.Getter;

@Getter
public enum MessageException {

    NOT_FOUND_BY_ID("Nie znaleziono Artykułu o podanym identyfikatorze"),
    NOT_FOUND_CONTENT_BY_ID("Nie znaleziono Treści o podanym identyfikatorze"),
    NOT_FOUND_AUTHOR_BY_ID("Nie znaleziono Autora o podanym identyfikatorze"),
    NOT_FOUND_BY_TITLE("Nie znaleziono Artykułu o podanym tytule"),
    NOT_FOUND_BY_NAME_LASTNAME("Nie znaleziono Autora o podanym imieniu i nazwisku."),
    NOT_DELETE_BY_ID("Nie usunięto Artykułu o przekazanym ID"),
    DELETE_BY_ID("Usunięto Artykułu o przekazanym ID"),
    NOT_DELETE_CONTENT_BY_ID("Nie usunięto Treści o przekazanym ID"),
    DELETE_BY_CONTENT_ID("Usunięto Treść o przekazanym ID"),
    NOT_DELETE_AUTHOR_BY_ID("Nie usunięto Autora o przekazanym ID"),
    DELETE_BY_AUTHOR_ID("Usunięto Autora o przekazanym ID"),
    NOT_SAVE("Nie udało się zapisać Artykułu"),
    NOT_SAVE_CONTENT("Nie udało się zapisać Treści"),
    NOT_SAVE_AUTHOR("Nie udało się zapisać Autora"),
    NOT_MODIFY("Nie udało się zmodyfikować Artykułu"),
    MODIFY_ARTICLE("Artykuł został zmodyfikowany"),
    NOT_MODIFY_AUTHOR("Nie udało się zmodyfikować Autora"),
    MODIFY_AUTHOR("Autor został zmodyfikowany"),
    NOT_MODIFY_CONTENT("Nie udało się zmodyfikować Treści"),
    MODIFY_CONTENT("Treść została zmodyfikwana");

    MessageException(String message) {
        this.message = message;
    }

    private String message;
}
