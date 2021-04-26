package br.com.rd.andresilvaalves.desafio.specification;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class HistoricoCriteria {

    private Boolean ativo;

    private LocalDate periodoInicio;

    private LocalDate periodoFim;
}
