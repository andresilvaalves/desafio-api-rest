package br.com.rd.andresilvaalves.desafio.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Exame extends RDEntity{

    @Column(name = "nmExame")
    private String nomeExame;

    private Integer tipo;

}
