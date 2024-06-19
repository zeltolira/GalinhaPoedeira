package com.lira.Galinha.poedeira.infra;

import com.lira.Galinha.poedeira.application.repository.GalinhaRepository;
import com.lira.Galinha.poedeira.domain.Galinha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class GalinhaInfraRepository implements GalinhaRepository {
    private final GalinhalinhaSpingDataJPARepository galinhaSpingDataJPARepository;

    @Override
    public Galinha saveGalinha(Galinha galinha) {
        log.info("[inicia] GalinhaInfraRepository - saveGalinha");
        if (galinhaSpingDataJPARepository.existsByNomeGalinha(galinha.getNomeGalinha())){
            throw new RuntimeException("Já existe uma Galinha com esse nome!");
        }
        galinhaSpingDataJPARepository.save(galinha);
        log.info("[finaliza] GalinhaInfraRepository - saveGalinha");
        return galinha;
    }
}
