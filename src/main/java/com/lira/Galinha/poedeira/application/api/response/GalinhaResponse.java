package com.lira.Galinha.poedeira.application.api.response;

import com.lira.Galinha.poedeira.domain.Galinha;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Data
public class GalinhaResponse {
    private UUID idGalinha;
    private String nomeGalinha;
    private String dataNascimento;

    public GalinhaResponse(Galinha galinha) {
        this.idGalinha = galinha.getIdGalinha();
        this.nomeGalinha = galinha.getNomeGalinha();
        this.dataNascimento = galinha.getDataNascimento();

    }
}
