package br.com.rd.andresilvaalves.desafio.repository;

import br.com.rd.andresilvaalves.desafio.model.RDEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface RDRepository<T extends RDEntity> extends JpaRepository<T, UUID>, JpaSpecificationExecutor<T> {

    Page<T> findAllByAtivoIsTrue(Pageable pageable);

}
