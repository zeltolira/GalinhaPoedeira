package com.lira.Galinha.poedeira.application.api;

import com.lira.Galinha.poedeira.application.api.request.GalinhaRequest;
import com.lira.Galinha.poedeira.application.api.response.GalinhaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/v1/galinha")
public interface GalinhaApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    GalinhaResponse postGalinha(@Valid @RequestBody GalinhaRequest galinhaRequest);
}
