package com.gooFrete.Testes;

import com.fasterxml.jackson.databind.JsonNode;
import com.gooFrete.Model.API;
import com.gooFrete.Model.ApiReturn;
import com.gooFrete.Model.Viagem;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author fmtak
 */
public class apiTeste {
    
    public apiTeste() {
    }
    
    @Test
    public void api() throws IOException{
    Viagem viagem = new Viagem("Fabio", "123123", "caminhao", "amp123", 4, 0, "Curitiba,pr;Lages,sc");
    API api = new API(viagem.getParadas(), viagem.getTipoVeiculo(), viagem.getNumEixos());
    JsonNode retorno = api.integracao();
    
    viagem = ApiReturn.ajeitaRetorno(retorno,viagem);
    System.out.println(viagem.toString());
    
}
    
}
