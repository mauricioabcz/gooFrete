package com.gooFrete.Controller;

import com.gooFrete.Model.Converter;
import com.gooFrete.Model.Travel;
import com.gooFrete.Model.TravelManager;
import com.gooFrete.Model.Viagem;

public class ViagemController {
    
    private TravelManager travelManager;
    private Converter convert;
    
    public ViagemController() {
        this.travelManager = new TravelManager();
        this.convert = new Converter();
    }
    
    public boolean viagemPersistence(Viagem viagem){
        boolean status;
        Travel travel = convert.convertViagemInTravel(viagem);
        status = travelManager.travelInsert(travel);
        return status;
    }
    
}
