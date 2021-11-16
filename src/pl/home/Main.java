package pl.home;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        File file = new File("grades.txt");
        HashSet<String> classes = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String newline;
            while ((newline = br.readLine()) != null) {
                for (String value : newline.split(";")) {
                    if (value.matches("[0-9]+[a-zA-Z]")) {
                        classes.add(value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String bestClass = "";
        double bestAverage = 0;
        for (String tempClass : classes) {
            double tempAverage = 0;
            List<Double> tempListOfNotes = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String newline;
                while ((newline = br.readLine()) != null) {
                    String[] tempArray = newline.split(";");
                    for (String value : tempArray) {
                        if (tempClass.equals(value)) {
                            for (int i = 3; i < tempArray.length; i++) {
                                tempListOfNotes.add(Double.parseDouble(tempArray[i]));
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (double classNote : tempListOfNotes) {
                tempAverage += classNote;
            }
            tempAverage /= tempListOfNotes.size();

            if (tempAverage > bestAverage){
                bestAverage = tempAverage;
                bestClass = tempClass;
            }
        }
        System.out.println("Class with the best average is: " + bestClass + " with the average of " + bestAverage);
    }
}
