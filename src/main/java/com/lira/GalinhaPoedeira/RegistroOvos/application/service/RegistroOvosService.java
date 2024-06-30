package com.lira.GalinhaPoedeira.RegistroOvos.application.service;

import com.lira.GalinhaPoedeira.RegistroOvos.application.api.request.RegistroOvosRequest;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.RegistroOvosResponse;

import java.util.UUID;

public interface RegistroOvosService {
    RegistroOvosResponse registrarOvos(UUID idGalinha, RegistroOvosRequest registroOvosRequest);
}
