package com.lira.Galinha.poedeira.application.service;

import com.lira.Galinha.poedeira.application.api.request.GalinhaRequest;
import com.lira.Galinha.poedeira.application.api.response.GalinhaResponse;

public interface GalinhaService {
    GalinhaResponse postGalinha(GalinhaRequest galinhaRequest);
}
