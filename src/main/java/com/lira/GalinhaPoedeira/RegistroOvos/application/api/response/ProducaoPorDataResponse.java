package com.lira.GalinhaPoedeira.RegistroOvos.application.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import lombok.Data;
import lombok.ToString;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
public class ProducaoPorDataResponse {
    private String nomeGalinha;
    private int quantidade;
    @JsonIgnore
    private Galinha galinha;
    private List<RegistroOvosResponse> registroOvos;
    private Integer producaoDiaria;
    private Integer producaoMensal;
    public ProducaoPorDataResponse(String nomeGalinha, int quantidade, Galinha galinha) {
        this.galinha = galinha;
        this.nomeGalinha = nomeGalinha;
        this.quantidade = quantidade;
        this.registroOvos = galinha.getRegistroOvos().stream()
                .map(RegistroOvosResponse::new)
                .collect(Collectors.toList());
        this.producaoDiaria = calcularSomaOvosDiaria();
        this.producaoMensal = calcularSomaOvosMensal();
    }

    private Integer calcularSomaOvosDiaria() {
        if (registroOvos != null) {
            return registroOvos.stream()
                    .mapToInt(RegistroOvosResponse::getQuantidade)
                    .sum();
        }
        return 0;
    }
    private Integer calcularSomaOvosMensal() {
        if (registroOvos != null) {
            return registroOvos.stream()
                    .filter(registro -> YearMonth.from(registro.getDataProducao()).equals(YearMonth.now()))
                    .mapToInt(RegistroOvosResponse::getQuantidade)
                    .sum();
        }
        return 0;
    }
}