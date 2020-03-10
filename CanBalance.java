class CanBalance {
    static public int[] reverse(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length / 2; i++) {
            res[i] = nums[nums.length - 1 - i];
            res[nums.length - 1 - i] = nums[i];
        }
        if (nums.length % 2 == 1) {
            res[nums.length / 2] = nums[nums.length / 2];
        }
        return res;
    }

    static public int[] postfixSums(int[] nums) {
        return reverse(prefixSums(reverse(nums)));
    }

    static public int[] prefixSums(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] += nums[i] + sums[i];
        }

        return sums;
    }

    static public boolean canBalance(int[] nums) {
        int[] pre = prefixSums(nums);
        int[] post = postfixSums(nums);
        // printArr(pre);
        // printArr(post);
        for (int i = 0; i < nums.length + 1; i++) {
            if (pre[i] > post[i]) {
                break;
            } else if (pre[i] == post[i]) {
                return true;
            }
        }
        return false;
    }

    static public void printArr(int nums[]) {
        for (int num : nums)
            System.out.printf("%d ", num);

        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 1, 1 };
        System.out.println(canBalance(a));
    }
}