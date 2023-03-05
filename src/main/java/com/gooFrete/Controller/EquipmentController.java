package com.gooFrete.Controller;

import com.gooFrete.Model.Carrier;
import com.gooFrete.Model.CarrierManager;
import com.gooFrete.Model.Equipment;
import com.gooFrete.Model.EquipmentManager;
import java.util.List;

/**
 *
 * @author mauricio.rodrigues
 */
public class EquipmentController {
    
    private Equipment equipment;
    private List listaVeiculos;
    private List listaCarrierVinculados;
    private EquipmentManager equipmentManager;
    private CarrierManager carrierManager;
    
    public EquipmentController() {
        equipmentManager = new EquipmentManager();
        carrierManager = new CarrierManager();
    }
    
    public List<Equipment> equipmentQueryAll(){
        this.listaVeiculos = equipmentManager.equipmentQueryAll();
        return this.listaVeiculos;
    }
    
    public boolean equipmentPersistence(Equipment veiculo){
        boolean status;
        status = equipmentManager.equipmentInsert(veiculo);
        return status;
    }
    
    public boolean equipmentAtualization(Equipment veiculo, String actualLicensePlate){
        boolean status;
        String situacao = equipmentExiste(actualLicensePlate);
        status = equipmentManager.equipmentUpdate(veiculo, situacao);
        return status;
    }

    public boolean equipmentDelete(String licensePlate){
        boolean status = equipmentManager.equipmentDelete(licensePlate);
        return status;
    }
    
    public Equipment equipmentQueryOneEquipment(String licensePlate){
        this.equipment = equipmentManager.equipmentQueryOneEquipment(licensePlate);
        return this.equipment;
    }
    
    public String equipmentExiste(String actualLicensePlate){
        String situacao = equipmentManager.equipmentExiste(actualLicensePlate);
        return situacao;
    }
    
    public List<Carrier> carrierVinculados(String licensePlate){
        String equipmentId = equipmentManager.equipmentExiste(licensePlate);
        this.listaCarrierVinculados = carrierManager.getLinkedCarrier(equipmentId);
        return this.listaCarrierVinculados;
    }
    
}
