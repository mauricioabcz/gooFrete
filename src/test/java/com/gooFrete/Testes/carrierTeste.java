package com.gooFrete.Testes;

import com.gooFrete.Controller.CarrierController;
import com.gooFrete.Model.Carrier;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mauricio.rodrigues
 */
public class carrierTeste {
    
    @Test
    public void testeCriacaoDeTransportador(){
        CarrierController carrierControl = new CarrierController();

        Carrier transportador = new Carrier("Bino","70441740944","Rua Astrogildo Rodrigues Lima, 161","Jardim das Camelias","Lages","Santa Catarina","Brasil","88517375", "40028922",0);
        System.out.println(transportador.toString());
        
        boolean status = carrierControl.carrierPersistence(transportador);
        Assert.assertEquals(true, status);
        
    }
    
    @Test
    public void testeConsultaListaDeTransportadores(){
        CarrierController carrierControl = new CarrierController();
        
        List<Carrier> listaTransportadores;
        listaTransportadores = carrierControl.carrierQueryAll();
        Assert.assertEquals(5, listaTransportadores.size());
        
    }
    
    @Test
    public void testeRemoverTransportador(){
        CarrierController carrierControl = new CarrierController();
        
        String carrierCNPJCPF = "1234";
        boolean status = carrierControl.carrierDelete(carrierCNPJCPF);
        Assert.assertEquals(true, status);
        
    }
    
    @Test
    public void testePesquisaUmTransportador(){
        CarrierController carrierControl = new CarrierController();
        
        String carrierCNPJCPF = "5879245000177";
        Carrier transportador = carrierControl.carrierQueryOneCarrier(carrierCNPJCPF);
        transportador.toString();
        Assert.assertEquals("5879245000177", transportador.getCarrierCNPJCPF());
        
    }
    
    @Test
    public void testeTransportadorExiste(){
        CarrierController carrierControl = new CarrierController();
        
        String carrierCNPJCPF = "05879245000177";
        String status = carrierControl.carrierExiste(carrierCNPJCPF);
        Assert.assertEquals(status, "DCE84611-0851-4EE3-BA7A-243A27F08570");
        
    }
    
    @Test
    public void testeAtualizacaoDeTransportador(){
        CarrierController carrierControl = new CarrierController();

        Carrier transportador = new Carrier("Bino2","70441740999","Rua Astrogildo Rodrigues Lima, 300","Jardim das Camelias","Lages","Santa Catarina","Brasil","88517375", "40028922",0);
        System.out.println(transportador.toString());
        
        boolean status = carrierControl.carrierPersistence(transportador);
        Assert.assertEquals(true, status);
        
    }
    
}
