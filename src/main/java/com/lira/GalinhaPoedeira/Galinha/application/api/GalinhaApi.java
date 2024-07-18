package com.lira.GalinhaPoedeira.Galinha.application.api;

import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaPatchRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaDetalhadoResponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaListReponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<GalinhaListReponse> getAllGalinhas();

    @PatchMapping(value = "/{idGalinha}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchGalinhaById(@PathVariable UUID idGalinha, @Valid @RequestBody GalinhaPatchRequest galinhaPatchRequest);

}
