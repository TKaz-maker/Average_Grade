package pl.home;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Calculate {

    static HashSet<String> listOfCalsess(File file) {
        HashSet<String> listOfClasses = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String newline;
            while ((newline = br.readLine()) != null) {
                for (String value : newline.split(";")) {
                    if (value.matches("[0-9]+[a-zA-Z]")) {
                        listOfClasses.add(value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfClasses;
    }

    double bestAverageGrade(File file) {
        double topAverage = 0;
        String topClass = "";
        for (String tempClass : Calculate.listOfCalsess(file)) {
            double tempAverage = 0;
            List<Double> tempListOfNotes = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String newline;
                while ((newline = br.readLine()) != null) {
                    String[] tempArray = newline.split(";");
                    for (String value : tempArray) {
                        if (tempClass.equals(value)) {
                            for (String aGrade : tempArray) {
                                if (aGrade.matches("[0-9](\\.[0-9]*)?"))
                                    tempListOfNotes.add(Double.parseDouble(aGrade));
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (double aGrade : tempListOfNotes) {
                tempAverage += aGrade;
            }
            tempAverage /= tempListOfNotes.size();

            if (tempAverage > topAverage) {
                topClass.equals(tempClass);
                topAverage = tempAverage;
            }
        }
        return topAverage;
    }

    String bestClass(File file) {
        double topAverage = 0;
        String topClass = "";
        for (String tempClass : Calculate.listOfCalsess(file)) {
            double tempAverage = 0;
            List<Double> tempListOfGrades = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String newline;
                while ((newline = br.readLine()) != null) {
                    String[] tempArray = newline.split(";");
                    for (String value : tempArray) {
                        if (tempClass.equals(value)) {
                            for (String aGrade : tempArray) {
                                if (aGrade.matches("[0-9](\\.[0-9]*)?"))
                                    tempListOfGrades.add(Double.parseDouble(aGrade));
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (double aGrade : tempListOfGrades) {
                tempAverage += aGrade;
            }
            tempAverage /= tempListOfGrades.size();

            if (tempAverage > topAverage) {
                topAverage = tempAverage;
                topClass = tempClass;
            }
        }
        return topClass;
    }
}
