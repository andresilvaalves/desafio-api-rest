package br.com.rd.andresilvaalves.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO extends AbstractRDDTO {

    private Long crm;

    private String nome;

    private String uf;

    private Integer especialidade;


}
