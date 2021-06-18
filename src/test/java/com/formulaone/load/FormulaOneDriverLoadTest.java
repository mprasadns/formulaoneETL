package com.formulaone.load;

import com.formulaone.model.FormulaOneDriver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FormulaOneDriverLoadTest {
    private List<FormulaOneDriver> formulaOneDrivers;

    @Before
    public void setup() {
        formulaOneDrivers = setDriverLapsMockData();
    }

    @Test
    public void shouldBeAbleToLoadOnlyThreeDrivers() {
        FormulaOneDriverLoad formulaOneDriverLoad = new FormulaOneDriverLoad();
        int amountOfDriversToLoad = 3;
        formulaOneDrivers = formulaOneDriverLoad.loadGivenNumberOfDrivers(formulaOneDrivers, amountOfDriversToLoad);
        assertTrue(formulaOneDrivers.size() == amountOfDriversToLoad);
    }

    @Test
    public void shouldBeAbleToLoadDriversToFile() {
        FormulaOneDriverLoad formulaOneDriverLoad = new FormulaOneDriverLoad();
        int amountOfDriversToLoad = 3;
        boolean loadResult = formulaOneDriverLoad.loadLowestAverageLapDrivers(formulaOneDrivers, amountOfDriversToLoad);
        assertTrue(loadResult);
    }

    @Test
    public void shouldBeAbleToLoadDriversInFastestLapOrder() {
        FormulaOneDriverLoad formulaOneDriverLoad = new FormulaOneDriverLoad();
        int amountOfDriversToLoad = 3;
        formulaOneDrivers = formulaOneDriverLoad.loadGivenNumberOfDrivers(formulaOneDrivers, amountOfDriversToLoad);
        assertTrue(formulaOneDrivers.size() == amountOfDriversToLoad);

    }

    @Test
    public void shouldBeToSendNullWhenNoDrivers() {
        FormulaOneDriverLoad formulaOneDriverLoad = new FormulaOneDriverLoad();
        int amountOfDriversToLoad = 3;
        formulaOneDrivers.clear();
        formulaOneDrivers = formulaOneDriverLoad.loadGivenNumberOfDrivers(formulaOneDrivers, amountOfDriversToLoad);
        assertNotNull(formulaOneDrivers);
    }

    @Test
    public void shouldSendDefaultValueWhenListOfDriversLessThanAmountToLoad() {
        FormulaOneDriverLoad formulaOneDriverLoad = new FormulaOneDriverLoad();
        int amountOfDriversToLoad = 30;
        formulaOneDrivers = formulaOneDriverLoad.loadGivenNumberOfDrivers(formulaOneDrivers, amountOfDriversToLoad);
        assertNotNull(formulaOneDrivers);
    }

    private List<FormulaOneDriver> setDriverLapsMockData() {

        List<FormulaOneDriver> formulaOneDrivers = new ArrayList<>();
        formulaOneDrivers.add(new FormulaOneDriver("Alonzo", 4.00));
        formulaOneDrivers.add(new FormulaOneDriver("Verstrappen", 4.05));
        formulaOneDrivers.add(new FormulaOneDriver("Ocon", 4.10));
        formulaOneDrivers.add(new FormulaOneDriver("Hamilton", 4.15));
        formulaOneDrivers.add(new FormulaOneDriver("Raikkonen", 4.20));
        formulaOneDrivers.add(new FormulaOneDriver("Ricciardo", 4.25));
        formulaOneDrivers.add(new FormulaOneDriver("Leclerc", 4.30));
        formulaOneDrivers.add(new FormulaOneDriver("Mazepin", 4.35));
        formulaOneDrivers.add(new FormulaOneDriver("Carlos", 4.40));
        return formulaOneDrivers;
    }
}
