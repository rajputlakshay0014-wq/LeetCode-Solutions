class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        backtrack(0, nums, new ArrayList<>());

        return result;
    }

    private void backtrack(int start,
                           int[] nums,
                           List<Integer> current) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            backtrack(i + 1, nums, current);

            current.remove(current.size() - 1);
        }
    }
}