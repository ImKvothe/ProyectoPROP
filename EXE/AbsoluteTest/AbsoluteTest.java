package AbsoluteTest;

import dominio.model.*;
import dominio.parameter.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class AbsoluteTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("absolute");
        ArrayList<Parameter> aux = new ArrayList<>();
        DoubleP a = new DoubleP();
        a.addDouble(-1);
        StringP s = new StringP();
        s.addString("absolute");
        aux.add(s);
        aux.add(a);
        f.setParameter(aux);

        Function f1 = GetFunctionFactory.getInstance("absolute");
        ArrayList<Parameter> aux1 = new ArrayList<>();
        DoubleP a1 = new DoubleP();
        a1.addDouble(0);
        StringP s1 = new StringP();
        s1.addString("absolute");
        aux1.add(s1);
        aux1.add(a1);
        f1.setParameter(aux1);

        assertEquals(f.getValue(), "1.0");
        assertEquals(f1.getValue(), "0.0");
    }
}