package com.lira.Galinha.poedeira.application.api.request;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@ToString
@Data
public class GalinhaRequest {
    private String nomeGalinha;
    private String dataNascimento;
}
