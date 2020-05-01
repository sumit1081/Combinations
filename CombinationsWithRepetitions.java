import java.io.*;
import java.util.*;

public class CombinationsWithRepetition {
    static ArrayList<ArrayList<Integer>> result;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        result = new ArrayList<>();
        getAllDistinctCombinations(arr,0,new ArrayList<Integer>(),k);
        sortAndPrintResult(result);
    }
    public static void getAllDistinctCombinations(int [] arr, int index, ArrayList<Integer> curr,int k)     {
        if(k==0){
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        if(index==arr.length)
            return;
        for(int i = index;i<arr.length;i++){
            curr.add(arr[i]);
            getAllDistinctCombinations(arr,i,curr,k-1);
            curr.remove(curr.size()-1);
            while(i<arr.length-1 && arr[i]==arr[i+1])
                i++;
        } 
    }
    
    public static void sortAndPrintResult(ArrayList<ArrayList<Integer>> res){
        Collections.sort(res,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> first, ArrayList<Integer> second){
                int size1 = first.size();
                int size2 = second.size();
                int index1 = 0, index2 = 0;
                while(index1<size1 && index2<size2){
                    if(first.get(index1)!=second.get(index2)){
                        return first.get(index1)-second.get(index2);
                    }else{
                        index1++;
                        index2++;
                    }
                }
                return size1-size2;
            }
        });
        for(ArrayList<Integer> line:res){
            for(Integer element:line){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}