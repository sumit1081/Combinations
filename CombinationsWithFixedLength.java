import java.io.*;
import java.util.*;

public class CombinationsWithFixedLength {
    static ArrayList<ArrayList<Integer>> result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        result = new ArrayList<>();
        getAllDistinctCombinations(arr, 0, new ArrayList<Integer>(), k);
        printResult(result);
    }

    public static void getAllDistinctCombinations(int[] arr, int index, ArrayList<Integer> curr, int k) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        if (index == arr.length)
            return;
        for (int i = index; i <= arr.length - k; i++) {
            curr.add(arr[i]);
            getAllDistinctCombinations(arr, i + 1, curr, k - 1);
            curr.remove(curr.size() - 1);
            while (i < arr.length - 1 && arr[i] == arr[i + 1])
                i++;
        }
    }

    public static void printResult(ArrayList<ArrayList<Integer>> res) {
        for (ArrayList<Integer> line : res) {
            for (Integer element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}