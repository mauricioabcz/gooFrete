package com.gooFrete.Model;

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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportModule {

    private String destinoArquivo;
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
        //this.destinoArquivo = verificaPasta();
        this.destinoArquivo = "./teste.pdf";
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
            Text titleText = new Text("Relatório de Transportadores")
                    .setFont(titleFont)
                    .setFontSize(FONT_SIZE_TITLE);
            documento.add(new Paragraph(titleText).setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Subtitle
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDate = LocalDateTime.now().format(formatter);
            Text subtitleText = new Text("Extração em " + formattedDate)
                    .setFont(subtitleFont)
                    .setFontSize(FONT_SIZE_SUBTITLE);
            documento.add(new Paragraph(subtitleText).setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Insere Selo Bino de Qualidade
            //criando objeto imagem para adicionar no relatorio
            System.out.println("Diretório atual: " + System.getProperty("user.dir"));
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
            float [] pointColumnWidths = {150f, 150f, 150f, 150f, 150f, 150f, 150f, 150f, 150f}; //2 colunas com a largura variavel de cada
            Table tabela = new Table(pointColumnWidths);
            tabela.setAutoLayout();
            
            //a primeira linha sera o cabecalho (celula1 e 2)
            Cell celula1 = new Cell();
            celula1.add(new Paragraph("Transportador"));
            celula1.setWidth(100);
            celula1.setTextAlignment(TextAlignment.CENTER);
            celula1.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula1);
            
            Cell celula2 = new Cell();
            celula2.add(new Paragraph("CPF/CNPJ"));
            celula2.setTextAlignment(TextAlignment.CENTER);
            celula2.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula2);
            
            Cell celula3 = new Cell();
            celula3.add(new Paragraph("Endereço"));
            celula3.setWidth(450);
            celula3.setTextAlignment(TextAlignment.CENTER);
            celula3.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula3);
            
            Cell celula4 = new Cell();
            celula4.setWidth(200);
            celula4.add(new Paragraph("Bairro"));
            celula4.setTextAlignment(TextAlignment.CENTER);
            celula4.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula4);
            
            Cell celula5 = new Cell();
            celula5.add(new Paragraph("Cidade"));
            celula5.setWidth(200);
            celula5.setTextAlignment(TextAlignment.CENTER);
            celula5.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula5);
            
            Cell celula6 = new Cell();
            celula6.add(new Paragraph("Estado"));
            celula6.setTextAlignment(TextAlignment.CENTER);
            celula6.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula6);
            
            Cell celula7 = new Cell();
            celula7.add(new Paragraph("País"));
            celula7.setTextAlignment(TextAlignment.CENTER);
            celula7.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula7);
            
            Cell celula8 = new Cell();
            celula8.add(new Paragraph("CEP"));
            celula8.setTextAlignment(TextAlignment.CENTER);
            celula8.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula8);
            
            Cell celula9 = new Cell();
            celula9.add(new Paragraph("Telefone"));
            celula9.setTextAlignment(TextAlignment.CENTER);
            celula9.setBackgroundColor(ColorConstants.GRAY);
            tabela.addCell(celula9);
            
//            Cell celula10 = new Cell();
//            celula10.add(new Paragraph("Tipo"));
//            celula10.setTextAlignment(TextAlignment.CENTER);
//            celula10.setBackgroundColor(ColorConstants.GRAY);
//            tabela.addCell(celula10);
            
            //populando linhas da tabela
            int quantidadeLinhas = 6;
            int quantidadeColunas = 10;
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
//                tabela.addCell(new Cell().add(new Paragraph("N/A")));
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
    
    private String verificaPasta(){
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
        return this.destinoArquivo = "./reports/Relatório de Transportadores - " + getGLog() + ".pdf";
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
    
}