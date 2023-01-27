package StandardDeviationTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StandardDeviationTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("standard");
        ArrayList<Parameter> arr = new ArrayList<>();
        StringP s = new StringP();
        s.addString("standard");
        arr.add(s);
        StringP parS = new StringP();
        parS.addString("population");
        arr.add(parS);
        ArrayDoubleP par = new ArrayDoubleP();
        par.addDouble(3);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "0.0");

        par.addDouble(5);
        arr.clear();
        arr.add(s);
        arr.add(parS);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "1.0");

        parS.addString("sample");
        arr.clear();
        arr.add(s);
        arr.add(parS);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "1.4142135623730951");

        par.addDouble(-45.5);
        arr.clear();
        arr.add(s);
        arr.add(parS);
        arr.add(par);
        f.setParameter(arr);

        assertEquals(f.getValue(), "28.59632843565761");

    }

    static class ElementExtractionTest {

        @Test
        public void testValues() throws Exception {
            Function f = GetFunctionFactory.getInstance("elementExtraction");
            ArrayList<Parameter> arr = new ArrayList<>();
            StringP s = new StringP();
            s.addString("elementExtraction");
            arr.add(s);
            StringP d = new StringP();
            d.addString("day");
            arr.add(d);
            StringP date = new StringP();
            date.addString("23/04/2022");
            arr.add(date);
            f.setParameter(arr);

            assertEquals(f.getValue(), "23");

            d.addString("month");
            arr.clear();
            arr.add(s);
            arr.add(d);
            arr.add(date);
            f.setParameter(arr);

            assertEquals(f.getValue(), "04");

            d.addString("year");
            arr.clear();
            arr.add(s);
            arr.add(d);
            arr.add(date);
            f.setParameter(arr);

            assertEquals(f.getValue(), "2022");
        }

    }
}