package com.gooFrete.Testes;

import com.gooFrete.Model.DatabaseConfig;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mauricio.rodrigues
 */
public class configTeste {

    @Test
    public void testaObterDadosDoBanco(){
        DatabaseConfig databaseConfig = new DatabaseConfig();
        String teste = databaseConfig.getConnectionString();
        System.out.println(teste);
        Assert.assertEquals(teste, "jdbc:sqlserver://localhost;database=gooFrete;user=sa;password=P@ssw0rd!;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        
    }
    
    @Test
    public void testeCNPJCPF(){
    String texto = "Lorem ipsum 123.456.789-10 dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 12.345.678/0001-90 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

    Pattern padrao = Pattern.compile("\\b(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})\\b");
    Matcher matcher = padrao.matcher(texto);

    ArrayList<String> numeros = new ArrayList<String>();

    while (matcher.find()) {
      numeros.add(matcher.group());
    }

    System.out.println(numeros);
    }
    
}
