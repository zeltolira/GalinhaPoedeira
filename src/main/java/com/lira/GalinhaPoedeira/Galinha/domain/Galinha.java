package com.lira.GalinhaPoedeira.Galinha.domain;

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
import java.util.List;
import java.util.UUID;

@ToString
@Entity
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

    @OneToMany(mappedBy = "galinha", fetch = FetchType.EAGER)
    private List<RegistroOvos> registroOvos;

    public Galinha(GalinhaRequest galinhaRequest) {
        this.nomeGalinha = galinhaRequest.getNomeGalinha();
        this.dataNascimento = galinhaRequest.getDataNascimento();
        this.dataHoraCriacaoGalinha = LocalDateTime.now();

    }

}
