package CovarianceTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CovarianceTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("covariance");
        ArrayList<Parameter> aux = new ArrayList<>();
        ArrayDoubleP a = new ArrayDoubleP();
        a.addDouble(1);
        a.addDouble(-2);
        a.addDouble(3);
        StringP s = new StringP();
        s.addString("covariance");
        aux.add(s);
        aux.add(a);
        ArrayDoubleP a1 = new ArrayDoubleP();
        a1.addDouble(13);
        a1.addDouble(14);
        a1.addDouble(15);
        aux.add(a1);
        f.setParameter(aux);

        assertEquals(f.getValue(), String.valueOf((double) 2/3));


    }
}