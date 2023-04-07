package com.gooFrete.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gooFrete.Model.API;
import com.gooFrete.Model.ApiReturn;
import com.gooFrete.Model.Converter;
import com.gooFrete.Model.Travel;
import com.gooFrete.Model.TravelManager;
import com.gooFrete.Model.Viagem;
import java.io.IOException;
import java.util.List;

public class ViagemController {
    
    private TravelManager travelManager;
    private Converter convert;
    private List<Travel> listaViagens;
    
    public ViagemController() {
        this.travelManager = new TravelManager();
        this.convert = new Converter();
    }
    
    public boolean processaViagem(Viagem viagem) throws IOException{
        try {
            //Cria objeto travel
            Travel travel;
            //Cria objeto API 
            API api = new API(viagem.getParadas(), viagem.getTipoVeiculo(),viagem.getNumEixos());
            //Trata retorno da API trasnformando em JsonNode
            JsonNode retorno = api.integracao();
            //Atualiza viagem com informações do JSON retornado pela API
            viagem = ApiReturn.ajeitaRetorno(retorno, viagem);
            //Converte viagem em travel para persistir no banco de dados
            travel = convert.convertViagemInTravel(viagem);
            //Persiste objeto travel no banco de dados
            travelManager.travelInsert(travel);
            //Objeto inserido com sucesso
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean viagemPersistence(Viagem viagem){
        boolean status;
        Travel travel = convert.convertViagemInTravel(viagem);
        status = travelManager.travelInsert(travel);
        return status;
    }
 
     public List<Travel> travelQueryAll(){
        this.listaViagens = travelManager.travelQueryAll();
        return this.listaViagens;
    }
    
     public boolean removerViagem(String identification){
        boolean status;
        status = travelManager.travelDelete(identification);
        return status;
    }
     
}
