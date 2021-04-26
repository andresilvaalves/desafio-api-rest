package br.com.rd.andresilvaalves.desafio.model;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true, of = {"cpf"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Paciente extends RDEntity {

    private String nome;

    private String cpf;

    private LocalDate dataNascimento;

}
