package MedianTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MedianTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("median");
        ArrayList<Parameter> arr = new ArrayList<>();
        StringP s = new StringP();
        s.addString("median");
        arr.add(s);
        ArrayDoubleP par = new ArrayDoubleP();
        par.addDouble(10);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "10.0");

        par.addDouble(20);
        arr.clear();
        arr.add(s);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "15.0");

        par.addDouble(-20);
        arr.clear();
        arr.add(s);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "10.0");

    }
}