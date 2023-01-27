package LengthTextTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LengthTextTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("lengthText");
        StringP s = new StringP();
        s.addString("lengthText");
        StringP par = new StringP();
        par.addString("Hola");
        ArrayList<Parameter> arr = new ArrayList<>();
        arr.add(s);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "4");

        Function f1 = GetFunctionFactory.getInstance("lengthText");
        StringP s1 = new StringP();
        s1.addString("lengthText");
        StringP par1 = new StringP();
        par1.addString("");
        ArrayList<Parameter> arr1 = new ArrayList<>();
        arr1.add(s1);
        arr1.add(par1);
        f1.setParameter(arr1);

        assertEquals(f1.getValue(), "0");

        Function f2 = GetFunctionFactory.getInstance("lengthText");
        StringP s2 = new StringP();
        s2.addString("lengthText");
        StringP par2 = new StringP();
        par2.addString("Estoy testeando");
        ArrayList<Parameter> arr2 = new ArrayList<>();
        arr2.add(s2);
        arr2.add(par2);
        f2.setParameter(arr2);

        assertEquals(f2.getValue(), "15");
    }

}