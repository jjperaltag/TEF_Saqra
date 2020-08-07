package trazabilidadWeb.pageObject;

import gherkin.JSONParser;
import trazabilidadWeb.helpers.BasePage;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class P012_Json extends BasePage {

    void doJson() throws FileNotFoundException {
        //JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("Testdata.json");
        //Read JSON file
       //Object obj = jsonParser.parse(reader);
    }
}
