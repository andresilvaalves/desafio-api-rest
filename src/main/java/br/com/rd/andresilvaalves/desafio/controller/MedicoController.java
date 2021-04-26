package br.com.rd.andresilvaalves.desafio.controller;

import br.com.rd.andresilvaalves.desafio.dto.MedicoDTO;
import br.com.rd.andresilvaalves.desafio.service.MedicoService;
import br.com.rd.andresilvaalves.desafio.service.RDCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController extends RDCRUDController<MedicoDTO> {

    @Autowired
    private MedicoService medicoService;

    @Override
    protected RDCRUDService getService() {
        return this.medicoService;
    }
}
