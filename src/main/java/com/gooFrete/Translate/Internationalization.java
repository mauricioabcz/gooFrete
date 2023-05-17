package com.gooFrete.Translate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio.rodrigues
 */
public class Internationalization {
    
    public ResourceBundle internacionaliza(String idioma, String pais){
        ResourceBundle traducoes;
        String nomeArquivo = "./languages/MessagesBundle_"+idioma+"_"+pais+".properties";
        InputStream newInputStream;
        try {
            newInputStream = Files.newInputStream(Paths.get(nomeArquivo));
            traducoes = new PropertyResourceBundle(newInputStream);
            return traducoes;
        } catch (IOException ex) {
            Logger.getLogger(Internationalization.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
