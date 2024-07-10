package com.lira.GalinhaPoedeira.RegistroOvos.application.repository;

import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoPorDataResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;

import java.time.LocalDate;
import java.util.List;

public interface RegistroOvosRepository {
    RegistroOvos salvaOvos(RegistroOvos registroOvos);
    List<ProducaoPorDataResponse> findProducaoByData(LocalDate data);
}
