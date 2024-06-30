package com.lira.GalinhaPoedeira.Galinha.application.api.response;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;
@ToString
@Data
public class GalinhaDetalhadoResponse {
    private UUID idGalinha;
    private String nomeGalinha;
    private LocalDate dataNascimento;

    public GalinhaDetalhadoResponse(Galinha galinha) {
        this.idGalinha = galinha.getIdGalinha();
        this.nomeGalinha = galinha.getNomeGalinha();
        this.dataNascimento = galinha.getDataNascimento();

    }
}
