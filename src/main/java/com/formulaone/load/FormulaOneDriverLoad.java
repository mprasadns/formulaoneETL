package com.formulaone.load;

import com.formulaone.model.FormulaOneDriver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FormulaOneDriverLoad {
    public boolean loadLowestAverageLapDrivers(List<FormulaOneDriver> formulaOneDrivers, int amountOfDriversToLoad) {

        final List<FormulaOneDriver> formulaOneDriversList = loadGivenNumberOfDrivers(formulaOneDrivers, amountOfDriversToLoad);

        return loadDriversToFile(formulaOneDriversList);
    }

    public List<FormulaOneDriver> loadGivenNumberOfDrivers(List<FormulaOneDriver> formulaOneDrivers, int amountOfDriversToLoad) {

        amountOfDriversToLoad = (amountOfDriversToLoad > 0) ? amountOfDriversToLoad : 3;
        amountOfDriversToLoad = Math.min(formulaOneDrivers.size(), amountOfDriversToLoad);

        if(formulaOneDrivers.size() >= amountOfDriversToLoad) {
            return formulaOneDrivers.subList(0, amountOfDriversToLoad);
        }
        return null;
    }

    private boolean loadDriversToFile(List<FormulaOneDriver> formulaOneDrivers) {
        if(formulaOneDrivers == null)
            return false;
        Path path = Path.of("output.csv");

        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path)){
            for(FormulaOneDriver formulaOneDriver: formulaOneDrivers) {
                String line = formulaOneDriver.getName() + "," + formulaOneDriver.getLap() + "\n";
                bufferedWriter.write(line);
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
            return false;
        }

        return true;
    }
}
