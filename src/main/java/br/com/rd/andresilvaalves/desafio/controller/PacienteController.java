package br.com.rd.andresilvaalves.desafio.controller;

import br.com.rd.andresilvaalves.desafio.dto.PacienteDTO;
import br.com.rd.andresilvaalves.desafio.service.PacienteService;
import br.com.rd.andresilvaalves.desafio.service.RDCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController extends RDCRUDController<PacienteDTO> {

    @Autowired
    private PacienteService pacienteService;

    @Override
    protected RDCRUDService getService() {
        return pacienteService;
    }

}
