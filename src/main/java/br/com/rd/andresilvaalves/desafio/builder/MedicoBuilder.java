package br.com.rd.andresilvaalves.desafio.builder;

import br.com.rd.andresilvaalves.desafio.dto.MedicoDTO;
import br.com.rd.andresilvaalves.desafio.model.Medico;
import lombok.NonNull;

public class MedicoBuilder implements RDBuilder<MedicoDTO, Medico> {


    @Override
    public MedicoDTO builderToDTO(@NonNull Medico entity) {
        return MedicoDTO.builder()
                        .nome(entity.getNome())
                        .crm(entity.getCrm())
                        .uf(entity.getUf())
                        .especialidade(entity.getEspecialidade())
                        .uuid(entity.getUuid())
                        .build();
    }

    @Override
    public void builderToEntity(@NonNull Medico entity, @NonNull MedicoDTO dto) {
        entity.setNome(dto.getNome());
        entity.setCrm(dto.getCrm());
        entity.setUf(dto.getUf());
        entity.setEspecialidade(dto.getEspecialidade());
    }
}
