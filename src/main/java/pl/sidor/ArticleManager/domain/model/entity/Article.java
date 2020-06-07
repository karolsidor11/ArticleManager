package pl.sidor.ArticleManager.domain.model.entity;

import lombok.*;
import pl.sidor.ArticleManager.domain.model.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true)
public class Article extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -602378160085799789L;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne
    @JoinColumn(name = "content_id")
    private Content content;
}
