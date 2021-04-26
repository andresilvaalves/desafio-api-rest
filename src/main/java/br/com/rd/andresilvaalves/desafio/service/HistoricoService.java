package br.com.rd.andresilvaalves.desafio.service;

import br.com.rd.andresilvaalves.desafio.builder.HistoricoBuilder;
import br.com.rd.andresilvaalves.desafio.builder.RDBuilder;
import br.com.rd.andresilvaalves.desafio.dto.HistoricoDTO;
import br.com.rd.andresilvaalves.desafio.exception.RDIllegalAccessException;
import br.com.rd.andresilvaalves.desafio.model.Historico;
import br.com.rd.andresilvaalves.desafio.repository.HistoricoRepository;
import br.com.rd.andresilvaalves.desafio.repository.RDRepository;
import br.com.rd.andresilvaalves.desafio.specification.HistoricoCriteria;
import br.com.rd.andresilvaalves.desafio.specification.HistoricoSpecification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class HistoricoService extends RDCRUDService<HistoricoDTO, Historico>{

    private final HistoricoRepository historicoRepository;

    @Override
    protected RDBuilder<HistoricoDTO, Historico> getBuilder() {
        return new HistoricoBuilder();
    }

    @Override
    protected RDRepository<Historico> getRepository() {
        return this.historicoRepository;
    }

    public Page<HistoricoDTO> findByFields(@NonNull HistoricoCriteria historicoCriteria, Integer page, Integer pageSize) {
        Page<Historico> all = historicoRepository.findAll(new HistoricoSpecification(historicoCriteria), PageRequest.of(page, pageSize));
        return all.map(m -> this.getBuilder().builderToDTO(m));
    }

    @Override
    public void delete(@NonNull UUID uuid) {
        throw new RDIllegalAccessException("Historico não deve ser apagado!!");
    }

    @Override
    public HistoricoDTO update(@NonNull HistoricoDTO dto) {
        throw new RDIllegalAccessException("Historico não deve ser alterado!!");
    }
}
