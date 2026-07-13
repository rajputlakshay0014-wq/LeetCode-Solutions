class Solution {
    public double[] sampleStats(int[] count) {
        int minimum = -1;
        int maximum = -1;
        int mode = 0;

        long totalCount = 0;
        long totalSum = 0;

        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (minimum == -1) {
                    minimum = i;
                }

                maximum = i;

                totalCount += count[i];
                totalSum += (long) i * count[i];

                if (count[i] > count[mode]) {
                    mode = i;
                }
            }
        }

        double mean = (double) totalSum / totalCount;

        long firstMiddle = (totalCount + 1) / 2;
        long secondMiddle = (totalCount + 2) / 2;

        int firstValue = 0;
        int secondValue = 0;

        long currentCount = 0;

        for (int i = 0; i < 256; i++) {
            currentCount += count[i];

            if (currentCount >= firstMiddle && firstValue == 0) {
                firstValue = i;
            }

            if (currentCount >= secondMiddle) {
                secondValue = i;
                break;
            }
        }

        double median = (firstValue + secondValue) / 2.0;

        return new double[]{
            minimum,
            maximum,
            mean,
            median,
            mode
        };
    }
}