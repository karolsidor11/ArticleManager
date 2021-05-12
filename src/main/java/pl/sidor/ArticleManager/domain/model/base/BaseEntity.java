package pl.sidor.ArticleManager.domain.model.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<PK> implements Serializable {

    private static final long serialVersionUID = 6550892975762323491L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    PK id;
}
