package com.gooFrete.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Converter {
    
    private EquipmentManager equipmentManager;
    private TravelManager travelManager;

    public Converter() {
        this.equipmentManager = new EquipmentManager();
        this.travelManager = new TravelManager();
    }
    
    public Travel convertViagemInTravel(Viagem viagem){
        String identification = "GF-" + travelManager.getIdentificationNumber();
        UUID carrierId = UUID.fromString(equipmentManager.getCarrierId(viagem.getNomeTransportador()));
        String carrierName = viagem.getNomeTransportador();
        String carrierCNPJCPF = viagem.getTransportadorCNPJCPF();
        double valor = Double.parseDouble(viagem.getValor());
        double distancia = Double.parseDouble(viagem.getDistancia());
        String duracao = viagem.getDuracao();
        int tipoPagamento = viagem.getTipoPagamento();
        UUID equipmentId = UUID.fromString(equipmentManager.equipmentExiste(viagem.getPlaca()));
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        
        Travel travel = new Travel();
        travel.setIdentification(identification);
        travel.setCarrierId(carrierId);
        travel.setCarrierName(carrierName);
        travel.setCarrierCNPJCPF(carrierCNPJCPF);
        travel.setValor(valor);
        travel.setDistancia(distancia);
        travel.setDuracao(duracao);
        travel.setTipoPagamento(tipoPagamento);
        travel.setEquipmentId(equipmentId);
        travel.setInsertDate(agora.format(formato));
        
        return travel;
        
    }
    
}
