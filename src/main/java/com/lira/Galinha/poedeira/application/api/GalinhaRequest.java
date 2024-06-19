package com.lira.Galinha.poedeira.application.api;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@ToString
@Data
public class GalinhaRequest {
    private UUID idGalinha;
    private String nomeGalinha;
    private String dataNascimento;
}
