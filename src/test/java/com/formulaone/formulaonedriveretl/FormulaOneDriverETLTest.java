package com.formulaone.formulaonedriveretl;

import com.formulaone.model.FormulaOneDriver;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FormulaOneDriverETLTest {
    String outputFileLocation = "output.csv";
    String inputFileLocation = "src/main/resources/files/FormulaDriverList.csv";

    @Test
    public void shouldBeAbleToTransformDataIntoAFile() throws IOException {
        FormulaOneDriverETL formulaOneETL = new FormulaOneDriverETL();
        assertTrue(formulaOneETL.loadFastestLapDrivers(inputFileLocation, 3));
        assertTrue(validateFileExists());
    }

    @Test
    public void shouldBeAbleToLoadContentsInsideTheFile() throws IOException {
        FormulaOneDriverETL formulaOneETL = new FormulaOneDriverETL();
        String fileLocation = "src/main/resources/files/FormulaDriverList.csv";
        assertTrue(formulaOneETL.loadFastestLapDrivers(fileLocation, 3));
        assertTrue(loadOutputFile().size() > 0);
    }

    @Test
    public void shouldBeAbleToLoadContentsInAscendingOrder() throws IOException {
        FormulaOneDriverETL formulaOneETL = new FormulaOneDriverETL();
        String fileLocation = "src/main/resources/files/FormulaDriverList.csv";
        assertTrue(formulaOneETL.loadFastestLapDrivers(fileLocation, 3));
        List<FormulaOneDriver> driverLapsList = loadOutputFile();
        assertNotNull(driverLapsList.size() > 0);
        assertThat(driverLapsList, contains(allOf(hasProperty("name", is("Alonzo")),
                hasProperty("lap", is(4.53))),
                allOf(hasProperty("name", is("Hamilton")),
                        hasProperty("lap", is(4.56))),
                allOf(hasProperty("name", is("Verstrappen")),
                        hasProperty("lap", is(4.63)))
        ));
    }

    private boolean validateFileExists() throws IOException {
        Path path = Path.of(outputFileLocation);
        if(Files.exists(path)) {
            return true;
        }
        return false;
    }

    private List<FormulaOneDriver> loadOutputFile() throws IOException {
        Path path = Path.of(outputFileLocation);
        return Files.lines(path)
                .map(FormulaOneDriverETLTest::lineToFormulaOneDriver)
                .collect(Collectors.toList());
    }

    private static FormulaOneDriver lineToFormulaOneDriver(String line) {
        String[] elements = line.split(",");
        String driverName = elements[0];
        double lap = Double.parseDouble(elements[1]);
        return (new FormulaOneDriver(driverName, lap));
    }
}
