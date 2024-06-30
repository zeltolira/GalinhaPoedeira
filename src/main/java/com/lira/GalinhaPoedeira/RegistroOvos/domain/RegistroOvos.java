package com.lira.GalinhaPoedeira.RegistroOvos.domain;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.request.RegistroOvosRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class RegistroOvos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "galinha_id", nullable = false)
    private Galinha galinha;

    @NotNull
    @Min(1)
    private int quantidade;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataProducao;

    public RegistroOvos(Galinha galinha, RegistroOvosRequest registroOvosRequest) {
        this.galinha = galinha;
        this.quantidade = registroOvosRequest.getQuantidade();
        this.dataProducao = registroOvosRequest.getDataProducao();
    }

}
