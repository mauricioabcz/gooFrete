package com.gooFrete.Controller;

import com.gooFrete.Model.ReportModule;
import java.util.List;

public class ReportController {

    private ReportModule report;
    
    public ReportController() {
        this.report = new ReportModule();
    }
    
    public boolean carrierReportGenerator(){
        try {
         //Pega listagem
         CarrierController controller = new CarrierController();
         List listaTransportadores = controller.carrierQueryAll();
         //Gera relatório
         report.carrierReport(listaTransportadores);
         return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean travelReportGenerator(){
        try {
         //Pega listagem
         ViagemController controller = new ViagemController();
         List listaViagens = controller.travelQueryAll();
         //Gera relatório
         report.travelReport(listaViagens);
         return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean equipmentReportGenerator(){
        try {
         //Gera relatório
         report.reportEquipmentQuery();
         return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
