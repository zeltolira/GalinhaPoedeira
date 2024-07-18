package com.lira.GalinhaPoedeira.RegistroOvos.application.infra;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoMensalResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoPorDataResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.RegistroOvosResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.repository.RegistroOvosRepository;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.YearMonth;
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
    public List<ProducaoPorDataResponse> consultaProducaoPorData(LocalDate data) {
        log.info("[inicia] RegistroOvosInfraRepository - findProducaoByData com data: {}", data);
        List<RegistroOvos> producoes = registaOvosSpringDataJPARepository.findByDataProducao(data);
        log.info("Registros encontrados: {}", producoes.size());
        producoes.forEach(producao -> log.info("Registro encontrado: {}", producao));
        if (producoes.isEmpty()) {
            log.info("[finaliza] RegistroOvosInfraRepository - findProducaoByData");
            return List.of();
        }
        List<ProducaoPorDataResponse> resposta = producoes.stream()
                .collect(Collectors.groupingBy(
                        producao -> producao.getGalinha().getNomeGalinha(),
                        Collectors.toList()
                ))
                .entrySet().stream()
                .map(entry -> {
                           String nomeGalinha = entry.getKey();
                           Galinha galinha = entry.getValue().get(0).getGalinha();
                            log.info("Galinha: {}", nomeGalinha);
                    return new ProducaoPorDataResponse(nomeGalinha, galinha
                    );
                })
                .collect(Collectors.toList());
        log.info("[finaliza] RegistroOvosInfraRepository - findProducaoByData");
        return resposta;
    }

    @Override
    public ProducaoMensalResponse consultaProducaoMensal(LocalDate data) {
        log.info("[inicia] RegistroOvosInfraRepository - consultaProducaoMensal");
        YearMonth mesAno = YearMonth.from(data);
        List<RegistroOvos> producao = registaOvosSpringDataJPARepository.findByDataProducaoBetween(mesAno.atDay(1), mesAno.atEndOfMonth());

        int producaoMensal = producao.stream()
                .mapToInt(RegistroOvos::getQuantidade)
                        .sum();
        log.info("[finaliza] RegistroOvosInfraRepository - consultaProducaoMensal");
        return new ProducaoMensalResponse(producaoMensal);
    }
}
