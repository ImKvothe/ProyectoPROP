package DayOfWeekTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("dayOfWeek");
        ArrayList<Parameter> aux = new ArrayList<>();
        StringP a = new StringP();
        StringP s = new StringP();
        a.addString("22/04/2022");
        s.addString("dayOfWeek");
        aux.add(s);
        aux.add(a);
        f.setParameter(aux);

        assertEquals(f.getValue(), "Friday");

        Function f1 = GetFunctionFactory.getInstance("dayOfWeek");
        ArrayList<Parameter> aux1 = new ArrayList<>();
        a.addString("01/01/1969");
        s.addString("dayOfWeek");
        aux1.add(s);
        aux1.add(a);
        f1.setParameter(aux1);

        assertEquals(f1.getValue(), "Wednesday");
    }
}