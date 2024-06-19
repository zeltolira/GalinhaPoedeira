package com.lira.Galinha.poedeira.domain;

import com.lira.Galinha.poedeira.application.api.request.GalinhaRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Entity
@Data
@NoArgsConstructor
public class Galinha {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idGalinha;
    @NotBlank
    private String nomeGalinha;
    @NotBlank
    private String dataNascimento;
    private LocalDateTime dataHoraCriacaoGalinha;
    private LocalDateTime dataHoraUltimaAlteracaoGalinha;

    public Galinha(GalinhaRequest galinhaRequest) {
        this.nomeGalinha = galinhaRequest.getNomeGalinha();
        this.dataNascimento = galinhaRequest.getDataNascimento();
        this.dataHoraCriacaoGalinha = LocalDateTime.now();

    }
}
