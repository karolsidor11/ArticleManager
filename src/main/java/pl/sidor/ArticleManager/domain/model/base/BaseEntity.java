package pl.sidor.ArticleManager.domain.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<PK> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    PK id;
}
