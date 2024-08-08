package com.lira.GalinhaPoedeira.RegistroOvos.application.service;

import com.lira.GalinhaPoedeira.RegistroOvos.application.api.request.RegistroOvosRequest;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoMensalResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoPorDataResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.RegistroOvosResponse;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

public interface RegistroOvosService {
    RegistroOvosResponse registrarOvos(UUID idGalinha, RegistroOvosRequest registroOvosRequest);
    List<ProducaoMensalResponse> consultaProducaoMensal(YearMonth data);
    void deleteOvoById(UUID id);
}
