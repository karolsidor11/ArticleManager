package pl.sidor.ArticleManager.domain.model.entity;

import lombok.*;
import pl.sidor.ArticleManager.domain.model.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = 4127699631792769582L;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "emial")
    private String eamil;
}
