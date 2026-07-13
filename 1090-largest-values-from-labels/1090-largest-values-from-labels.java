import java.util.*;

class Solution {
    public int largestValsFromLabels(
        int[] values,
        int[] labels,
        int numWanted,
        int useLimit
    ) {
        int n = values.length;

        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }

        Arrays.sort(items, (a, b) -> Integer.compare(b[0], a[0]));

        HashMap<Integer, Integer> frequency = new HashMap<>();

        int sum = 0;
        int selected = 0;

        for (int[] item : items) {
            int value = item[0];
            int label = item[1];

            int count = frequency.getOrDefault(label, 0);

            if (count < useLimit) {
                sum += value;

                frequency.put(label, count + 1);

                selected++;

                if (selected == numWanted) {
                    break;
                }
            }
        }

        return sum;
    }
}