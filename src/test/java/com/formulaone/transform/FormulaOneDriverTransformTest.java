package com.formulaone.transform;

import com.formulaone.model.FormulaOneDriver;
import com.formulaone.trasnform.FormulaOneDriverTransform;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FormulaOneDriverTransformTest {

    private FormulaOneDriverTransform driverLaps;
    private List<FormulaOneDriver> formulaOneDrivers;
    @Before
    public void setup() {
        driverLaps = new FormulaOneDriverTransform();
        formulaOneDrivers = setDriverLapsMockData();
    }

    @Test
    public void shouldGetListOfDrivers() {

        assertNotNull(driverLaps.getAverageLaps(formulaOneDrivers));
        assertTrue(driverLaps.getAverageLaps(formulaOneDrivers).size() > 0);
    }

    @Test
    public void shouldGetAverageLapForEachDriver() {

        List<FormulaOneDriver> formulaOneDriverList = driverLaps.getAverageLaps(formulaOneDrivers);
        assertThat(formulaOneDriverList, containsInAnyOrder(allOf(hasProperty("name", is("Hamilton")),
                hasProperty("lap", is(4.56))),
                allOf(hasProperty("name", is("Verstrappen")),
                        hasProperty("lap", is(4.00))),
                allOf(hasProperty("name", is("Alonzo")),
                        hasProperty("lap", is(4.53)))));
    }

    @Test
    public void shouldGetDriverListSortedInAscendingOrder() {

        List<FormulaOneDriver> driverLapsList =  driverLaps.getAverageLaps(formulaOneDrivers);

        assertThat(driverLapsList, contains(allOf(hasProperty("name", is("Verstrappen")),
                hasProperty("lap", is(4.00))),
                allOf(hasProperty("name", is("Alonzo")),
                        hasProperty("lap", is(4.53))),
                allOf(hasProperty("name", is("Hamilton")),
                        hasProperty("lap", is(4.56)))
        ));
    }

    private List<FormulaOneDriver> setDriverLapsMockData() {

        List<FormulaOneDriver> formulaOneDrivers = new ArrayList<>();
        formulaOneDrivers.add(new FormulaOneDriver("Alonzo", 4.32));
        formulaOneDrivers.add(new FormulaOneDriver("Verstrappen", 4.00));
        formulaOneDrivers.add(new FormulaOneDriver("Alonzo", 4.88));
        formulaOneDrivers.add(new FormulaOneDriver("Hamilton", 4.65));
        formulaOneDrivers.add(new FormulaOneDriver("Alonzo", 4.38));
        formulaOneDrivers.add(new FormulaOneDriver("Verstrappen", 4.00));
        formulaOneDrivers.add(new FormulaOneDriver("Hamilton", 4.61));
        formulaOneDrivers.add(new FormulaOneDriver("Hamilton", 4.43));
        formulaOneDrivers.add(new FormulaOneDriver("Verstrappen", 4.00));
        return formulaOneDrivers;
    }
}
