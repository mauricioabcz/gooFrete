package com.gooFrete.Testes;

import com.gooFrete.Controller.CarrierController;
import com.gooFrete.Controller.ReportController;
import com.gooFrete.Model.ReportModule;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

public class reportTeste {
    
    public reportTeste() {
    }
    
     @Test
     public void testeCarrierReport() throws IOException {
         //Pega listagem
         CarrierController controller = new CarrierController();
         List listaTransportadores = controller.carrierQueryAll();
         //Gera relatório
         ReportModule relatorios = new ReportModule();
         relatorios.carrierReport(listaTransportadores);
     }
     
     @Test
     public void testeTravelReport() throws IOException {
         //Gera relatório
         ReportController relatorios = new ReportController();
         boolean teste = relatorios.travelReportGenerator();
         System.out.println(teste);
     }
     
     @Test
     public void testeEquipmentReport(){
        //Gera relatório
         ReportController relatorios = new ReportController();
         boolean teste = relatorios.equipmentReportGenerator();
         System.out.println(teste);
         
     }
     
}
