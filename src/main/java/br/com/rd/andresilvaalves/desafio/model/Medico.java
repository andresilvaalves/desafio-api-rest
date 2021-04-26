package br.com.rd.andresilvaalves.desafio.model;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true, of = {"crm", "uf"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medico extends RDEntity {

    private String nome;

    private Long crm;

    private String uf;

    private Integer especialidade;

}
