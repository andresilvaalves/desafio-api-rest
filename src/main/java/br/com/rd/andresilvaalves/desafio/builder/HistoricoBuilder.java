package br.com.rd.andresilvaalves.desafio.builder;

import br.com.rd.andresilvaalves.desafio.dto.HistoricoDTO;
import br.com.rd.andresilvaalves.desafio.model.Historico;
import lombok.NonNull;

public class HistoricoBuilder implements RDBuilder<HistoricoDTO, Historico> {

    @Override
    public HistoricoDTO builderToDTO(@NonNull Historico entity) {
        return HistoricoDTO.builder()
                           .pacienteDTO(new PacienteBuilder().builderToDTO(entity.getPaciente()))
                           .medicoDTO(new MedicoBuilder().builderToDTO(entity.getMedico()))
                           .exameDTO(new ExameBuilder().builderToDTO(entity.getExame()))
                           .uuid(entity.getUuid())
                           .build();
    }

    @Override
    public void builderToEntity(@NonNull Historico entity, @NonNull HistoricoDTO dto) {

        new ExameBuilder().builderToEntity(entity.getExame(), dto.getExameDTO());
        new MedicoBuilder().builderToEntity(entity.getMedico(),dto.getMedicoDTO());
        new PacienteBuilder().builderToEntity(entity.getPaciente(), dto.getPacienteDTO());

    }
}
