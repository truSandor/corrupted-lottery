package org.example.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LotteryTicketGenerator {
    private final Random random = new Random();

    public int[] generateLotteryTicket(int howMany, int upTo) {
        int[] lotteryTicket = new int[howMany];
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 1; i <= upTo; i++) {
            allNumbers.add(i);
        }
        for (int i = 0; i < howMany; i++) {
            int randomIndex = random.nextInt(allNumbers.size());
            lotteryTicket[i] = allNumbers.get(randomIndex);
            allNumbers.remove(randomIndex);

        }
        return Arrays.stream(lotteryTicket).sorted().toArray();
    }

    public List<List<Integer>> generateCombinations(int howMany, int upTo) {
        List<List<Integer>> combinations = new ArrayList<>();
        int[] arr = getNumbers(upTo);
        backtrack(combinations, new ArrayList<>(), arr, howMany, 0);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> temp, int[] arr, int n, int start) {
        if (temp.size() == n) {
            combinations.add(new ArrayList<>(temp));  // Found a valid combination
            return;
        }
        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            backtrack(combinations, temp, arr, n, i + 1);  // Recursive call with next index
            temp.remove(temp.size() - 1);  // Undo the choice
        }
    }

    private int[] getNumbers(int upTo) {
        int[] arr = new int[upTo];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

}
