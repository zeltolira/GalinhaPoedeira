package com.lira.GalinhaPoedeira.RegistroOvos.application.api;

import com.lira.GalinhaPoedeira.RegistroOvos.application.api.request.RegistroOvosRequest;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoMensalResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.ProducaoPorDataResponse;
import com.lira.GalinhaPoedeira.RegistroOvos.application.api.response.RegistroOvosResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/v1/registro")
public interface RegistraOvosApi {

    @PostMapping("/{idGalinha}")
    @ResponseStatus(code = HttpStatus.CREATED)
    RegistroOvosResponse resgistraOvos(@PathVariable UUID idGalinha, @Valid @RequestBody RegistroOvosRequest registroOvosRequest);

    @GetMapping("/producao-mensal")
    @ResponseStatus(code = HttpStatus.OK)
    List<ProducaoMensalResponse> consultaProducaoMensal(@RequestParam("data") YearMonth data);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteOvoById(@PathVariable UUID id);
}
