package pl.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;

class CalculateTest {

    private HashSet<String> classes;
    private String bestClass;
    private double bestAverage;
    File moreGrades;
    File classesInRandomPlace;
    File gradesInRandomPlace;
    File originalGrades;

    @BeforeEach
    void setUpFiles() throws URISyntaxException {
        this.moreGrades = new File(Calculate.class.getResource("/moreGradesTest.txt").toURI());
        this.classesInRandomPlace = new File(Calculate.class.getResource("/classesInRandomPlace.txt").toURI());
        this.gradesInRandomPlace = new File(Calculate.class.getResource("/gradesInRandomPlace.txt").toURI());
    }

    @Test
    @DisplayName("Calculate the highest average and the class when there is more grades is in the file")
    void calculate1() throws IOException {
//        given
        Calculate calculate = new Calculate();

//        when
        this.classes = Calculate.listOfCalsess(moreGrades);
        this.bestAverage= calculate.bestAverageGrade(moreGrades);
        this.bestClass =calculate.bestClass(moreGrades);

//        then
        Assertions.assertEquals(4.428571428571429, bestAverage);
        Assertions.assertEquals("3C", bestClass);
    }

    @Test
    @DisplayName("Calculate the highest average and best class when classes are in a random place in the file")
    void calculate2() {
//        given
        Calculate calculate = new Calculate();

//        when
        this.classes = Calculate.listOfCalsess(classesInRandomPlace);
        this.bestAverage= calculate.bestAverageGrade(classesInRandomPlace);
        this.bestClass =calculate.bestClass(classesInRandomPlace);

//        then
        Assertions.assertEquals(4.083333333333333, bestAverage);
        Assertions.assertEquals("3A", bestClass);
    }

    @Test
    @DisplayName("Calculate the highest average and the best class when grades are in a random place in the file")
    void calculate3() {
//        given
        Calculate calculate = new Calculate();

//        when
        this.classes = Calculate.listOfCalsess(gradesInRandomPlace);
        this.bestAverage= calculate.bestAverageGrade(gradesInRandomPlace);
        this.bestClass =calculate.bestClass(gradesInRandomPlace);

//        then
        Assertions.assertEquals(4.083333333333333, bestAverage);
        Assertions.assertEquals("3A", bestClass);
    }
}