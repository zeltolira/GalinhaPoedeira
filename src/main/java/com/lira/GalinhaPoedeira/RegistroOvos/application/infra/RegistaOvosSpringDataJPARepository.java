package com.lira.GalinhaPoedeira.RegistroOvos.application.infra;

import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface RegistaOvosSpringDataJPARepository extends JpaRepository <RegistroOvos, UUID> {
    @Query("select ro from RegistroOvos ro join fetch ro.galinha where ro.dataProducao = :data")
    List<RegistroOvos> findByDataProducao(@Param("data") LocalDate data);
    List<RegistroOvos> findByDataProducaoBetween(LocalDate atDay, LocalDate atEndOfMonth);
}
