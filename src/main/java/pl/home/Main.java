package pl.home;

import java.io.File;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

        File file = new File(Main.class.getResource("/grades.txt").toURI());
        Calculate calculate = new Calculate();
        TheClass theBestClass = new TheClass(
                calculate.bestAverageGrade(file),
                calculate.bestClass(file));
        System.out.println(theBestClass);
    }
}
