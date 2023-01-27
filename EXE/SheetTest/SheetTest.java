package SheetTest;

import org.junit.jupiter.api.Test;
import dominio.model.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SheetTest {

    @Test
    public void testSheet() throws Exception {
        Sheet sheet = new Sheet("Hoja 1");

        References references = new References();


        //Comprobar constructoras
        assertEquals(sheet.getName(), "Hoja 1");
        assertEquals(sheet.getReferences().getKeys(), references.getKeys());
        assertEquals(sheet.getCell(0,0).getCellValue().getValue(), "");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4; j++) {
                assertEquals(sheet.getCjt_cells().get(i).get(j).getCellValue().getValue(), "");
            }
        }

        //Comprobar setCell()
        sheet.setCell(0,0, "test");
        assertEquals(sheet.getCell(0,0).getCellValue().getValue(), "test");

        CellValue aux = new CellValue("test1");
        sheet.setCell(0,0, aux);
        assertEquals(sheet.getCell(0,0).getCellValue().getValue(), "test1");

        //Comprobar setReferences()
        Cell ref1 = new Cell(0,1);
        Cell ref2 = new Cell(0,0);
        sheet.setReferences(ref1, ref2);
        references.addReference(ref1, ref2);
        assertEquals(sheet.getReferences().getKeys().get(0), references.getKeys().get(0));

        //Comprobar eraseReferences() y addRow()
        sheet.getReferences().eraseReference(ref1, ref2);
        sheet.setCell(1,0,"test2");
        sheet.addRow(1);
        assertEquals(sheet.getCell(2,0).getCellValue().getValue(), "test2");
        assertEquals(sheet.getCell(1,0).getCellValue().getValue(), "");

        //Comprobar deleteRow()
        sheet.deleteRow(1);
        assertEquals(sheet.getCell(1,0).getCellValue().getValue(), "test2");
        assertEquals(sheet.getCell(2,0).getCellValue().getValue(), "");

        //Comprobar addColumn()
        sheet.setCell(0,1,"test1");
        sheet.addColumn(1);
        assertEquals(sheet.getCell(0,1).getCellValue().getValue(), "");
        assertEquals(sheet.getCell(0,2).getCellValue().getValue(), "test1");

        //Comprobar deleteColumn()
        sheet.deleteColumn(1);
        assertEquals(sheet.getCell(0,2).getCellValue().getValue(), "");
        assertEquals(sheet.getCell(0,1).getCellValue().getValue(), "test1");

        ArrayList<Cell> cjtCell = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Cell cellAux = new Cell(i,j);
                cjtCell.add(cellAux);
            }
        }

        //Comprobar copyContBloq()
        ArrayList<Cell> cjtCellAux0 = new ArrayList<>();
        cjtCellAux0.add(sheet.getCell(0,0));
        ArrayList<Cell> cjtCellAux1 = new ArrayList<>();
        cjtCellAux1.add(sheet.getCell(1,1));
        sheet.copyContBloq(cjtCellAux0,cjtCellAux1);
        assertEquals(sheet.getCell(1,1).getCellValue().getValue(), sheet.getCell(0,0).getCellValue().getValue());

        //Comprobar moveContBloq
        cjtCellAux1.clear();
        cjtCellAux1.add(sheet.getCell(0,1));
        sheet.moveContBloq(cjtCellAux0,cjtCellAux1);
        assertEquals(sheet.getCell(0,0).getCellValue().getValue(), "");
        assertEquals(sheet.getCell(0,1).getCellValue().getValue(), "test1");

        //Comprobar sortContBloq
        cjtCellAux0.clear();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                cjtCellAux0.add(sheet.getCell(i,j));
            }
        }
        sheet.sortContBloq(cjtCellAux0, 2);
        assertEquals(sheet.getCell(0,0).getCellValue().getValue(), "test2");
        assertEquals(sheet.getCell(0,1).getCellValue().getValue(), "test1");
        assertEquals(sheet.getCell(1,0).getCellValue().getValue(), "test1");
        assertEquals(sheet.getCell(1,1).getCellValue().getValue(), "");

        sheet.sortContBloq(cjtCellAux0, 1);
        assertEquals(sheet.getCell(0,0).getCellValue().getValue(), "test1");
        assertEquals(sheet.getCell(0,1).getCellValue().getValue(), "test1");
        assertEquals(sheet.getCell(1,0).getCellValue().getValue(), "test2");
        assertEquals(sheet.getCell(1,1).getCellValue().getValue(), "");

        //Comprobar searchContBloq()
        cjtCellAux1.clear();
        cjtCellAux1.add(sheet.getCell(0,0));
        cjtCellAux1.add(sheet.getCell(0,1));
        assertEquals(sheet.searchContBloq(cjtCellAux0,"test1"), cjtCellAux1);

        //Comprobar replaceContBloq()
        sheet.replaceContBloq(cjtCellAux0,"test1", "prueba");
        assertEquals(sheet.getCell(0,0).getCellValue().getValue(), "prueba");
        assertEquals(sheet.getCell(0,1).getCellValue().getValue(), "prueba");
        assertEquals(sheet.getCell(1,0).getCellValue().getValue(), "test2");
        assertEquals(sheet.getCell(1,1).getCellValue().getValue(), "");

        //Comprobar executeInput()
        sheet.executeInput("hola", sheet.getCell(2,2));
        assertEquals(sheet.getCell(2,2).getCellValue().getValue(), "hola");
        sheet.executeInput("=mean(4,7,20,5)", sheet.getCell(2,2));
        assertEquals(sheet.getCell(2,2).getCellValue().getValue(), "9");

        //Comprobar updateSheet()
        CellValueInterface aux1 = new CellValue("HOLA");
        sheet.getCell(0,0).setCellValue(aux1);
        aux1.setValue("=A0");
        sheet.getCell(1,1).setCellValue(aux1);
        sheet.updateValues();
        assertEquals(sheet.getCell(1,1).getCellValue().getValue(), sheet.getCell(0,0).getCellValue().getValue());

        //Comprobar deleteContBloq()
        sheet.deleteContBloq(cjtCell);
        References references1 = new References();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <2; j++) {
                assertEquals(sheet.getCjt_cells().get(i).get(j).getCellValue().getValue(), "");
            }
        }
        assertEquals(sheet.getReferences().getKeys(), references1.getKeys());


    }

}