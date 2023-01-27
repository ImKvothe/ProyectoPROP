package CellTest;

import org.junit.jupiter.api.Test;
import dominio.model.*;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    public void testValues() {
        //Comprobar constructora
        Cell cell = new Cell(1,0);
        assertEquals(cell.getColumn(), 0);
        assertEquals(cell.getRow(), 1);
        assertEquals(cell.getCellValue().getValue(), "");

        //Comprobar setters
        CellValueInterface cvi = new CellValue("test");
        cell.setCellValue(cvi);
        cell.setColumn(1);
        cell.setRow(0);
        assertEquals(cell.getColumn(), 1);
        assertEquals(cell.getRow(), 0);
        assertEquals(cell.getCellValue().getValue(), "test");
    }

}