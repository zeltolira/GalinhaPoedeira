package com.lira.GalinhaPoedeira.Galinha.application.api.response;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.RegistroOvosResponse;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ToString
@Data
public class GalinhaDetalhadoResponse {
    private UUID idGalinha;
    private String nomeGalinha;
    private LocalDate dataNascimento;
    private List<RegistroOvosResponse> registroOvos;
    private Integer producaoGalinha;

        public GalinhaDetalhadoResponse(Galinha galinha) {
        this.idGalinha = galinha.getIdGalinha();
        this.nomeGalinha = galinha.getNomeGalinha();
        this.dataNascimento = galinha.getDataNascimento();
        this.registroOvos = galinha.getRegistroOvos().stream()
                .map(RegistroOvosResponse::new)
                .collect(Collectors.toList());
        this.producaoGalinha = calcularSomaOvos();
    }
    private Integer calcularSomaOvos() {
            return registroOvos.stream()
                    .mapToInt(RegistroOvosResponse::getQuantidade)
                    .sum();
    }
}
