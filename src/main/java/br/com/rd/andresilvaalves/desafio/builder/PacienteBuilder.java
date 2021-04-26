package br.com.rd.andresilvaalves.desafio.builder;

import br.com.rd.andresilvaalves.desafio.dto.PacienteDTO;
import br.com.rd.andresilvaalves.desafio.model.Paciente;
import lombok.NonNull;

public class PacienteBuilder implements RDBuilder<PacienteDTO, Paciente> {
    @Override
    public PacienteDTO builderToDTO(@NonNull Paciente entity) {
        return PacienteDTO.builder()
                          .nome(entity.getNome())
                          .cpf(entity.getCpf())
                          .dataNascimento(entity.getDataNascimento())
                          .uuid(entity.getUuid())
                          .build();
    }

    @Override
    public void builderToEntity(@NonNull Paciente entity, @NonNull PacienteDTO dto) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
    }
}
