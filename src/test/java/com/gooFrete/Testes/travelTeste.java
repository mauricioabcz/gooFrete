package com.gooFrete.Testes;

import com.gooFrete.Model.EquipmentManager;
import com.gooFrete.Model.Travel;
import com.gooFrete.Model.TravelManager;
import com.gooFrete.Model.TravelStop;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.junit.Test;

public class travelTeste {
    
    public travelTeste() {
    }
    
    @Test
    public void travelInsert() {
     
        EquipmentManager equipmentManager = new EquipmentManager();
         
        String identification = "GF-0001";
        UUID carrierId = UUID.fromString(equipmentManager.getCarrierId("Antonella Alícia Monteiro"));
        System.out.println("uuid: " + carrierId);
        String carrierName = "Antonella Alícia Monteiro";
        String carrierCNPJCPF = "96536087976";
        UUID equipmentId = UUID.fromString((equipmentManager.equipmentExiste("BR-300-950")).toUpperCase());
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        
        Travel travel = new Travel();
        travel.setIdentification(identification);
        travel.setCarrierId(carrierId);
        travel.setCarrierName(carrierName);
        travel.setCarrierCNPJCPF(carrierCNPJCPF);
        travel.setEquipmentId(equipmentId);
        travel.setInsertDate(agora.format(formato));
        
        TravelStop parada = new TravelStop();
        parada.setPraca("Lages");
        parada.setValor(25.50);
        parada.setInsertDate(agora.format(formato));
        
        
        
        TravelManager travelManager = new TravelManager();
        System.out.println(travel.toString());
        travelManager.travelInsert(travel);
        
     }
}
