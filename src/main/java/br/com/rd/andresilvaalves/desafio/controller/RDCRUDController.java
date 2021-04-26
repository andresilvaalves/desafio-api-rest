package br.com.rd.andresilvaalves.desafio.controller;

import br.com.rd.andresilvaalves.desafio.dto.IRDDTO;
import br.com.rd.andresilvaalves.desafio.service.RDCRUDService;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class RDCRUDController<D extends IRDDTO> {

    protected abstract RDCRUDService getService();

    @GetMapping
    public Page<D> findByFields(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return getService().findAll(page, pageSize);
    }

    @GetMapping("{uuid}")
    public D findById(@PathVariable("uuid") String uuid) {
        return (D) this.getService().findById(UUID.fromString(uuid));
    }


    @PostMapping
    public D save(@RequestBody D dto) {
        return (D) this.getService().save(dto);
    }

    @PutMapping
    public D update(@NonNull @RequestBody D dto) {
        return (D) this.getService().update(dto);
    }

    @DeleteMapping("{uuid}")
    public void delete(@PathVariable("uuid") String uuid) {
        this.getService().delete(UUID.fromString(uuid));
    }
}
