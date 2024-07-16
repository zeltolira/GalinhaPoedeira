package com.lira.GalinhaPoedeira.RegistroOvos.application.api.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProducaoMensalResponse {
    private Integer producaoMensal;

    public ProducaoMensalResponse(int producaoMensal) {
        this.producaoMensal = producaoMensal;
    }
}