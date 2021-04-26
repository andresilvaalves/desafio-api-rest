package br.com.rd.andresilvaalves.desafio.service;

import br.com.rd.andresilvaalves.desafio.builder.PacienteBuilder;
import br.com.rd.andresilvaalves.desafio.builder.RDBuilder;
import br.com.rd.andresilvaalves.desafio.dto.PacienteDTO;
import br.com.rd.andresilvaalves.desafio.model.Paciente;
import br.com.rd.andresilvaalves.desafio.repository.PacienteRepository;
import br.com.rd.andresilvaalves.desafio.repository.RDRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PacienteService extends RDCRUDService<PacienteDTO, Paciente> {

    private final PacienteRepository pacienteRepository;

    @Override
    protected RDBuilder getBuilder() {
        return new PacienteBuilder();
    }

    @Override
    protected RDRepository getRepository() {
        return this.pacienteRepository;
    }

}
