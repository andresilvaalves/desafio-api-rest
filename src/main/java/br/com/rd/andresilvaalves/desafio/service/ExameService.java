package br.com.rd.andresilvaalves.desafio.service;

import br.com.rd.andresilvaalves.desafio.builder.ExameBuilder;
import br.com.rd.andresilvaalves.desafio.builder.RDBuilder;
import br.com.rd.andresilvaalves.desafio.dto.ExameDTO;
import br.com.rd.andresilvaalves.desafio.model.Exame;
import br.com.rd.andresilvaalves.desafio.repository.ExameRepository;
import br.com.rd.andresilvaalves.desafio.repository.RDRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExameService extends RDCRUDService<ExameDTO, Exame>{

    private final ExameRepository exameRepository;

    @Override
    protected RDBuilder<ExameDTO, Exame> getBuilder() {
        return new ExameBuilder();
    }

    @Override
    protected RDRepository<Exame> getRepository() {
        return this.exameRepository;
    }
}
