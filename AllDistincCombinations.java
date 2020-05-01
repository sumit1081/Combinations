import java.io.*;
import java.util.*;

public class AllDistincCombinations {
    static ArrayList<ArrayList<Integer>> result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        result = new ArrayList<>();
        getAllDistinctCombinations(arr, 0, new ArrayList<Integer>());
        sortAndPrintResult(result);
    }

    public static void getAllDistinctCombinations(int[] arr, int index, ArrayList<Integer> curr) {
        if (index == arr.length) {
            if (curr.size() > 0)
                result.add(new ArrayList<Integer>(curr));
            return;
        }
        curr.add(arr[index]);
        getAllDistinctCombinations(arr, index + 1, curr);
        curr.remove(curr.size() - 1);

        while (index < arr.length - 1 && arr[index] == arr[index + 1])
            index++;
        getAllDistinctCombinations(arr, index + 1, curr);
    }

    public static void sortAndPrintResult(ArrayList<ArrayList<Integer>> res) {
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> first, ArrayList<Integer> second) {
                int size1 = first.size();
                int size2 = second.size();
                int index1 = 0, index2 = 0;
                while (index1 < size1 && index2 < size2) {
                    if (first.get(index1) != second.get(index2)) {
                        return first.get(index1) - second.get(index2);
                    } else {
                        index1++;
                        index2++;
                    }
                }
                return size1 - size2;
            }
        });
        for (ArrayList<Integer> line : res) {
            for (Integer element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}