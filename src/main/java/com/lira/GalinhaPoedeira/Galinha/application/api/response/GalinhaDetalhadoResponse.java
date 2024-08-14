package com.lira.GalinhaPoedeira.Galinha.application.api.response;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.Galinha.domain.StatusGalinha;
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
    private StatusGalinha statusGalinha = StatusGalinha.ATIVA;

    public GalinhaDetalhadoResponse(Galinha galinha) {
        this.idGalinha = galinha.getIdGalinha();
        this.nomeGalinha = galinha.getNomeGalinha();
        this.dataNascimento = galinha.getDataNascimento();
        this.registroOvos = galinha.getRegistroOvos().stream()
                .map(RegistroOvosResponse::new)
                .collect(Collectors.toList());
        this.producaoGalinha = calcularSomaOvos();
        this.statusGalinha = StatusGalinha.ATIVA;
    }

    private Integer calcularSomaOvos() {
        if (registroOvos != null) {
            return registroOvos.stream()
                    .mapToInt(RegistroOvosResponse::getQuantidade)
                    .sum();
        }
        return 0;
    }
    public static List<GalinhaDetalhadoResponse> converter(List<Galinha> galinhas) {
            return galinhas.stream()
                    .map(GalinhaDetalhadoResponse::new)
                    .collect(Collectors.toList());
    }
}
