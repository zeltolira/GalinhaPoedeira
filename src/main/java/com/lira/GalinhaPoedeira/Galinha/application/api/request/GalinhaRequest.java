package com.lira.GalinhaPoedeira.Galinha.application.api.request;

import com.lira.GalinhaPoedeira.Galinha.domain.StatusGalinha;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Data
public class GalinhaRequest {
    @NotBlank
    private String nomeGalinha;
    private StatusGalinha statusGalinha = StatusGalinha.ATIVA;
    @NotNull
    private LocalDate dataNascimento = LocalDate.now();
}
