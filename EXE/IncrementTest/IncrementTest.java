package IncrementTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IncrementTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("increment");
        StringP s = new StringP();
        s.addString("increment");
        DoubleP d = new DoubleP();
        d.addDouble(0);
        ArrayList<Parameter> arr = new ArrayList<>();
        arr.add(s);
        arr.add(d);
        f.setParameter(arr);

        assertEquals(f.getValue(), "1.0");

        Function f1 = GetFunctionFactory.getInstance("increment");
        StringP s1 = new StringP();
        s1.addString("increment");
        DoubleP d1 = new DoubleP();
        d1.addDouble(8.5);
        ArrayList<Parameter> arr1 = new ArrayList<>();
        arr1.add(s1);
        arr1.add(d1);
        f1.setParameter(arr1);

        assertEquals(f1.getValue(), "9.5");

        Function f2 = GetFunctionFactory.getInstance("increment");
        StringP s2 = new StringP();
        s2.addString("increment");
        DoubleP d2 = new DoubleP();
        d2.addDouble(-9);
        ArrayList<Parameter> arr2 = new ArrayList<>();
        arr2.add(s2);
        arr2.add(d2);
        f2.setParameter(arr2);

        assertEquals(f2.getValue(), "-8.0");

    }

}