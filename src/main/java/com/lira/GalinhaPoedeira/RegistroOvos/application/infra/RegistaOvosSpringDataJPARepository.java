package com.lira.GalinhaPoedeira.RegistroOvos.application.infra;

import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistaOvosSpringDataJPARepository extends JpaRepository <RegistroOvos, UUID> {
}
