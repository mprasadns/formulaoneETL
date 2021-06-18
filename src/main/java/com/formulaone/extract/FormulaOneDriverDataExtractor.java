package com.formulaone.extract;

import com.formulaone.model.FormulaOneDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FormulaOneDriverDataExtractor {

    public List<FormulaOneDriver> extractFormulaOneDrivers(String fileLocation) throws IOException {

        Path path = validateFileLocation(fileLocation);

        return Files.lines(path)
                .map(FormulaOneDriverDataExtractor::lineToFormulaOneDriver)
                .collect(Collectors.toList());
    }

    private Path validateFileLocation(String fileLocation) throws IOException {
        String PROGRAM_DIRECTORY = getResourceDirector();
        fileLocation = (fileLocation != null && !fileLocation.isEmpty()) ? fileLocation : PROGRAM_DIRECTORY + "files/defaultFormulaDriver.csv";
        Path path = Path.of(fileLocation);
        if(!Files.exists(path)) {
            throw new IOException("File not found in the location: " + fileLocation);
        }
        return path;
    }

    private static FormulaOneDriver lineToFormulaOneDriver(String line) {
        String[] elements = line.split(",");
        String driverName = elements[0];
        double lap = Double.parseDouble(elements[1]);
        return (new FormulaOneDriver(driverName, lap));
    }

    private String getResourceDirector() {
         String PROGRAM_DIRECTORY;
        try {
            PROGRAM_DIRECTORY = getClass().getClassLoader().getResource("FormulaOneETL.class").getPath();
            //Find the last ! and cut it off at that location. If this isn't being run from a jar, there is no !, so it'll cause an exception, which is fine.
            try {
                PROGRAM_DIRECTORY = PROGRAM_DIRECTORY.substring(0, PROGRAM_DIRECTORY.lastIndexOf('!'));
            } catch (Exception e) { }

            //Find the last / and cut it off at that location.
            PROGRAM_DIRECTORY = PROGRAM_DIRECTORY.substring(0, PROGRAM_DIRECTORY.lastIndexOf('/') + 1);
            //If it starts with /, cut it off.
            if (PROGRAM_DIRECTORY.startsWith("/")) PROGRAM_DIRECTORY = PROGRAM_DIRECTORY.substring(1, PROGRAM_DIRECTORY.length());
            //If it starts with file:/, cut that off, too.
            if (PROGRAM_DIRECTORY.startsWith("file:/")) PROGRAM_DIRECTORY = PROGRAM_DIRECTORY.substring(6, PROGRAM_DIRECTORY.length());
        } catch (Exception e) {
            PROGRAM_DIRECTORY = ""; //Current working directory instead.
        }
        PROGRAM_DIRECTORY = "/" + PROGRAM_DIRECTORY;
        return  PROGRAM_DIRECTORY;
    }
}
