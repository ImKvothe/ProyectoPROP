package ReferenceTest;

import org.junit.jupiter.api.Test;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReferencesTest {
    @Test
    public void testValues(){

        //Comprobar constructora
        References ref = new References();
        ArrayList<Cell> arrK = new ArrayList<>();
        ArrayList<ArrayList<Cell>> arrV = new ArrayList<>();
        Cell cell = new Cell(0,0);
        assertEquals(ref.getKeys(), arrK);
        assertEquals(ref.getValues(), arrV);
        assertEquals(ref.getReferencesToCell(cell), arrK);
        assertEquals(ref.getReferencesFromCell(cell), arrK);

        //Comprobar addReference()
        Cell cell1 = new Cell(1,1);
        ref.addReference(cell, cell1);
        arrK.add(cell);
        arrV.add(arrK);
        ArrayList<Cell> arrk1 = new ArrayList<>();
        arrk1.add(cell1);
        ArrayList<Cell> arrk2 = new ArrayList<>();
        assertEquals(ref.getKeys(), arrK);
        assertEquals(ref.getValues().get(0).get(0).getCellValue().getValue(), arrV.get(0).get(0).getCellValue().getValue());
        assertEquals(ref.getReferencesToCell(cell), arrk1);
        assertEquals(ref.getReferencesFromCell(cell), arrk2);

        //Comprobar eraseRefernce()
        ref.eraseReference(cell, cell1);
        arrK.clear();
        arrk1.clear();
        arrk2.clear();
        arrV.clear();
        assertEquals(ref.getKeys(), arrK);
        assertEquals(ref.getValues(), arrV);
        assertEquals(ref.getReferencesToCell(cell), arrK);
        assertEquals(ref.getReferencesFromCell(cell), arrK);

        //Comprobar eraseCellReferenced() y eraseAllReferencesOfACell()
        Cell cell2 = new Cell(2,2);
        ref.addReference(cell, cell1);
        ref.addReference(cell1,cell2);
        ref.eraseCellReferenced(cell1);
        ref.eraseAllReferencesOfACell(cell1);
        assertEquals(ref.getKeys(), arrK);
        assertEquals(ref.getValues(), arrV);
        assertEquals(ref.getReferencesToCell(cell), arrK);
        assertEquals(ref.getReferencesFromCell(cell), arrK);



    }

}