/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.gooFrete.Testes;

import com.gooFrete.Controller.CarrierController;
import com.gooFrete.Model.ReportModule;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author mauricio.rodrigues
 */
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
}
