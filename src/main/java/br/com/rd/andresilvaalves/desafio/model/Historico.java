package br.com.rd.andresilvaalves.desafio.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Historico extends RDEntity {

    @ManyToOne
    @JoinColumn(name = "paciente_id", foreignKey = @ForeignKey(name = "FK_paciente_historico"), nullable = false)
    @NotNull(message = "Paciente é Obrigatório")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", foreignKey = @ForeignKey(name = "FK_medico_historico"), nullable = false)
    @NotNull(message = "Médico é Obrigatório")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "exame_id", foreignKey = @ForeignKey(name = "FK_exame_historico"), nullable = false)
    @NotNull(message = "Exame é Obrigatório")
    private Exame exame;

}
