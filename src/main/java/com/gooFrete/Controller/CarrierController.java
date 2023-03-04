package com.gooFrete.Controller;

import com.gooFrete.Model.Carrier;
import com.gooFrete.Model.CarrierManager;
import java.util.List;

/**
 *
 * @author mauricio.rodrigues
 */
public class CarrierController {

    private Carrier carrier;
    private List listaTransportadores;
    private CarrierManager carrierManager;
    
    public CarrierController() {
        carrierManager = new CarrierManager();
    }
    
    public boolean carrierPersistence(Carrier transportador){
        boolean status;
        status = carrierManager.carrierInsert(transportador);
        return status;
    }
    
    public boolean carrierAtualization(Carrier transportador, String actualCNPJCPF){
        boolean status;
        String situacao = carrierExiste(actualCNPJCPF);
        status = carrierManager.carrierUpdate(transportador, situacao);
        return status;
    }
    
    public List<Carrier> carrierQueryAll(){
        this.listaTransportadores = carrierManager.carrierQueryAll();
        return this.listaTransportadores;
    }
    
    public boolean carrierDelete(String carrierCNPJCPF){
        boolean status = carrierManager.carrierDelete(carrierCNPJCPF);
        return status;
    }
    
    public Carrier carrierQueryOneCarrier(String carrierCNPJCPF){
        this.carrier = carrierManager.carrierQueryOneCarrier(carrierCNPJCPF);
        return this.carrier;
    }
    
    public String carrierExiste(String carrierCNPJCPF){
        String situacao = carrierManager.carrierExiste(carrierCNPJCPF);
        return situacao;
    }
}
