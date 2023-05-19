package com.gooFrete.Model;

import com.gooFrete.Controller.CarrierController;
import com.gooFrete.View.Janela;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.Session;

public class ReportModule {

    private String destinoArquivo;
    private String connectionString;
    private float FONT_SIZE_TITLE = 24f;
    private float FONT_SIZE_SUBTITLE = 18f;
    
    public ReportModule() {
        
    }
    
    private String getGLog(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return currentDateTime.format(formatter);
    }
        
    public void carrierReport(List<Carrier> listaTransportadores) throws IOException{
        PdfWriter writer = null;
        this.destinoArquivo = salvaRelatorio(Janela.traducao.getString("rt_ReportTransportadores"));
        //this.destinoArquivo = "./teste.pdf";
        try {
            PdfFont titleFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont subtitleFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        
            writer = new PdfWriter(this.destinoArquivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document documento = new Document(pdf);
            
            // Definindo a orientação da página como paisagem
            PageSize pageSize = PageSize.A3.rotate();
            Rectangle pageMargins = new Rectangle(50, 50, 50, 50);
            pdf.setDefaultPageSize(pageSize);
            //documento.setMargins(pageMargins.getLeft(), pageMargins.getRight(), pageMargins.getTop(), pageMargins.getBottom());

            // Title
            Text titleText = new Text(Janela.traducao.getString("rt_ReportTransportadores"))
                    .setFont(titleFont)
                    .setFontSize(FONT_SIZE_TITLE);
            documento.add(new Paragraph(titleText).setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Subtitle
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDate = LocalDateTime.now().format(formatter);
            Text subtitleText = new Text(Janela.traducao.getString("rt_DataGeracao") + " " + formattedDate)
                    .setFont(subtitleFont)
                    .setFontSize(FONT_SIZE_SUBTITLE);
            documento.add(new Paragraph(subtitleText).setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Insere Selo Bino de Qualidade
            //criando objeto imagem para adicionar no relatorio
            ImageData data = ImageDataFactory.create("./images/seloBino.jpg");
            com.itextpdf.layout.element.Image img = new com.itextpdf.layout.element.Image(data);
            // Definindo a posição da imagem no canto superior direito da folha A3
            float scale = 0.95f; // reduzir para 95% do tamanho original
            float newWidth = img.getImageScaledWidth() * scale;
            float newHeight = img.getImageScaledHeight() * scale;
            float x = pageSize.getWidth() - newWidth;
            float y = pageSize.getHeight() - newHeight;
            img.scaleToFit(newWidth, newHeight).setFixedPosition(x, y);
            documento.add(img);
            
            // criacao da tabela
            float [] pointColumnWidths = {200f, 150f, 400f, 200f, 200f, 150f, 100f, 100f, 150f, 60f}; //10 colunas com a largura variavel de cada
            Table tabela = new Table(pointColumnWidths);
            tabela.setAutoLayout();
            
            //a primeira linha sera o cabecalho (celula1 e 2)
            Cell celula1 = new Cell();
            celula1.add(new Paragraph(Janela.traducao.getString("rt_Transportador")));
            celula1.setTextAlignment(TextAlignment.CENTER);
            celula1.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula1);
            
            Cell celula2 = new Cell();
            celula2.add(new Paragraph(Janela.traducao.getString("rt_CPFCNPJ")));
            celula2.setTextAlignment(TextAlignment.CENTER);
            celula2.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula2);
            
            Cell celula3 = new Cell();
            celula3.add(new Paragraph(Janela.traducao.getString("rt_Endereco")));
            celula3.setTextAlignment(TextAlignment.CENTER);
            celula3.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula3);
            
            Cell celula4 = new Cell();
            celula4.add(new Paragraph(Janela.traducao.getString("rt_Bairro")));
            celula4.setTextAlignment(TextAlignment.CENTER);
            celula4.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula4);
            
            Cell celula5 = new Cell();
            celula5.add(new Paragraph(Janela.traducao.getString("rt_Cidade")));
            celula5.setTextAlignment(TextAlignment.CENTER);
            celula5.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula5);
            
