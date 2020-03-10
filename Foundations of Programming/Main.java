import java.util.HashMap;

public class Main {
    static public int maxSpan(int[] nums) {
        HashMap<Integer, Integer[]> n = new HashMap<Integer, Integer[]>();
        for (int i = 0; i < nums.length; i++) {
            Integer[] c = n.get(nums[i]);
            if (c == null) {
                Integer[] h = { i, i };
                n.put(nums[i], h);
            } else {
                Integer[] h = { c[0], i };
                n.replace(nums[i], h);
            }
        }
        int biggest = 0;
        for (Integer[] el : n.values()) {
            System.out.printf("%d %d\n", el[0], el[1]);
            int curr = el[1] - el[0] + 1;
            if (curr > biggest) {
                biggest = curr;
            }
        }
        return biggest;
    }

    public static void main(String[] args) {
    }
}