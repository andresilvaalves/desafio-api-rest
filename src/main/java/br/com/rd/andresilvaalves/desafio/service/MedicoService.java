package br.com.rd.andresilvaalves.desafio.service;

import br.com.rd.andresilvaalves.desafio.builder.MedicoBuilder;
import br.com.rd.andresilvaalves.desafio.builder.RDBuilder;
import br.com.rd.andresilvaalves.desafio.dto.MedicoDTO;
import br.com.rd.andresilvaalves.desafio.model.Medico;
import br.com.rd.andresilvaalves.desafio.repository.MedicoRepository;
import br.com.rd.andresilvaalves.desafio.repository.RDRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MedicoService extends RDCRUDService<MedicoDTO, Medico>{

    private final MedicoRepository medicoRepository;

    @Override
    protected RDBuilder<MedicoDTO, Medico> getBuilder() {
        return new MedicoBuilder();
    }

    @Override
    protected RDRepository<Medico> getRepository() {
        return this.medicoRepository;
    }


}
