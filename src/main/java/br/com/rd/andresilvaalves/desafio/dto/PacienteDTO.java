package br.com.rd.andresilvaalves.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO extends AbstractRDDTO {

    private String nome;

    private String cpf;

    private LocalDate dataNascimento;
}
