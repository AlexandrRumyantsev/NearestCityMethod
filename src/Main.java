public class Main {
    public static int[][] matrix = {{0, 6, 5, 9, 5},
                                    {6, 0, 7, 4, 6},
                                    {5, 7, 0, 10, 3},
                                    {9, 4, 10, 0, 8},
                                    {5, 6, 3, 8, 0}};
    public static void main(String[] args){

        NearestSityMethod test = new NearestSityMethod(matrix);
        System.out.println(test.searchMinPath());

    }
}
