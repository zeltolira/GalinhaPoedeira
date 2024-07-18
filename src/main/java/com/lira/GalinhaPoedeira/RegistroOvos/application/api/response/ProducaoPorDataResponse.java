package com.lira.GalinhaPoedeira.RegistroOvos.application.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
public class ProducaoPorDataResponse {
    private String nomeGalinha;
    @JsonIgnore
    private Galinha galinha;
    private List<RegistroOvosResponse> registroOvos;
    private Integer producaoDiaria;
    public ProducaoPorDataResponse(String nomeGalinha, Galinha galinha) {
        this.galinha = galinha;
        this.nomeGalinha = nomeGalinha;
        this.registroOvos = galinha.getRegistroOvos().stream()
                .map(RegistroOvosResponse::new)
                .collect(Collectors.toList());
        this.producaoDiaria = calcularSomaOvosDiaria();
    }

    private Integer calcularSomaOvosDiaria() {
        if (registroOvos != null) {
            return registroOvos.stream()
                    .mapToInt(RegistroOvosResponse::getQuantidade)
                    .sum();
        }
        return 0;
    }
}