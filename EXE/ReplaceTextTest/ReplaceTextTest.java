package ReplaceTextTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceTextTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("replaceText");
        ArrayList<Parameter> arr = new ArrayList<>();
        StringP s = new StringP();
        s.addString("replaceText");
        arr.add(s);
        StringP par1 = new StringP();
        par1.addString("Hola");
        arr.add(par1);
        StringP par2 = new StringP();
        par2.addString("Hola");
        arr.add(par2);
        StringP par3 = new StringP();
        par3.addString("Adios");
        arr.add(par3);
        f.setParameter(arr);

        assertEquals(f.getValue(), "Adios");

        arr.clear();
        arr.add(s);
        arr.add(par1);
        par2.addString("Ho");
        arr.add(par2);
        par3.addString("Me voy");
        arr.add(par3);
        f.setParameter(arr);

        assertEquals(f.getValue(), "Me voyla");

        arr.clear();
        arr.add(s);
        arr.add(par1);
        par2.addString("Ho");
        arr.add(par2);
        par3.addString("");
        arr.add(par3);
        f.setParameter(arr);

        assertEquals(f.getValue(), "la");
    }

}