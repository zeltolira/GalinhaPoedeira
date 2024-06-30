package com.lira.GalinhaPoedeira.Galinha.application.api;

import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaDetalhadoResponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/v1/galinha")
public interface GalinhaApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    GalinhaResponse postGalinha(@Valid @RequestBody GalinhaRequest galinhaRequest);

    @GetMapping(value = "/{idGalinha}")
    @ResponseStatus(code = HttpStatus.OK)
    GalinhaDetalhadoResponse getGalinhaById(@PathVariable UUID idGalinha);
}
