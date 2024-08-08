package com.lira.GalinhaPoedeira.Galinha.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaPatchRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@ToString
@Data
@NoArgsConstructor
public class Galinha {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idGalinha;
    @NotBlank
    private String nomeGalinha;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    private LocalDateTime dataHoraCriacaoGalinha;
    private LocalDateTime dataHoraUltimaAlteracaoGalinha;

    @OneToMany(mappedBy = "galinha", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RegistroOvos> registroOvos;

    public Galinha(Galinha galinha) {
        this.idGalinha = galinha.getIdGalinha();
        this.nomeGalinha = galinha.getNomeGalinha();
        this.dataNascimento = galinha.getDataNascimento();
        this.dataHoraCriacaoGalinha = galinha.getDataHoraCriacaoGalinha();
        this.dataHoraUltimaAlteracaoGalinha = galinha.getDataHoraUltimaAlteracaoGalinha();
        this.registroOvos = new ArrayList<>();
    }

    public Galinha(GalinhaRequest galinhaRequest) {
        this.nomeGalinha = galinhaRequest.getNomeGalinha();
        this.dataNascimento = galinhaRequest.getDataNascimento();
        this.dataHoraCriacaoGalinha = LocalDateTime.now();

    }

    public void patchGalinha(GalinhaPatchRequest galinhaPatchRequest) {
        this.nomeGalinha = galinhaPatchRequest.getNomeGalinha();
        this.dataNascimento = galinhaPatchRequest.getDataNascimento();
    }

}
