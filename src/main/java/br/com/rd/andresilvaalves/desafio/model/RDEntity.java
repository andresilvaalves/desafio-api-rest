package br.com.rd.andresilvaalves.desafio.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@ToString(of = {"uuid", "ativo"})
@EqualsAndHashCode(of = { "uuid" })
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class RDEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_medico", updatable = false, nullable = false)
    private UUID uuid;

    private Boolean ativo = Boolean.TRUE;

    @CreatedDate
    @Column(name = "dataCriacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

}
