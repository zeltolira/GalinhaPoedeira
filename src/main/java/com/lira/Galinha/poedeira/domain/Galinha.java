package com.lira.Galinha.poedeira.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @NotBlank
    private String dataNascimento;
}
