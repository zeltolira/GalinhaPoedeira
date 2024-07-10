package com.lira.GalinhaPoedeira.RegistroOvos.application.api.response;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProducaoGalinhaResponse {
    private String nomeGalinha;
    private int somaOvos;

    public ProducaoGalinhaResponse(String nomeGalinha, int somaOvos) {
        this.nomeGalinha = nomeGalinha;
        this.somaOvos = somaOvos;
    }
}