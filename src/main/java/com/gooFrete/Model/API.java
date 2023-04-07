package com.gooFrete.Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author fmtak
 */
public class API {
    
    private String apiURL = "https://rotasbrasil.com.br/api/v3";//
    private String token = "fd4f1ea0ca561332ff6147710da65201";//
    private String pontos;
    private String tipoVeiculo;//
    private int numEixos;//
    

    public API(String pontos, String tipoVeiculo, int numEixos) {
        this.pontos = pontos;
        this.tipoVeiculo = tipoVeiculo;
        this.numEixos = numEixos;
        
    }
    
    public JsonNode integracao () throws IOException{
        //String username = "octocat"; // nome de usuário do GitHub que queremos pesquisar
        String url = this.apiURL + "?pontos=" + this.pontos + "&veiculo=" + this.tipoVeiculo + "&eixos=" + this.numEixos + "&token=" + this.token;// url da API
        //String url = "https://rotasbrasil.com.br/api/v3?pontos=Curitiba,pr;88525-600;Florian%C3%B3polis,sc&veiculo=caminhao&eixos=6&token=be0fec9037e09b6f6b987b5991ddbf56";
        testeEncode(url);
        System.out.println("Requested URL: " + url);
        
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.toString());
        return rootNode;
    }
    
    public void testeEncode(String encode){
        String cidade = encode;
        String cidadeEncoded = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
        System.out.println(cidadeEncoded); // Florian%C3%B3polis
    }
}
