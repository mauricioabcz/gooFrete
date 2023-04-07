package com.gooFrete.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Converter {
    
    private EquipmentManager equipmentManager;

    public Converter() {
        this.equipmentManager = new EquipmentManager();
    }
    
    public Travel convertViagemInTravel(Viagem viagem){
        String identification = "GF-0001";
        UUID carrierId = UUID.fromString(equipmentManager.getCarrierId(viagem.getTransportadorCNPJCPF()));
        String carrierName = viagem.getNomeTransportador();
        String carrierCNPJCPF = viagem.getTransportadorCNPJCPF();
        UUID equipmentId = UUID.fromString(equipmentManager.equipmentExiste(viagem.getPlaca()));
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        
        Travel travel = new Travel();
        travel.setIdentification(identification);
        travel.setCarrierId(carrierId);
        travel.setCarrierName(carrierName);
        travel.setCarrierCNPJCPF(carrierCNPJCPF);
        travel.setEquipmentId(equipmentId);
        travel.setInsertDate(agora.format(formato));
        
        return travel;
        
    }
    
}
