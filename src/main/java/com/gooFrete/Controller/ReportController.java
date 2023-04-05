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
    
}
