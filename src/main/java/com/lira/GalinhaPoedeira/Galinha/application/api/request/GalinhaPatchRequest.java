package com.lira.GalinhaPoedeira.Galinha.application.api.request;

import com.lira.GalinhaPoedeira.Galinha.domain.StatusGalinha;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@ToString
@Getter
public class GalinhaPatchRequest {
    @NotNull
    private String nomeGalinha;
    private LocalDate dataNascimento;


}
