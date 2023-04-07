package com.gooFrete.Testes;

import com.gooFrete.Model.EquipmentManager;
import com.gooFrete.Model.Travel;
import com.gooFrete.Model.TravelManager;
import com.gooFrete.Model.TravelStop;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

public class travelTeste {
    
    public travelTeste() {
    }
    
    @Test
    public void travelInsert() {
        EquipmentManager equipmentManager = new EquipmentManager();
        TravelManager travelManager = new TravelManager();
        
        String identification = "GF-" + travelManager.getIdentificationNumber();
        UUID carrierId = UUID.fromString(equipmentManager.getCarrierId("Antonella Alícia Monteiro"));
        System.out.println("uuid: " + carrierId);
        String carrierName = "Antonella Alícia Monteiro";
        String carrierCNPJCPF = "96536087976";
        UUID equipmentId = UUID.fromString((equipmentManager.equipmentExiste("BR-300-950")).toUpperCase());
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        
        String duracao = "4h32min";
        double valor = 25.50;
        double distancia = 300;
        
        Travel travel = new Travel();
        travel.setIdentification(identification);
        travel.setCarrierId(carrierId);
        travel.setCarrierName(carrierName);
        travel.setCarrierCNPJCPF(carrierCNPJCPF);
        travel.setDuracao(duracao);
        travel.setValor(valor);
        travel.setTipoPagamento(1);
        travel.setDistancia(distancia);
        travel.setEquipmentId(equipmentId);
        travel.setInsertDate(agora.format(formato));
        
        System.out.println(travel.toString());
        travelManager.travelInsert(travel);
        
     }
    
    @Test
    public void travelDelete() {
        TravelManager travelManager = new TravelManager();
        travelManager.travelDelete("GF-5");
        
     }
    
    @Test
    public void testaGerarIdentification(){
        TravelManager travelManager = new TravelManager();
        String teste = travelManager.getIdentificationNumber();
        System.out.println("Retorno: " + teste);
        
    }
    
    @Test
    public void testaConsultarTodasAsViagens(){
        TravelManager travelManager = new TravelManager();
        List<Travel> retorno = travelManager.travelQueryAll();
        System.out.println("Tamanho da lista: " + retorno.size());
        
    }
    
}
