package com.lira.Galinha.poedeira.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@ToString
@Data
public class GalinhaResponse {
    private UUID idGalinha;
    private String nomeGalinha;
    private String dataNascimento;
}
