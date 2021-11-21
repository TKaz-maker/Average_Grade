package pl.home;

import java.util.HashSet;

public class TheClass {

    private HashSet<String> classes;
    private String bestClass;
    private double bestAverage;

    public TheClass(double bestAverage,String bestClass) {
        this.bestClass = bestClass;
        this.bestAverage = bestAverage;
    }

    @Override
    public String toString() {
        return "Class with the highest average is: " + "\'" + bestClass + "\'" + " with result of " + bestAverage;
    }
}
