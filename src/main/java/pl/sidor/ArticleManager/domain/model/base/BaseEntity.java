package pl.sidor.ArticleManager.domain.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<PK> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    PK id;
}
