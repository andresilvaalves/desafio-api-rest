package br.com.rd.andresilvaalves.desafio.service;

import br.com.rd.andresilvaalves.desafio.builder.RDBuilder;
import br.com.rd.andresilvaalves.desafio.dto.IRDDTO;
import br.com.rd.andresilvaalves.desafio.exception.RDEntityNotFoundException;
import br.com.rd.andresilvaalves.desafio.model.RDEntity;
import br.com.rd.andresilvaalves.desafio.repository.RDRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.UUID;

@Slf4j
@Service
public abstract class RDCRUDService<D extends IRDDTO, E extends RDEntity> {

    protected abstract RDBuilder<D, E> getBuilder();

    protected abstract RDRepository<E> getRepository();

    public Page<D> findAll(Integer page, Integer pageSize) {
        Page<E> pages = this.getRepository().findAllByAtivoIsTrue(PageRequest.of(page, pageSize));
        return pages.map(m -> this.getBuilder().builderToDTO(m));
    }

    public D findById(@NonNull UUID uuid) {
        E entity = this.getRepository().findById(uuid).orElseThrow(() -> new RDEntityNotFoundException(uuid.toString()));
        return this.getBuilder().builderToDTO(entity);
    }

    public D save(@NonNull D dto) {
        E entity = createEntity();
        this.getBuilder().builderToEntity(entity, dto);

        E saved = this.getRepository().save(entity);
        return this.getBuilder().builderToDTO(saved);
    }

    public D update(@NonNull D dto) {
        E entity = this.getRepository().findById(dto.getUuid()).orElseThrow(() -> new RDEntityNotFoundException(dto.getUuid().toString()));

        this.getBuilder().builderToEntity(entity, dto);
        E saved = this.getRepository().save(entity);
        return this.getBuilder().builderToDTO(saved);
    }

    public void delete(@NonNull UUID uuid) {
        E entity = getRepository().findById(uuid).orElseThrow(() -> new RDEntityNotFoundException(uuid.toString()));
        entity.setAtivo(Boolean.FALSE);
        this.getRepository().save(entity);
    }

    private E createEntity() {
        try {
            Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
            Class<E> clazz = (Class<E>) actualTypeArguments[1];
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("Erro ao criar instancia de entidade: ", e);
            throw  new IllegalArgumentException(e.getMessage());
        }
    }

}
