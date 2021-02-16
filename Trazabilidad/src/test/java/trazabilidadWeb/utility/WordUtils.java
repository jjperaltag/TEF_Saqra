package trazabilidadWeb.utility;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import trazabilidadWeb.helpers.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WordUtils {

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static void createDoc(String testCaseName, List<String> listScreen) throws Exception {
        try {
            BasePage basePage = new BasePage();
            // Blank Document
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            // Path to Word
            String evidencePath = "./results/";
            int format = XWPFDocument.PICTURE_TYPE_PNG;

            // Insert screenshoots
            int val = 0;
            for (String file : listScreen) {
                String imgFile = "./results/screenshot/" + file;
                run.setText(val + 1 + ". " + ScreenshotUtility.acciones.get(val) + " - Hora y Fecha de Ejecución - "+ basePage.obtenerFechaYHora()+":");
        //        System.out.println(val);
                val++;
                run.addBreak();
                run.addBreak();
                run.addPicture(new FileInputStream(imgFile), format, imgFile, Units.toEMU(420), Units.toEMU(230));
                run.addBreak();
                run.addBreak();
            }

            // Insert Header
            CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
            XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(document, sectPr);

            XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

            paragraph = header.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
            tabStop.setVal(STTabJc.CENTER);
            int twipsPerInch = 1440;
            tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

            run = paragraph.createRun();
            run.setText("SUSTENTO DE PRUEBAS TESTING: SAQRA");
            run.setBold(true);
            run.setFontSize(14);
            run.setTextPosition(100);
            run.setTextPosition(10);
            run.addTab();

            //run = paragraph.createRun();
            String imgLogo = "./src/test/resources/logo/Logo_wipro.jpg";
            run.addPicture(new FileInputStream(imgLogo), XWPFDocument.PICTURE_TYPE_PNG, imgLogo, Units.toEMU(30), Units.toEMU(30));

            // Insert Footer
            CTP ctp = CTP.Factory.newInstance();
            CTText t = ctp.addNewR().addNewT();
            t.setStringValue("Tester: Equipo Testing Saqra");
            XWPFParagraph pars[] = new XWPFParagraph[1];
            pars[0] = new XWPFParagraph(ctp, document);
            XWPFHeaderFooterPolicy hfp = document.createHeaderFooterPolicy();
            hfp.createFooter(XWPFHeaderFooterPolicy.DEFAULT, pars);

            // Write the Document in file system
            FileOutputStream out = new FileOutputStream(new File(evidencePath + testCaseName + " "+timestamp() + ".doc"));
            document.write(out);
            out.close();

            // Print a confirmation image to console
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
