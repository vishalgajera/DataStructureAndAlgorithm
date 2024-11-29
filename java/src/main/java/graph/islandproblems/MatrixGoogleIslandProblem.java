package graph.islandproblems;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixGoogleIslandProblem {

    public int countValidLake(int[][] matrix, int inputX, int inputY) {
        if (matrix[inputX][inputY] == 0) return 0; // Assumption : User always click on '1' otherwise return 0
        boolean[][] dfsVisited = new boolean[matrix.length][matrix[0].length];

        Queue<int[]> queue = new LinkedList<>();

        // phase 1 (Optimized): find all '0' cells which are nearer or reachable from the clicked cell. so that we can consider only those cells into our further calculation
        dfs(matrix, inputX, inputY, queue, dfsVisited);


        // phase 2: for the above calculated '0' cells - check(with the help of DFS technique) whether '0' is surrounded by '1' if yes -> it's our answer!
        int ans = 0;
        dfsVisited = new boolean[matrix.length][matrix[0].length]; // reset for the phase-2...
        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            // check if this '0' is not already visited & part of the rectangle which is surrounded by '1' then increment the answer by 1
            if (!dfsVisited[point[0]][point[1]] && isPartOfValidLake(matrix, point[0], point[1], dfsVisited)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isPartOfValidLake(int[][] matrix, int x, int y, boolean[][] visited) {

        if (!isValidMove(matrix, x,y)) {
            return false;
        // condition-1: ignore the cell if the cell value is '0' & it's reachable from the border cell of the given input matrix
        } else if ((x == 0 || x == matrix.length - 1 || y == 0 || y == matrix[0].length - 1) && matrix[x][y] == 0) {
            visited[x][y] = true;
            return false;
        } else if (visited[x][y] && matrix[x][y] == -1) {  // if already visited & its result consider as FALSE/Invalid = consider it as failure
            return false;
        } else if (visited[x][y]) { // if already visited & it's "valid" since in-valid we've already checked above = consider it as "safe" to consider for success
            return true;
        }
        visited[x][y] = true;

        // condition-2: during DFS search if we found '1' then return from there with the consideration that all the path cell reached till '1' are 'valid'
        if (matrix[x][y] == 1) {
            return true;
        }

        boolean lowerRowCell = isPartOfValidLake(matrix, x+1,y, visited);
        boolean upperRowCell = lowerRowCell && isPartOfValidLake(matrix, x-1,y, visited); // if all above results are true then only go for this check
        boolean rightColCell = upperRowCell && isPartOfValidLake(matrix, x,y+1, visited); // if all above results are true then only go for this check
        boolean leftColCell = rightColCell && isPartOfValidLake(matrix, x,y-1, visited); // if all above results are true then only go for this check

        boolean upperLeftColCell = leftColCell && isPartOfValidLake(matrix, x-1,y-1, visited); // if all above results are true then only go for this check
        boolean upperRightColCell = upperLeftColCell && isPartOfValidLake(matrix, x-1,y+1, visited); // if all above results are true then only go for this check
        boolean lowerLeftColCell = upperRightColCell && isPartOfValidLake(matrix, x+1,y-1, visited); // if all above results are true then only go for this check
        boolean lowerRightColCell = lowerLeftColCell && isPartOfValidLake(matrix, x+1,y+1, visited); // if all above results are true then only go for this check

        // all 8-direction result is true --> it means, current cell ('0') is surrounded by '1' or qualify for good candidate of our final answer
        boolean finalResult = lowerRowCell && upperRowCell && rightColCell && leftColCell && upperLeftColCell && upperRightColCell && lowerLeftColCell && lowerRightColCell;
        if (!finalResult) {
            matrix[x][y] = -1;
        }
        return finalResult;
    }

    public void dfs(int[][] matrix, int i, int j, Queue<int[]> queue, boolean[][] dfsVisited) {
        if (isValidMove(matrix, i,j)) {
            if (matrix[i][j] == 1 && !dfsVisited[i][j]) {
                dfsVisited[i][j] = true;
                dfs(matrix, i+1, j, queue, dfsVisited);
                dfs(matrix, i-1, j, queue, dfsVisited);
                dfs(matrix, i, j+1, queue, dfsVisited);
                dfs(matrix, i, j-1, queue, dfsVisited);
            } else if (matrix[i][j] == 0) {
                if (!dfsVisited[i][j]) {
                    queue.add(new int[] {i, j});
                    dfsVisited[i][j] = true;
                }
            }
        }
    }

    private boolean isValidMove(int[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
