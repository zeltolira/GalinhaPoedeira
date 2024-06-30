package com.lira.GalinhaPoedeira.Galinha.application.api.response;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@ToString
@Data
public class GalinhaResponse {
    private UUID idGalinha;
    private String nomeGalinha;
    private LocalDate dataNascimento;
    private String mensagem;

    public GalinhaResponse(Galinha galinha) {
        this.idGalinha = galinha.getIdGalinha();
        this.nomeGalinha = galinha.getNomeGalinha();
        this.dataNascimento = galinha.getDataNascimento();
        this.mensagem = galinha.getMensagem();

    }
}
