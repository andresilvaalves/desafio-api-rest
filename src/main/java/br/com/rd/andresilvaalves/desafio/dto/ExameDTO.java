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
public class ExameDTO extends AbstractRDDTO {

    private String nomeExame;

    private Integer tipo;
}
