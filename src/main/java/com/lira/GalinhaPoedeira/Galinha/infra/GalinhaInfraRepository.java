package com.lira.GalinhaPoedeira.Galinha.infra;

import com.lira.GalinhaPoedeira.Galinha.application.repository.GalinhaRepository;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class GalinhaInfraRepository implements GalinhaRepository {
    private final GalinhalinhaSpringDataJPARepository galinhaSpringDataJPARepository;

    @Override
    public Galinha saveGalinha(Galinha galinha) {
        log.info("[inicia] GalinhaInfraRepository - saveGalinha");
        if (galinhaSpringDataJPARepository.existsByNomeGalinha(galinha.getNomeGalinha())){
            throw new RuntimeException("Já existe uma Galinha com esse nome!");
        }
        galinhaSpringDataJPARepository.save(galinha);
        log.info("[finaliza] GalinhaInfraRepository - saveGalinha");
        return galinha;
    }

    @Override
    public Galinha getGalinhaiById(UUID idGalinha) {
        log.info("[inicia] GalinhaInfraRepository - getGalinhaiById");
        Galinha galinha = galinhaSpringDataJPARepository.findById(idGalinha)
                        .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Galinha não encontrada! " + idGalinha));
        log.info("[finaliza] GalinhaInfraRepository - getGalinhaiById");
        return galinha;
    }
}
