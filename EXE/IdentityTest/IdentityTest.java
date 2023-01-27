package IdentityTest;

import org.junit.jupiter.api.Test;
import dominio.parameter.*;
import dominio.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IdentityTest {

    @Test
    public void testValues() throws Exception {
        Function f = GetFunctionFactory.getInstance("identity");
        StringP s = new StringP();
        s.addString("identity");
        ArrayList<Parameter> aux = new ArrayList<>();
        aux.add(s);
        aux.add(s);
        f.setParameter(aux);

        assertEquals(f.getValue(), "identity");

    }
}