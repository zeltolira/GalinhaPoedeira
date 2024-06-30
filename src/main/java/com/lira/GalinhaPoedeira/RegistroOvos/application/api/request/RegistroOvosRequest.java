package com.lira.GalinhaPoedeira.RegistroOvos.application.api.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@ToString
@Data
public class RegistroOvosRequest {
    @NotNull
    @Min(1)
    private int quantidade;
    @NotNull
    private LocalDate dataProducao;
}
