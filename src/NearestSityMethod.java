import com.sun.jdi.IntegerValue;

import java.util.*;
public class NearestSityMethod {

    private int[][] matrix;
    ArrayList<Integer> X;
    ArrayList<Integer> S;
    private int pathLength;

    public NearestSityMethod(int[][] matrix){
        this.matrix = matrix;
        X = new ArrayList<>();
        S = new ArrayList<>();
        pathLength = 0;
    }

    public ArrayList<Integer> searchMinPath() {
        for (int i = 0; i < matrix.length; i++){
            X.add(i);
        }
        int step = 0;
        int firstCity = (int) (Math.random()*matrix.length);
        S.add(X.remove(firstCity));
        System.out.println("First city:" + firstCity);
        ArrayList<Integer> vertex = new ArrayList<>(Arrays.asList(0,0));
        while(X.size()>0) {
            System.out.println("Step number: "+ ++step);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < S.size(); i++) {
                for (int j = 0; j < X.size(); j++) {
                    if (matrix[S.get(i)][X.get(j)] < min) {
                        min = matrix[S.get(i)][X.get(j)];
                        vertex.set(0, S.get(i));
                        vertex.set(1, X.get(j));
                    }
                }
            }
            S.add(S.indexOf(vertex.get(0))+1, vertex.get(1));
            pathLength = 0;
            for (int i=0; i<S.size()-1;i++){
                pathLength += matrix[S.get(i)][S.get(i+1)];
            }
            System.out.println("Chosen city: "+ vertex.get(1) + "\nCurrent path : "+ S + "\nCurrent path's length "+ pathLength);
            System.out.println("___________________");
            X.remove(X.indexOf(vertex.get(1)));
        }
        pathLength += matrix[S.get(S.size()-1)][S.get(0)];
        System.out.println("Final path's length: "+pathLength);
        return S;
    }

}
