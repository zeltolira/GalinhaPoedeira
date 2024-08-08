package com.lira.GalinhaPoedeira.RegistroOvos.application.repository;

import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoMensalResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoPorDataResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

public interface RegistroOvosRepository {
    RegistroOvos salvaOvos(RegistroOvos registroOvos);
    ProducaoMensalResponse consultaProducaoMensal(LocalDate atDay);
    RegistroOvos findById(UUID id);
    void deleteById(UUID id);
    List<RegistroOvos> consultaProducaoDiariaPorGalinha(LocalDate data);
}
