package VarianceTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VarianceTest
{
    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("variance");
        ArrayList<Parameter> arr = new ArrayList<>();
        StringP s = new StringP();
        s.addString("variance");
        arr.add(s);
        StringP parS = new StringP();
        parS.addString("sample");
        arr.add(parS);
        ArrayDoubleP parD = new ArrayDoubleP();
        parD.addDouble(4);
        parD.addDouble(8);
        arr.add(parD);
        f.setParameter(arr);

        assertEquals(f.getValue(), "8.0");

        parS.addString("population");
        arr.clear();
        arr.add(s);
        arr.add(parS);
        arr.add(parD);
        f.setParameter(arr);

        assertEquals(f.getValue(), "4.0");

        parD.addDouble(-54.5);
        arr.clear();
        arr.add(s);
        arr.add(parS);
        arr.add(parD);
        f.setParameter(arr);

        assertEquals(f.getValue(), "816.0555555555557");

        parS.addString("sample");
        arr.clear();
        arr.add(s);
        arr.add(parS);
        arr.add(parD);
        f.setParameter(arr);

        assertEquals(f.getValue(), "1224.0833333333335");
    }

}