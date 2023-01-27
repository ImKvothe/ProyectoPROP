package MeanTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MeanTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("mean");
        StringP s = new StringP();
        s.addString("mean");
        ArrayDoubleP par = new ArrayDoubleP();
        par.addDouble(4);
        ArrayList<Parameter> arr = new ArrayList<>();
        arr.add(s);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "4");

        par.addDouble(11);
        arr.clear();
        arr.add(s);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "7.5");

        par.addDouble(-21);
        arr.clear();
        arr.add(s);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "-2");

        ArrayDoubleP par1 = new ArrayDoubleP();
        arr.clear();
        arr.add(s);
        arr.add(par1);
        f.setParameter(arr);

        assertEquals(f.getValue(), "NaN");
    }
}