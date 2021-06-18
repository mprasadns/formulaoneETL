package com.formulaone.formulaonedriveretl;

import com.formulaone.extract.FormulaOneDriverDataExtractor;
import com.formulaone.load.FormulaOneDriverLoad;
import com.formulaone.model.FormulaOneDriver;
import com.formulaone.trasnform.FormulaOneDriverTransform;

import java.util.List;

public class FormulaOneDriverETL {
    public boolean loadFastestLapDrivers(String fileLocation, int amountOfDriversToLoad) {
        FormulaOneDriverDataExtractor formulaOneDriverDataExtractor = new FormulaOneDriverDataExtractor();
        FormulaOneDriverTransform driverLaps = new FormulaOneDriverTransform();
        FormulaOneDriverLoad formulaOneDriverLoad = new FormulaOneDriverLoad();

        try {
            List<FormulaOneDriver> formulaOneDrivers = formulaOneDriverDataExtractor.extractFormulaOneDrivers(fileLocation);
            if(formulaOneDrivers != null) {

                formulaOneDrivers = driverLaps.getAverageLaps(formulaOneDrivers);
                return formulaOneDriverLoad.loadLowestAverageLapDrivers(formulaOneDrivers, amountOfDriversToLoad);
            }
        }catch (Exception exception) {
            exception.printStackTrace();
        }

        return false;
    }
}
