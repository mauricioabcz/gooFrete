package com.gooFrete.Model;

import com.fasterxml.jackson.databind.JsonNode;

/**
 *
 * @author fmtak
 */
public class ApiReturn {
    
    public static Viagem ajeitaRetorno(JsonNode retorno, Viagem viagem){
        
        String distancia = retorno.get("rotas")
                                .get(0)
                                .get("distancia")
                                .get("texto")
                                .asText();
        
        String duracao = retorno.get("rotas")
                                .get(0)
                                .get("duracao")
                                .get("texto")
                                .asText();
        
        String valorPedagio = retorno.get("rotas")
                                .get(0)
                                .get("valorPedagio")
                                .get("texto")
                                .asText();
        
        viagem.setDistancia(distancia);
        viagem.setDuracao(duracao);
        viagem.setValor(valorPedagio);
        return viagem;
    }
    
    
}
