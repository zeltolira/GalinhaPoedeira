package com.lira.GalinhaPoedeira.RegistroOvos.application.infra;

import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface RegistaOvosSpringDataJPARepository extends JpaRepository <RegistroOvos, UUID> {
    List<RegistroOvos> findByDataProducao(LocalDate data);
    List<RegistroOvos> findByDataProducaoBetween(LocalDate atDay, LocalDate atEndOfMonth);
}
