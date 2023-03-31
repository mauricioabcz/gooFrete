package com.gooFrete.Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author mauricio.rodrigues
 */
public class DatabaseConfig {
    
    private String connectionString;

    public DatabaseConfig() {
    }
    
    public String getConnectionString(){
        String server, database, user, password;
        
        System.out.println("Diretório atual: " + System.getProperty("user.dir"));
        
        //Netbeans:
        //File arquivo = new File(".\\src\\main\\java\\com\\gooFrete\\Config\\databaseConfig.json");
        //Fat .Jar:
        //File arquivo = new File(".\\classes\\databaseConfig.json");
        //Via pasta raiz:
        File arquivo = new File(".\\Config\\databaseConfig.json");
        
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(arquivo);
            server = rootNode.get("server").asText();
            database = rootNode.get("database").asText();
            user = rootNode.get("user").asText();
            password = rootNode.get("password").asText();
            
            this.connectionString =
                       "jdbc:sqlserver://" + server + ";"
                       + "database=" + database + ";"
                       + "user=" + user + ";"
                       + "password=" + password + ";"
                       + "encrypt=true;"
                       + "trustServerCertificate=true;"
                       + "hostNameInCertificate=*.database.windows.net;"
                       + "loginTimeout=30;";
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connectionString;
    }
    
}