            Cell celula6 = new Cell();
            celula6.add(new Paragraph(Janela.traducao.getString("rt_Estado")));
            celula6.setTextAlignment(TextAlignment.CENTER);
            celula6.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula6);
            
            Cell celula7 = new Cell();
            celula7.add(new Paragraph(Janela.traducao.getString("rt_Pais")));
            celula7.setTextAlignment(TextAlignment.CENTER);
            celula7.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula7);
            
            Cell celula8 = new Cell();
            celula8.add(new Paragraph(Janela.traducao.getString("rt_CEP")));
            celula8.setTextAlignment(TextAlignment.CENTER);
            celula8.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula8);
            
            Cell celula9 = new Cell();
            celula9.add(new Paragraph(Janela.traducao.getString("rt_Telefone")));
            celula9.setTextAlignment(TextAlignment.CENTER);
            celula9.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula9);
            
            Cell celula10 = new Cell();
            celula10.add(new Paragraph(Janela.traducao.getString("rt_Tipo")));
            celula10.setTextAlignment(TextAlignment.CENTER);
            celula10.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula10);
            
            //populando linhas da tabela
            for(int i = 0; i < listaTransportadores.size(); i++){
                tabela.addCell(new Cell().add(new Paragraph(listaTransportadores.get(i).getCarrierName())));
                tabela.addCell(new Cell().add(new Paragraph(verificaCPNPJCPF(listaTransportadores.get(i).getCarrierCNPJCPF()))));
                tabela.addCell(new Cell().add(new Paragraph(listaTransportadores.get(i).getAddress())));
                tabela.addCell(new Cell().add(new Paragraph(listaTransportadores.get(i).getDistrict())));
                tabela.addCell(new Cell().add(new Paragraph(listaTransportadores.get(i).getCity())));
                tabela.addCell(new Cell().add(new Paragraph(listaTransportadores.get(i).getState())));
                tabela.addCell(new Cell().add(new Paragraph(listaTransportadores.get(i).getCountry())));
                tabela.addCell(new Cell().add(new Paragraph(formatCEP(listaTransportadores.get(i).getZipcode()))));
                tabela.addCell(new Cell().add(new Paragraph(formatPhoneNumber(listaTransportadores.get(i).getTelefone()))));
                tabela.addCell(new Cell().add(new Paragraph(insereTipo(listaTransportadores.get(i).getCarrierType()))).setTextAlignment(TextAlignment.CENTER));
            }
          
            //adiciona tabela no documento e gera PDF:
            documento.add(tabela);
            documento.close();

        } catch (FileNotFoundException | MalformedURLException ex) {
            Logger.getLogger(ReportModule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(ReportModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public void travelReport(List<Travel> listaViagens) throws IOException, ParseException{
        PdfWriter writer = null;
        this.destinoArquivo = salvaRelatorio(Janela.traducao.getString("rt_ReportViagens"));
        //this.destinoArquivo = "./teste2.pdf";
        try {
            PdfFont titleFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont subtitleFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        
            writer = new PdfWriter(this.destinoArquivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document documento = new Document(pdf);
            
            // Definindo a orientação da página como paisagem
            PageSize pageSize = PageSize.A3.rotate();
            Rectangle pageMargins = new Rectangle(50, 50, 50, 50);
            pdf.setDefaultPageSize(pageSize);
            //documento.setMargins(pageMargins.getLeft(), pageMargins.getRight(), pageMargins.getTop(), pageMargins.getBottom());

            // Title
            Text titleText = new Text(Janela.traducao.getString("rt_ReportViagens"))
                    .setFont(titleFont)
                    .setFontSize(FONT_SIZE_TITLE);
            documento.add(new Paragraph(titleText).setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Subtitle
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDate = LocalDateTime.now().format(formatter);
            Text subtitleText = new Text(Janela.traducao.getString("rt_DataGeracao") + " " + formattedDate)
                    .setFont(subtitleFont)
                    .setFontSize(FONT_SIZE_SUBTITLE);
            documento.add(new Paragraph(subtitleText).setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Insere Selo Bino de Qualidade
            //criando objeto imagem para adicionar no relatorio
            ImageData data = ImageDataFactory.create("./images/seloBino.jpg");
            com.itextpdf.layout.element.Image img = new com.itextpdf.layout.element.Image(data);
            // Definindo a posição da imagem no canto superior direito da folha A3
            float scale = 0.95f; // reduzir para 95% do tamanho original
            float newWidth = img.getImageScaledWidth() * scale;
            float newHeight = img.getImageScaledHeight() * scale;
            float x = pageSize.getWidth() - newWidth;
            float y = pageSize.getHeight() - newHeight;
            img.scaleToFit(newWidth, newHeight).setFixedPosition(x, y);
            documento.add(img);
            
            // criacao da tabela
            float [] pointColumnWidths = {100f, 300f, 200f, 100f, 100f, 100f, 100f, 150f}; //8 colunas com a largura variavel de cada
            Table tabela = new Table(pointColumnWidths);
            tabela.setAutoLayout();
            
            //a primeira linha sera o cabecalho (celula1 e 2)
            Cell celula1 = new Cell();
            celula1.add(new Paragraph(Janela.traducao.getString("rt_Viagem")));
            celula1.setTextAlignment(TextAlignment.CENTER);
            celula1.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula1);
            
            Cell celula2 = new Cell();
            celula2.add(new Paragraph(Janela.traducao.getString("rt_Transportador")));
            celula2.setTextAlignment(TextAlignment.CENTER);
            celula2.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula2);
            
            Cell celula3 = new Cell();
            celula3.add(new Paragraph(Janela.traducao.getString("rt_CPFCNPJ")));
            celula3.setTextAlignment(TextAlignment.CENTER);
            celula3.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula3);
            
            Cell celula4 = new Cell();
            celula4.add(new Paragraph(Janela.traducao.getString("rt_Distancia")));
            celula4.setTextAlignment(TextAlignment.CENTER);
            celula4.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula4);
            
            Cell celula5 = new Cell();
            celula5.add(new Paragraph(Janela.traducao.getString("rt_Duracao")));
            celula5.setTextAlignment(TextAlignment.CENTER);
            celula5.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula5);
            
            Cell celula6 = new Cell();
            celula6.add(new Paragraph(Janela.traducao.getString("rt_Valor")));
            celula6.setTextAlignment(TextAlignment.CENTER);
            celula6.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula6);
            
            Cell celula7 = new Cell();
            celula7.add(new Paragraph(Janela.traducao.getString("rt_Pagamento")));
            celula7.setTextAlignment(TextAlignment.CENTER);
            celula7.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula7);
            
            Cell celula8 = new Cell();
            celula8.add(new Paragraph(Janela.traducao.getString("rt_Data")));
            celula8.setTextAlignment(TextAlignment.CENTER);
            celula8.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula8);
            
            //populando linhas da tabela
            for(int i = 0; i < listaViagens.size(); i++){
                tabela.addCell(new Cell().add(new Paragraph(listaViagens.get(i).getIdentification())));
                tabela.addCell(new Cell().add(new Paragraph(listaViagens.get(i).getCarrierName())));
                tabela.addCell(new Cell().add(new Paragraph(verificaCPNPJCPF(listaViagens.get(i).getCarrierCNPJCPF()))));
                tabela.addCell(new Cell().add(new Paragraph(Double.toString(listaViagens.get(i).getDistancia()))));
                tabela.addCell(new Cell().add(new Paragraph(listaViagens.get(i).getDuracao())));
                tabela.addCell(new Cell().add(new Paragraph(Double.toString(listaViagens.get(i).getValor()))));
                tabela.addCell(new Cell().add(new Paragraph(verificaTipoPagamento(listaViagens.get(i).getTipoPagamento()))).setTextAlignment(TextAlignment.CENTER));
                tabela.addCell(new Cell().add(new Paragraph(ajustaData(listaViagens.get(i).getInsertDate()))).setTextAlignment(TextAlignment.CENTER));
            }
          
            //adiciona tabela no documento e gera PDF:
            documento.add(tabela);
            documento.close();

        } catch (FileNotFoundException | MalformedURLException ex) {
            Logger.getLogger(ReportModule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(ReportModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public void reportEquipmentQuery() throws SQLException, IOException{
        DatabaseConfig databaseConfig = new DatabaseConfig();
        this.connectionString = databaseConfig.getConnectionString();
        
        PdfWriter writer = null;
        this.destinoArquivo = salvaRelatorio(Janela.traducao.getString("rt_ReportVeiculos"));
        //this.destinoArquivo = "./teste3.pdf";
        try {
            PdfFont titleFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont subtitleFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        
            writer = new PdfWriter(this.destinoArquivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document documento = new Document(pdf);
            
            // Definindo a orientação da página como paisagem
            PageSize pageSize = PageSize.A3.rotate();
            Rectangle pageMargins = new Rectangle(50, 50, 50, 50);
            pdf.setDefaultPageSize(pageSize);
            //documento.setMargins(pageMargins.getLeft(), pageMargins.getRight(), pageMargins.getTop(), pageMargins.getBottom());

            // Title
            Text titleText = new Text(Janela.traducao.getString("rt_ReportVeiculos"))
                    .setFont(titleFont)
                    .setFontSize(FONT_SIZE_TITLE);
            documento.add(new Paragraph(titleText).setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Subtitle
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDate = LocalDateTime.now().format(formatter);
            Text subtitleText = new Text(Janela.traducao.getString("rt_DataGeracao") + " " + formattedDate)
                    .setFont(subtitleFont)
                    .setFontSize(FONT_SIZE_SUBTITLE);
            documento.add(new Paragraph(subtitleText).setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Insere Selo Bino de Qualidade
            //criando objeto imagem para adicionar no relatorio
            ImageData data = ImageDataFactory.create("./images/seloBino.jpg");
            com.itextpdf.layout.element.Image img = new com.itextpdf.layout.element.Image(data);
            // Definindo a posição da imagem no canto superior direito da folha A3
            float scale = 0.95f; // reduzir para 95% do tamanho original
            float newWidth = img.getImageScaledWidth() * scale;
            float newHeight = img.getImageScaledHeight() * scale;
            float x = pageSize.getWidth() - newWidth;
            float y = pageSize.getHeight() - newHeight;
            img.scaleToFit(newWidth, newHeight).setFixedPosition(x, y);
            documento.add(img);
            
            // criacao da tabela
            float [] pointColumnWidths = {400f, 150f, 150f, 150f, 150f, 100f, 150f, 100f}; //8 colunas com a largura variavel de cada
            Table tabela = new Table(pointColumnWidths);
            tabela.setAutoLayout();
            
            //a primeira linha sera o cabecalho (celula1 e 2)
            Cell celula1 = new Cell();
            celula1.add(new Paragraph(Janela.traducao.getString("rt_Transportador")));
            celula1.setTextAlignment(TextAlignment.CENTER);
            celula1.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula1);
            
            Cell celula2 = new Cell();
            celula2.add(new Paragraph(Janela.traducao.getString("rt_CPFCNPJ")));
            celula2.setTextAlignment(TextAlignment.CENTER);
            celula2.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula2);
            
            Cell celula3 = new Cell();
            celula3.add(new Paragraph(Janela.traducao.getString("rt_Tipo")));
            celula3.setTextAlignment(TextAlignment.CENTER);
            celula3.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula3);
            
            Cell celula4 = new Cell();
            celula4.add(new Paragraph(Janela.traducao.getString("rt_Modelo")));
            celula4.setTextAlignment(TextAlignment.CENTER);
            celula4.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula4);
            
            Cell celula5 = new Cell();
            celula5.add(new Paragraph(Janela.traducao.getString("tb_Marca")));
            celula5.setTextAlignment(TextAlignment.CENTER);
            celula5.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula5);
            
            Cell celula6 = new Cell();
            celula6.add(new Paragraph(Janela.traducao.getString("rt_Eixos")));
            celula6.setTextAlignment(TextAlignment.CENTER);
            celula6.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula6);
            
            Cell celula7 = new Cell();
            celula7.add(new Paragraph(Janela.traducao.getString("rt_Placa")));
            celula7.setTextAlignment(TextAlignment.CENTER);
            celula7.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula7);
            
            Cell celula8 = new Cell();
            celula8.add(new Paragraph(Janela.traducao.getString("rt_Tipo")));
            celula8.setTextAlignment(TextAlignment.CENTER);
            celula8.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula8);
            
            //Busca dados
            // Declare the JDBC objects.
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            
            connection = DriverManager.getConnection(connectionString);

            // Create and execute a SELECT SQL statement.
            String selectSql = "select a.CarrierName, a.CarrierCNPJCPF, b.Type, b.Modelo, b.Marca, b.Eixos, b.LicensePlate, a.Type from carrier.Carrier a inner join carrier.Equipment b on a.Id = b.CarrierId";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(selectSql);
            System.out.println(resultSet.toString());
            // Create results from select statement
            while (resultSet.next()) {
                tabela.addCell(new Cell().add(new Paragraph(resultSet.getString(1))));
                tabela.addCell(new Cell().add(new Paragraph(verificaCPNPJCPF(resultSet.getString(2)))));
                tabela.addCell(new Cell().add(new Paragraph(resultSet.getString(3))));
                tabela.addCell(new Cell().add(new Paragraph(resultSet.getString(4))));
                tabela.addCell(new Cell().add(new Paragraph(resultSet.getString(5))));
                tabela.addCell(new Cell().add(new Paragraph(resultSet.getString(6))).setTextAlignment(TextAlignment.CENTER));
                tabela.addCell(new Cell().add(new Paragraph(resultSet.getString(7))));
                tabela.addCell(new Cell().add(new Paragraph(insereTipo(Integer.parseInt(resultSet.getString(8))))).setTextAlignment(TextAlignment.CENTER));
            }
            
            //adiciona tabela no documento e gera PDF:
            documento.add(tabela);
            documento.close();

        } catch (FileNotFoundException | MalformedURLException ex) {
            Logger.getLogger(ReportModule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(ReportModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    private String salvaRelatorio(String reportName){
        File pasta = new File("./reports");

        // Verifica se a pasta já existe
        if (!pasta.exists()) {
            // Cria a pasta
            boolean criado = pasta.mkdirs();
            if (!criado) {
                // Se a pasta não pôde ser criada, lança uma exceção ou realiza outra ação
            }
        }

        // Retorna caminho
        return this.destinoArquivo = "./reports/"+ reportName + " - " + getGLog() + ".pdf";
    }
    
    private String insereTipo(int tipoTransportador){
        if(tipoTransportador == 0) return "TAC";
        else return "ETC";
    }
    
    private String verificaCPNPJCPF(String numero){
        if (numero.length() == 11) {
            numero = formatarCPF(numero);
        } else {
            numero = formatarCNPJ(numero);
        }
        return numero;
    }
    
    private String formatarCNPJ(String cnpj) {
        try {
            NumberFormat formatter = NumberFormat.getInstance();
            formatter.setMinimumIntegerDigits(14);
            formatter.setGroupingUsed(false);
            String cnpjFormatado = formatter.format(Long.parseLong(cnpj));
            return cnpjFormatado.substring(0, 2) + "." + cnpjFormatado.substring(2, 5) + "." + cnpjFormatado.substring(5, 8) + "/" + cnpjFormatado.substring(8, 12) + "-" + cnpjFormatado.substring(12, 14);
        } catch (Exception e) {
            return cnpj;
        }
    }
    
    private String formatarCPF(String cpf) {
        try {
            NumberFormat formatter = NumberFormat.getInstance();
            formatter.setMinimumIntegerDigits(11);
            formatter.setGroupingUsed(false);
            String cpfFormatado = formatter.format(Long.parseLong(cpf));
            return cpfFormatado.substring(0, 3) + "." + cpfFormatado.substring(3, 6) + "." + cpfFormatado.substring(6, 9) + "-" + cpfFormatado.substring(9, 11);
        } catch (Exception e) {
            return cpf;
        }
    }
    
    private String formatCEP(String cep) {
        return cep.substring(0, 5) + "-" + cep.substring(5);
    }
    
    private String formatPhoneNumber(String number) {
        if (number.length() == 11) {  // celular
            return String.format("(%s) %s %s-%s", number.substring(0, 2), number.substring(2, 3),
                    number.substring(3, 7), number.substring(7));
        } else if (number.length() == 10) {  // telefone fixo
            return String.format("(%s) %s-%s", number.substring(0, 2), number.substring(2, 6),
                    number.substring(6));
        } else {
            return "Número inválido";
        }
    }
    
    private String ajustaData(String inputDate) throws ParseException{
        DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = inputDateFormat.parse(inputDate);

        DateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String outputDate = outputDateFormat.format(date);

        return outputDate;
    }
    
    private String verificaTipoPagamento(int codigo){
        //Verifica tipoPagamento
        if (codigo == 0) {
            return "Cartão";
        } else {
            return "Tag";
        }
    }
    
}