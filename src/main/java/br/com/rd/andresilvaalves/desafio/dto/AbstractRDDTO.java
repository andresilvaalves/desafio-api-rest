package br.com.rd.andresilvaalves.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(of = {"uuid"})
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class AbstractRDDTO implements IRDDTO{

    private UUID uuid;

    private LocalDateTime dataCriacao;
}
