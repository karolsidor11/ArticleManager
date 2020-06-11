package pl.sidor.ArticleManager.adapters.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public final class AuthorResponse {

    private String applicationName;
    private String applicationVersion;
    private String name;
    private String lastName;
    private String email;
}
