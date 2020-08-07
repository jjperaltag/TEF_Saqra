/*
package trazabilidadWeb.utility;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class iTextUtiliy {
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.ITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    private static final String iTextExampleImage = "./src/test/resources/logo/Logo_Wipro.jpg";
    public Document  CreatePDF(File pdfNewFile){
        Document document=new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

        } catch (FileNotFoundException | DocumentException fileNotFoundException) {
            System.out.println("No such file was found to generate the PDF "
                    + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
        }
        return document;
    }
    public  Chapter CreatePage(Document document){
        Chunk chunk = new Chunk("", chapterFont);
        Chapter page=new Chapter(new Paragraph(chunk),1);
        return page;
    }
    public void AddImage(String path_image,Chapter pagina,float position_x,float position_y){
        try {
            Image image=Image.getInstance(iTextExampleImage);

        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



 */
