package com.lira.GalinhaPoedeira.RegistroOvos.application.api.response;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@ToString
@Data
public class RegistroOvosResponse {
//    private UUID id;
    private Galinha galinha;
    private int quantidade;
    private LocalDate dataProducao;

    public RegistroOvosResponse(RegistroOvos registroOvos) {
//        this.id = registroOvos.getId();
        this.galinha = registroOvos.getGalinha();
        this.quantidade = registroOvos.getQuantidade();
        this.dataProducao = registroOvos.getDataProducao();

    }
}
