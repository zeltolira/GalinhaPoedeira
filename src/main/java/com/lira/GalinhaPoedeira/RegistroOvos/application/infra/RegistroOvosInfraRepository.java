package com.lira.GalinhaPoedeira.RegistroOvos.application.infra;

import com.lira.GalinhaPoedeira.RegistroOvos.application.repository.RegistroOvosRepository;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Repository;

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
}
