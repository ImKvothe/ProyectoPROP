package TruncateTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TruncateTest {
    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("truncate");
        ArrayList<Parameter> arr = new ArrayList<>();
        StringP s = new StringP();
        s.addString("truncate");
        arr.add(s);
        DoubleP par1 = new DoubleP();
        par1.addDouble(10.01);
        arr.add(par1);
        DoubleP par2 = new DoubleP();
        par2.addDouble(1);
        arr.add(par2);
        f.setParameter(arr);

        assertEquals(f.getValue(), "10.0");

        par2.addDouble(0);
        arr.clear();
        arr.add(s);
        arr.add(par1);
        arr.add(par2);
        f.setParameter(arr);

        assertEquals(f.getValue(), "10");

        par1.addDouble(-20.546);
        par2.addDouble(0);
        arr.clear();
        arr.add(s);
        arr.add(par1);
        arr.add(par2);
        f.setParameter(arr);

        assertEquals(f.getValue(), "-20");

        par1.addDouble(-20);
        par2.addDouble(3);
        arr.clear();
        arr.add(s);
        arr.add(par1);
        arr.add(par2);
        f.setParameter(arr);

        assertEquals(f.getValue(), "-20.0");

        par1.addDouble(4.123);
        par2.addDouble(1);
        arr.clear();
        arr.add(s);
        arr.add(par1);
        arr.add(par2);
        f.setParameter(arr);

        assertEquals(f.getValue(), "4.1");
    }
}