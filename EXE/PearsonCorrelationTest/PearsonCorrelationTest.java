package PearsonCorrelationTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PearsonCorrelationTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("pearson");
        ArrayList<Parameter> arr = new ArrayList<>();
        StringP s = new StringP();
        s.addString("pearson");
        arr.add(s);
        ArrayDoubleP par1 = new ArrayDoubleP();
        par1.addDouble(15);
        arr.add(par1);
        ArrayDoubleP par2 = new ArrayDoubleP();
        par2.addDouble(10);
        arr.add(par2);
        f.setParameter(arr);

        assertEquals(f.getValue(), "NaN");

        arr.clear();
        arr.add(s);
        par1.addDouble(20);
        par1.addDouble(-10.5);
        par1.addDouble(10);
        arr.add(par1);
        par2.addDouble(-20.04);
        par2.addDouble(-100);
        par2.addDouble(0);
        arr.add(par2);
        f.setParameter(arr);

        assertEquals(f.getValue(), "0.8720904739497954");

    }

}