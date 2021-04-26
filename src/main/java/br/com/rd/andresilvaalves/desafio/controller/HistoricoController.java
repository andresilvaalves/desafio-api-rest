package br.com.rd.andresilvaalves.desafio.controller;

import br.com.rd.andresilvaalves.desafio.dto.HistoricoDTO;
import br.com.rd.andresilvaalves.desafio.service.HistoricoService;
import br.com.rd.andresilvaalves.desafio.specification.HistoricoCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public Page<HistoricoDTO> findByFields(@RequestParam(value = "periodoInicio", required = false) LocalDate periodoInicio,
                                           @RequestParam(value = "periodoFim", required = false) LocalDate periodoFim,
                                           @RequestParam(value = "ativo", defaultValue = "true") Boolean ativo,
                                           @RequestParam(name = "page", defaultValue = "0") Integer page,
                                           @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        HistoricoCriteria historicoCriteria = HistoricoCriteria.builder()
                                                               .ativo(ativo)
                                                               .periodoInicio(periodoInicio)
                                                               .periodoFim(periodoFim)
                                                               .build();

        return this.historicoService.findByFields(historicoCriteria, page, pageSize);
    }


}
