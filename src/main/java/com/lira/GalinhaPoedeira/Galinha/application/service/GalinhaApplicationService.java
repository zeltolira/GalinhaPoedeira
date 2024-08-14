package com.lira.GalinhaPoedeira.Galinha.application.service;

import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaPatchRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.request.GalinhaRequest;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaDetalhadoResponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaListReponse;
import com.lira.GalinhaPoedeira.Galinha.application.api.response.GalinhaResponse;
import com.lira.GalinhaPoedeira.Galinha.application.repository.GalinhaRepository;
import com.lira.GalinhaPoedeira.Galinha.domain.Galinha;
import com.lira.GalinhaPoedeira.RegistroOvos.application.repository.RegistroOvosRepository;
import com.lira.GalinhaPoedeira.RegistroOvos.domain.RegistroOvos;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class GalinhaApplicationService implements GalinhaService {
    private final GalinhaRepository galinhaRepository;
    private final RegistroOvosRepository registroOvoRepository;

    @Override
    public GalinhaResponse postGalinha(GalinhaRequest galinhaRequest) {
        log.info("[inicia] GalinhaApplicationService - postGalinha");
        Galinha galinha = galinhaRepository.saveGalinha(new Galinha(galinhaRequest));
        log.info("[finaliza] GalinhaApplicationService - postGalinha");
        return new GalinhaResponse(galinha, "Galinha cadastrada com Sucesso!!!");
    }

    @Override
    public GalinhaDetalhadoResponse getGalinhaById(UUID idGalinha) {
        log.info("[inicia] GalinhaApplicationService - getGalinhaById");
        Galinha galinha = galinhaRepository.getGalinhaById(idGalinha);
        log.info("[finaliza] GalinhaApplicationService - getGalinhaById");
        return new GalinhaDetalhadoResponse(galinha);
    }

    @Override
    public List<GalinhaListReponse> getAllGalinhas() {
        log.info("[inicia] GalinhaApplicationService - getAllGalinhas");
        List<Galinha> galinhas = galinhaRepository.getAllGalinhas();
        log.info("[finaliza] GalinhaApplicationService - getAllGalinhas");
        return GalinhaListReponse.converte(galinhas);
    }

    @Override
    public void patchGalinhaById(UUID idGalinha, GalinhaPatchRequest galinhaPatchRequest) {
        log.info("[inicia] GalinhaApplicationService - patchGalinhaById");
        Galinha galinha = galinhaRepository.getGalinhaById(idGalinha);
        galinha.patchGalinha(galinhaPatchRequest);
        galinhaRepository.saveGalinha(galinha);
        log.info("[finaliza] GalinhaApplicationService - patchGalinhaById");

    }

    @Override
    public void deletaGalinha(UUID idGalinha) {
        log.info("[inicia] GalinhaApplicationService - deletaGalinha");
        Galinha galinha = galinhaRepository.getGalinhaById(idGalinha);
        galinhaRepository.deletaGalinha(galinha);
        log.info("[finaliza] GalinhaApplicationService - deletaGalinha");

    }


    @Override
    public List<GalinhaDetalhadoResponse> consultaProducaoDiariaPorGalinha(LocalDate data) {
        log.info("[inicia] GalinhaApplicationService - consultaProducaoDiariaPorGalinha");

        // Consulta todos os registros de ovos para a data especificada
        List<RegistroOvos> listRegistroOvos = registroOvoRepository.consultaProducaoDiariaPorGalinha(data);

        // Agrupa os registros de ovos por galinha
        Map<UUID, Galinha> galinhasMap = new HashMap<>();
        for (RegistroOvos registro : listRegistroOvos) {
            Galinha galinha = registro.getGalinha();
            galinhasMap.computeIfAbsent(galinha.getIdGalinha(), id -> new Galinha(galinha))
                    .getRegistroOvos().add(registro);
        }

        // Converte o mapa de galinhas para a lista de respostas detalhadas
        List<GalinhaDetalhadoResponse> galinhaDetalhadoResponses = galinhasMap.values().stream()
                .map(GalinhaDetalhadoResponse::new)
                .collect(Collectors.toList());

        log.info("[finaliza] GalinhaApplicationService - consultaProducaoDiariaPorGalinha");
        return galinhaDetalhadoResponses;
    }

    @Override
    public void mudaStatusParaInativa(UUID idGalinha) {
        log.info("[inicia] GalinhaApplicationService - mudaStatusParaInativa");
        Galinha galinha = galinhaRepository.getGalinhaById(idGalinha);
        galinha.mudaStatusParaInativa();
        galinhaRepository.saveGalinha(galinha);
        log.info("[finaliza] GalinhaApplicationService - mudaStatusParaInativa");
        }
    @Override
    public void mudaStatusParaAtiva(UUID idGalinha) {
        log.info("[inicia] GalinhaApplicationService - mudaStatusParaAtiva");
        Galinha galinha = galinhaRepository.getGalinhaById(idGalinha);
        galinha.mudaStatusParaAtiva();
        galinhaRepository.saveGalinha(galinha);
        log.info("[finaliza] GalinhaApplicationService - mudaStatusParaAtiva");
        }
}

//    public List<GalinhaDetalhadoResponse> consultaProducaoDiariaPorGalinha(LocalDate data) {
//        log.info("[inicia] GalinhaApplicationService - consultaProducaoDiariaPorGalinha");
//        List<RegistroOvos> listRegistroOvos = registroOvoRepository.consultaProducaoDiariaPorGalinha(data);
//        log.info("[teste] GalinhaApplicationService - consultaProducaoDiariaPorGalinha");
//        Map<UUID, Galinha> galinhasMap = new HashMap<>();
//        for (RegistroOvos registroOvos : listRegistroOvos){
//            Galinha galinha = registroOvos.getGalinha();
//            if (!galinhasMap.containsKey(galinha.getIdGalinha())){
//                Galinha novaGalinha = new Galinha(galinha);
//                galinhasMap.put(novaGalinha.getIdGalinha(), novaGalinha);
//            }
//            galinhasMap.get(galinha.getIdGalinha()).getRegistroOvos().add(registroOvos);
//        }
//        List<Galinha> galinhas = new ArrayList<>(galinhasMap.values());
//        List<GalinhaDetalhadoResponse> galinhaDetalhadoResponse = GalinhaDetalhadoResponse.converter(galinhas);
//        log.info("[finaliza] GalinhaApplicationService - consultaProducaoDiariaPorGalinha");
//        return galinhaDetalhadoResponse;
//    }

