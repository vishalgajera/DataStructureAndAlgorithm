import graph.islandproblems.MatrixGoogleIslandProblem;
import org.junit.Assert;
import org.junit.Test;

public class MatrixGoogleIslandProblemTest {

    MatrixGoogleIslandProblem matrixObject = new MatrixGoogleIslandProblem();

    @Test
    public void testScenarioMatrix() {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int expectedResult = 1;
        Assert.assertEquals("Use Case Failed", expectedResult, matrixObject.countValidLake(matrix, 0, 0));
    }

    @Test
    public void testScenario0Matrix() {
        int[][] matrix = {{1,1,1},{1,1,1},{1,1,1}};
        int expectedResult = 0;
        Assert.assertEquals("Use Case-0 Failed", expectedResult, matrixObject.countValidLake(matrix, 0, 0));
    }

    @Test
    public void testScenario1Matrix() {
        int[][] matrix = {
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,1},
                {0,1,1,1,1,0,0},
                {0,1,0,0,1,0,0},
                {0,1,0,0,1,0,0},
                {0,1,0,0,1,0,0},
                {0,1,1,1,1,0,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0}
        };
        int expectedResult = 1;
        Assert.assertEquals("Use Case-1 Failed", expectedResult, matrixObject.countValidLake(matrix, 3, 1));
    }

    @Test
    public void testScenario2Matrix() {
        int[][] matrix = {
                {0,0,0,0,0,0,1,0,0,1},
                {0,0,0,0,0,0,1,0,0,1},
                {0,1,1,1,1,0,0,0,0,1},
                {0,1,0,0,1,0,0,0,0,1},
                {0,1,0,0,1,0,0,0,0,0},
                {0,1,0,0,1,0,0,0,0,0},
                {0,1,0,0,1,0,1,0,1,0},
                {0,1,1,0,1,0,1,0,1,0},
                {0,0,0,0,0,0,1,0,1,0},
                {0,0,0,0,0,0,1,1,1,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,0,0,0,0,0},
                {0,0,1,0,1,0,0,0,0,0},
                {0,0,1,0,1,0,0,0,0,0}
        };
        int expectedResult = 0;
        Assert.assertEquals("Use Case-2 Failed", expectedResult, matrixObject.countValidLake(matrix, 7, 2));
    }

    @Test
    public void testScenario3Matrix() {
        int[][] matrix = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,0,0,1,0,0,0,0,1},
                {0,1,0,0,1,0,0,0,0,1},
                {0,1,0,0,1,0,0,0,0,1},
                {0,1,0,0,1,0,0,0,0,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };
        int expectedResult = 2;
        Assert.assertEquals("Use Case-3 Failed", expectedResult, matrixObject.countValidLake(matrix, 4, 1));
    }

    @Test
    public void testScenario4Matrix() {
        int[][] matrix = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,0,0,1,0,0,0,0,1},
                {0,1,0,0,1,0,0,0,0,1},
                {0,1,0,0,0,0,0,0,0,1},
                {0,1,0,0,1,0,0,0,0,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };
        int expectedResult = 1;
        Assert.assertEquals("Use Case-4 Failed", expectedResult, matrixObject.countValidLake(matrix, 4, 1));
    }

    @Test
    public void testScenario5Matrix() {
        int[][] matrix = {
                {0,0,0,0,0,0,0,1,1,1,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,1,1,1,1,0,0,0,0,0,0,0,1},
                {0,1,0,0,1,0,0,0,0,0,0,0,1},
                {0,1,0,0,1,0,0,1,1,1,0,0,0},
                {0,1,0,0,1,0,0,1,0,1,0,0,0},
                {0,1,0,0,1,0,0,1,0,1,0,0,0},
                {0,1,1,1,1,0,0,1,0,1,0,0,0},
                {0,0,0,0,0,0,0,1,0,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,0,1,0,0,0},
                {0,0,1,1,1,0,0,1,0,1,0,0,0},
                {0,0,1,0,1,0,0,1,1,1,0,0,0},
                {0,0,1,0,1,0,0,1,0,1,0,0,0},
                {0,0,1,0,1,0,0,1,0,1,0,0,0},
                {0,0,1,0,1,0,0,1,0,1,0,0,0},
                {0,0,1,1,1,0,0,1,1,1,0,1,1}
        };
        int expectedResult = 1;
        Assert.assertEquals("Use Case-5 Scenario-1 Failed", expectedResult, matrixObject.countValidLake(matrix, 4, 1));

        expectedResult = 0;
        Assert.assertEquals("Use Case-5 Scenario-2 Failed", expectedResult, matrixObject.countValidLake(matrix, 0, 9));
        Assert.assertEquals("Use Case-5 Scenario-3 Failed", expectedResult, matrixObject.countValidLake(matrix, 0, 12));
        Assert.assertEquals("Use Case-5 Scenario-4 Failed", expectedResult, matrixObject.countValidLake(matrix, 16, 12));

        expectedResult = 3;
        Assert.assertEquals("Use Case-5 Scenario-5 Failed", expectedResult, matrixObject.countValidLake(matrix, 10, 7));

        expectedResult = 1;
        Assert.assertEquals("Use Case-5 Scenario-6 Failed", expectedResult, matrixObject.countValidLake(matrix, 15, 2));
    }
}
