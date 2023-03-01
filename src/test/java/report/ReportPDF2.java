package report;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReportPDF2 {
    public static void gerarPDF2() {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        JsonNode json = null;
        try {
            json = mapper.readTree(new File("target/report/cucumber.json"));
            root = mapper.readTree(new File("src/test/java/Jsons/createUser.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// extrair dados do arquivo JSON


        String apiNameValue = root.get(0).get("name").asText();

        // CASO FOR RODAR UM REGRESSIVO PARA DA FEATURE DEVE-SE MUDAR GET DO NAME PARA 0 PARA 0 PARA ASSIM ARQUIVO RECEBER NOME DA TAG RODADA
        String tags = json.get(0).get("elements").get(0).get("tags").get(1).get("name").asText();

        String primeiraTag = json.get(0).get("elements").get(0).get("tags").get(0).get("name").asText();
        String segundaTag = json.get(0).get("elements").get(0).get("tags").get(1).get("name").asText();

        ArrayList<String> checkCenario = new ArrayList<>(json.findValuesAsText("status"));

        ArrayList<String> tagRodada = new ArrayList<>(json.get(0).get("elements").get(0).get("tags").findValuesAsText("name"));

        ArrayList<String> names = new ArrayList<>(json.findValuesAsText("name"));


        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = agora.format(formatter);

        String dateHourFormat = dataHoraFormatada.replace("/", "-").replace(":", "-");
        String tagFormat = tags.replace("@", "");



        try {

            Document document = new Document();;
            if(checkCenario.contains("failed")){
                PdfWriter.getInstance(document, new FileOutputStream("src/test/java/evidence/failed/report_" + tagFormat + "_" + dateHourFormat + ".pdf"));
            } else {
                PdfWriter.getInstance(document, new FileOutputStream("src/test/java/evidence/passed/report_" + tagFormat + "_" + dateHourFormat + ".pdf"));
            }
            document.open();
            // Define o caminho para a imagem do cabeçalho
            String imagePath = "cabecalho-sharecare.png";

            // Cria uma imagem com a imagem do cabeçalho
            Image headerImage = Image.getInstance(imagePath);
            headerImage.scalePercent(80f);


            // Define o cabeçalho para cada página
            document.add(headerImage);


            Paragraph title = new Paragraph("Relatório de Teste de API");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Paragraph executor = new Paragraph("Nome do Executor: " + apiNameValue);
            document.add(executor);

            Paragraph dataDoTeste = new Paragraph("Data do teste: " + dataHoraFormatada);
            document.add(dataDoTeste);

           if(names.size() > 9){
               Paragraph tag = new Paragraph("Tag Executada: " + primeiraTag);
               document.add(tag);
           }  else{
               Paragraph tag = new Paragraph("Tag Executada: " + segundaTag);
               document.add(tag);
           }

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // adiciona as colunas da tabela
            PdfPCell header1 = new PdfPCell(new Paragraph("Nome do cenario"));
            header1.setBorderColor(BaseColor.BLACK);
            header1.setPaddingLeft(10);
            header1.setHorizontalAlignment(Element.ALIGN_CENTER);
            header1.setVerticalAlignment(Element.ALIGN_CENTER);
            header1.setBackgroundColor(BaseColor.GRAY);
            table.addCell(header1);

            PdfPCell header2 = new PdfPCell(new Paragraph("Resultado do Teste"));
            header2.setBorderColor(BaseColor.BLACK);
            header2.setPaddingLeft(10);
            header2.setHorizontalAlignment(Element.ALIGN_CENTER);
            header2.setVerticalAlignment(Element.ALIGN_CENTER);
            header2.setBackgroundColor(BaseColor.GRAY);
            table.addCell(header2);

            // adiciona uma linha para cada teste encontrado no arquivo JSON
            for (JsonNode element : json.get(0).get("elements")) {
                String line = element.get("name").asText();
                String passed = element.get("steps").get(2).get("result").get("status").asText();

                PdfPCell apiNameCell = new PdfPCell(new Paragraph(line));
                apiNameCell.setBorderColor(BaseColor.BLACK);
                apiNameCell.setPaddingLeft(10);
                apiNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                apiNameCell.setVerticalAlignment(Element.ALIGN_CENTER);
                table.addCell(apiNameCell);

                PdfPCell resultCell = new PdfPCell(new Paragraph(passed));
                resultCell.setBorderColor(BaseColor.BLACK);
                resultCell.setPaddingLeft(10);
                resultCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                resultCell.setVerticalAlignment(Element.ALIGN_CENTER);

                if (passed.equals("passed")) {
                    resultCell.setBackgroundColor(BaseColor.GREEN);
                } else {
                    resultCell.setBackgroundColor(BaseColor.RED);
                }
                table.addCell(resultCell);
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
