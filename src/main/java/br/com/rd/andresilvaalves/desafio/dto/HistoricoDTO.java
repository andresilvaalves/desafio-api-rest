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
public class HistoricoDTO extends AbstractRDDTO {

    private ExameDTO exameDTO;

    private PacienteDTO pacienteDTO;

    private MedicoDTO medicoDTO;

}
