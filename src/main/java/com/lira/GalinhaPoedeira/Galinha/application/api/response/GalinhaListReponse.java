package com.lira.GalinhaPoedeira.Galinha.application.api.response;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ToString
@Getter
public class GalinhaListReponse {
    private UUID idGalinha;
    private String nomeGalinha;
    private LocalDate dataNascimento;

    public static List<GalinhaListReponse> converte(List<Galinha> galinhas) {
        return galinhas.stream()
                .map(GalinhaListReponse::new)
                .collect(Collectors.toList());
    }

    public GalinhaListReponse(Galinha galinha) {
        this.idGalinha = galinha.getIdGalinha();
        this.nomeGalinha = galinha.getNomeGalinha();
        this.dataNascimento = galinha.getDataNascimento();
    }
}
