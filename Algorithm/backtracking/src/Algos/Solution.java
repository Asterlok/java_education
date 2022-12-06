package Algos;

import java.util.*;

class Alko_rhythm {
    int counter; // counter of iterations

    public List<List<Integer>> targetSum(int[] arrNums, int target) {
        Arrays.sort(arrNums);
        List<List<Integer>> result = new ArrayList<>();
        counter = 0;
        backtrack(result, new ArrayList<Integer>(), arrNums, target, 0);
        System.out.println("Counter: " + counter + "\tSize of array: " + arrNums.length);
        return result;
    }

    public void backtrack(List<List<Integer>> res, ArrayList<Integer> current, int[] sortArrNums, int targetSum, int start) {
        ++counter;
        if (targetSum == 0) {
            res.add(new ArrayList<>(current));
            return;
        }  // base case recursion exit

        for (int i = start; i < sortArrNums.length; i++) {
            current.add(sortArrNums[i]);
            backtrack(res, current, sortArrNums, targetSum - sortArrNums[i], i + 1);
            current.remove(current.size() - 1);
        }
    }
}