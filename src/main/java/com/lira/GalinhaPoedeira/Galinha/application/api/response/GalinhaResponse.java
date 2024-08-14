package com.lira.GalinhaPoedeira.Galinha.application.api.response;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.Galinha.domain.StatusGalinha;
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
    private StatusGalinha statusGalinha;
    private String mensagem;

    public GalinhaResponse(Galinha galinha, String mensagem) {
        this.idGalinha = galinha.getIdGalinha();
        this.nomeGalinha = galinha.getNomeGalinha();
        this.dataNascimento = galinha.getDataNascimento();
        this.mensagem = mensagem;
        this.statusGalinha = galinha.getStatusGalinha();
    }
}
