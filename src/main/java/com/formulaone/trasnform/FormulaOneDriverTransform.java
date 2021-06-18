package com.formulaone.trasnform;

import com.formulaone.model.FormulaOneDriver;

import java.util.*;
import java.util.stream.Collectors;

public class FormulaOneDriverTransform {
    public List<FormulaOneDriver> getAverageLaps(List<FormulaOneDriver> formulaOneDrivers) {

        List<FormulaOneDriver> averageLapsDrivers = getAverageLapsForDriver(formulaOneDrivers);
        averageLapsDrivers = getDriverListSortedInAscendingOrder(averageLapsDrivers);
        return averageLapsDrivers;
    }

    private List<FormulaOneDriver> getAverageLapsForDriver(List<FormulaOneDriver> formulaOneDrivers) {

        List<FormulaOneDriver> averageLapDrivers = new ArrayList<>();

        Map<String, Double> driverAverageLaps = formulaOneDrivers
                .stream()
                .collect(
                        Collectors.groupingBy(
                                FormulaOneDriver::getName,
                                TreeMap::new,
                                Collectors.averagingDouble(FormulaOneDriver::getLap))
                );

        for(Map.Entry<String, Double> driverAverageLap: driverAverageLaps.entrySet()) {
            double round = Math.round(driverAverageLap.getValue() * 100.0);
            averageLapDrivers.add(new FormulaOneDriver(driverAverageLap.getKey(), round/100));
        }

        return averageLapDrivers;
    }

    private List<FormulaOneDriver> getDriverListSortedInAscendingOrder(List<FormulaOneDriver> formulaOneDrivers) {
        return formulaOneDrivers
                .stream()
                .sorted(Comparator.comparingDouble(FormulaOneDriver::getLap))
                .collect(Collectors.toList());
    }
}
