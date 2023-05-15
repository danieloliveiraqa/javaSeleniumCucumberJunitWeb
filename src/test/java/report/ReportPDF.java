package report;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReportPDF {

    private static Document document;
    private static PdfWriter writer;
    private static PdfContentByte canvas;
    private static PdfTemplate template;
    private static ByteArrayOutputStream baos;

    public static void initReport(String fileName) {
        document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            canvas = writer.getDirectContent();
            template = canvas.createTemplate(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            baos = new ByteArrayOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addScenarioName(String scenarioName) {
        try {
            Paragraph para = new Paragraph(scenarioName, new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            document.add(para);
            document.newPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addScreenshot(String imageName) {
        try {
            BufferedImage image = ImageIO.read(new File(imageName));
            Image img = Image.getInstance(toByteArray(image));
            Rectangle pageSize = new Rectangle(img.getWidth(), img.getHeight());
            document.setPageSize(pageSize);
            document.newPage();
            img.setAbsolutePosition(0, 0);
            canvas.addImage(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeReport() {
        try {
            canvas.addTemplate(template, 0, 0);
            document.close();
            baos.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] toByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

}
