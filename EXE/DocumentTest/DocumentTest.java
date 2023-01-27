package DocumentTest;

import org.junit.jupiter.api.Test;
import dominio.model.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {


    @Test
    public void testValues(){
        //Mira si crea bien el documento
        Document doc = new Document("Prueba");
        ArrayList<Sheet> sheets = new ArrayList<>();
        Sheet auxSheet = new Sheet("Hoja 1");
        sheets.add(auxSheet);

        assertEquals(doc.getCjtSheet().get(0).getName(), sheets.get(0).getName());
        assertEquals(doc.getCjtSheet().size(), sheets.size());
        assertEquals(doc.getName(), "Prueba");

        //Mira si añade bien una Sheet
        doc.addSheet("Hoja 2");
        auxSheet = new Sheet("Hoja 2");
        sheets.add(auxSheet);

        assertEquals(doc.getCjtSheet().get(0).getName(), sheets.get(0).getName());
        assertEquals(doc.getCjtSheet().get(1).getName(), sheets.get(1).getName());
        assertEquals(doc.getCjtSheet().size(), sheets.size());
        assertEquals(doc.getName(), "Prueba");

        //Mira si no añade Sheet que ya existe
        doc.addSheet("Hoja 2");

        assertEquals(doc.getCjtSheet().get(0).getName(), sheets.get(0).getName());
        assertEquals(doc.getCjtSheet().get(1).getName(), sheets.get(1).getName());
        assertEquals(doc.getCjtSheet().size(), sheets.size());
        assertEquals(doc.getName(), "Prueba");

        //Mira si borra bien Sheet que no existe
        doc.deleteSheet("Hoja 1");
        sheets.clear();
        sheets.add(auxSheet);

        assertEquals(doc.getCjtSheet().get(0).getName(), sheets.get(0).getName());
        assertEquals(doc.getCjtSheet().size(), sheets.size());
        assertEquals(doc.getName(), "Prueba");

        //Mira si no borra Sheet que ya existe
        doc.deleteSheet("Hoja 1");
        sheets.clear();
        sheets.add(auxSheet);

        assertEquals(doc.getCjtSheet().get(0).getName(), sheets.get(0).getName());
        assertEquals(doc.getCjtSheet().size(), sheets.size());
        assertEquals(doc.getName(), "Prueba");

    }

}