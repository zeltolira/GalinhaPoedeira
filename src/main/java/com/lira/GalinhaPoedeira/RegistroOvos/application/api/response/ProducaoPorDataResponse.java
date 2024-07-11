package com.lira.GalinhaPoedeira.RegistroOvos.application.api.response;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
public class ProducaoPorDataResponse {
    private String nomeGalinha;
    private int quantidade;
    private Galinha galinha;
    private List<RegistroOvosResponse> registroOvos;
    private Integer producaoDiaria;
    public ProducaoPorDataResponse(String nomeGalinha, int quantidade) {
        this.nomeGalinha = nomeGalinha;
        this.quantidade = quantidade;
        this.registroOvos = galinha.getRegistroOvos().stream()
                .map(RegistroOvosResponse::new)
                .collect(Collectors.toList());
        this.producaoDiaria = calcularSomaOvos();
    }

    private Integer calcularSomaOvos() {
        return registroOvos.stream()
                .mapToInt(RegistroOvosResponse::getQuantidade)
                .sum();
    }
}

