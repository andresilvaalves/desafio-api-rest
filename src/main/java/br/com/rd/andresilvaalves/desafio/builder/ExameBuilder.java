package br.com.rd.andresilvaalves.desafio.builder;

import br.com.rd.andresilvaalves.desafio.dto.ExameDTO;
import br.com.rd.andresilvaalves.desafio.model.Exame;
import lombok.NonNull;

public class ExameBuilder implements RDBuilder<ExameDTO, Exame>{

    @Override
    public ExameDTO builderToDTO(@NonNull Exame entity) {
        return ExameDTO.builder()
                       .nomeExame(entity.getNomeExame())
                       .tipo(entity.getTipo())
                       .dataCriacao(entity.getDataCriacao())
                       .uuid(entity.getUuid())
                       .build();
    }

    @Override
    public void builderToEntity(@NonNull Exame entity, @NonNull ExameDTO dto) {
        entity.setNomeExame(dto.getNomeExame());
        entity.setTipo(dto.getTipo());
    }
}
