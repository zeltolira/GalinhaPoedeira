package com.lira.GalinhaPoedeira.RegistroOvos.application.infra;

import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoMensalResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoPorDataResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.repository.RegistroOvosRepository;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.UUID;
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

    @Override
    public RegistroOvos findById(UUID id) {
        return registaOvosSpringDataJPARepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        registaOvosSpringDataJPARepository.deleteById(id);
    }

    @Override
    public List<RegistroOvos> consultaProducaoDiariaPorGalinha(LocalDate data) {
        log.info("[inicia] RegistroOvosInfraRepository - consultaProducaoDiariaPorGalinha");
        List<RegistroOvos> registroOvos = registaOvosSpringDataJPARepository.findByDataProducao(data);
        log.info("[finaliza] RegistroOvosInfraRepository - consultaProducaoDiariaPorGalinha");
        return registroOvos;
    }
}
