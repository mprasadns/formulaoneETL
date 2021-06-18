package com.formulaone.extract;

import com.formulaone.model.FormulaOneDriver;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FormulaOneDriverExtractTest {
    @Test
    public void shouldBeAbleToExtractDefaultDataFileWhenBlankPathSent() throws IOException {
        FormulaOneDriverDataExtractor formulaOneDriverDataExtractor = new FormulaOneDriverDataExtractor();

        final List<FormulaOneDriver> formulaOneDriverList = formulaOneDriverDataExtractor.extractFormulaOneDrivers("");
        assertTrue(formulaOneDriverList.size() > 0);
    }

    @Test
    public void shouldBeAbleToExtractGivenFile() throws IOException {
        FormulaOneDriverDataExtractor formulaOneDriverDataExtractor = new FormulaOneDriverDataExtractor();

        final List<FormulaOneDriver> formulaOneDriverList = formulaOneDriverDataExtractor.extractFormulaOneDrivers("src/main/resources/files/FormulaDriverList.csv");
        assertTrue(formulaOneDriverList.size() > 0);
    }

    @Test(expected= IOException.class)
    public void shouldThrowIOExceptionIfFileNotFound() throws IOException {
        FormulaOneDriverDataExtractor formulaOneDriverDataExtractor = new FormulaOneDriverDataExtractor();
        formulaOneDriverDataExtractor.extractFormulaOneDrivers("wrogfilelocation");
    }
}
