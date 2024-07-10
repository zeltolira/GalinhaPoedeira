package com.lira.GalinhaPoedeira.RegistroOvos.application.api.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProducaoPorDataResponse {
    private String nomeGalinha;
    private int quantidade;

    public ProducaoPorDataResponse(String nomeGalinha, int quantidade) {
        this.nomeGalinha = nomeGalinha;
        this.quantidade = quantidade;

    }
}

