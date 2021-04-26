package br.com.rd.andresilvaalves.desafio.controller;

import br.com.rd.andresilvaalves.desafio.dto.ExameDTO;
import br.com.rd.andresilvaalves.desafio.service.ExameService;
import br.com.rd.andresilvaalves.desafio.service.RDCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exame")
public class ExameController extends RDCRUDController<ExameDTO> {

    @Autowired
    private ExameService exameService;

    @Override
    protected RDCRUDService getService() {
        return this.exameService;
    }
}
