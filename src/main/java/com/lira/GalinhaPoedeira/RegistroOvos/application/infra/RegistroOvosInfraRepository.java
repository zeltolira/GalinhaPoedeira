package com.lira.GalinhaPoedeira.RegistroOvos.application.infra;

import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoPorDataResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.repository.RegistroOvosRepository;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Log4j2
@RequiredArgsConstructor
public class RegistroOvosInfraRepository implements RegistroOvosRepository {
    private final RegistaOvosSpringDataJPARepository registaOvosSpringDataJPARepository;

    @Override
    public RegistroOvos salvaOvos(RegistroOvos registroOvos) {
        log.info("[inicia] RegistroOvosInfraRepository - saveOvos");
        registaOvosSpringDataJPARepository.save(registroOvos);
        log.info("[finaliza] RegistroOvosInfraRepository - saveOvos");
        return registroOvos;
    }
    @Override
        public List<ProducaoPorDataResponse> findProducaoByData(LocalDate data) {
            log.info("[inicia] RegistroOvosInfraRepository - findProducaoByData");
            List<RegistroOvos> producoes = registaOvosSpringDataJPARepository.findByDataProducao(data);
            if (producoes.isEmpty()){
                log.info("[finaliza] RegistroOvosInfraRepository - findProducaoByData");
                return List.of();
            }
            List<ProducaoPorDataResponse> resposta = producoes.stream()
                    .collect(Collectors.groupingBy(
                            producao -> producao.getGalinha().getNomeGalinha(),
                            Collectors.summingInt(RegistroOvos::getQuantidade)
                    ))
                    .entrySet().stream()
                    .map(entry -> new ProducaoPorDataResponse(entry.getKey(), entry.getValue()))
                    .collect(Collectors.toList());
            log.info("[finaliza] RegistroOvosInfraRepository - findProducaoByData");
            return resposta;
    }
}