package br.com.rd.andresilvaalves.desafio.specification;

import br.com.rd.andresilvaalves.desafio.model.Historico;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class HistoricoSpecification implements Specification<Historico> {

    private final HistoricoCriteria historicoCriteria;


    @Override
    public Predicate toPredicate(Root<Historico> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if(historicoCriteria.getPeriodoInicio() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dataCriacao"), historicoCriteria.getPeriodoInicio()));
        }

        if(historicoCriteria.getPeriodoFim() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dataCriacao"), historicoCriteria.getPeriodoFim()));
        }

        predicates.add(criteriaBuilder.equal(root.get("ativo"), historicoCriteria.getAtivo()));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
