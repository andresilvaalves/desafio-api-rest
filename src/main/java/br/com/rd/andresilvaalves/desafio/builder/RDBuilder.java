package br.com.rd.andresilvaalves.desafio.builder;

import br.com.rd.andresilvaalves.desafio.dto.IRDDTO;
import br.com.rd.andresilvaalves.desafio.model.RDEntity;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public interface RDBuilder<D extends IRDDTO, E extends RDEntity> {

     D builderToDTO(@NonNull E entity);

     void builderToEntity(@NonNull E entity, @NonNull D dto);

}
