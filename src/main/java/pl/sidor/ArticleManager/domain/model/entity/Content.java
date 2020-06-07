package pl.sidor.ArticleManager.domain.model.entity;

import lombok.*;
import pl.sidor.ArticleManager.domain.model.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Content extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -1903183520752490413L;

    @Column(name = "value")
    private String value;
}
