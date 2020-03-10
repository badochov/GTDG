import java.util.Vector;
import java.util.Iterator;

class Sum {
    static public int sum(Vector<Integer> nums) {
        int res = 0;
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            res += it.next();
        }
        return res;
    }

    static public Vector<Integer> getInts(String s) {
        Vector<Integer> ints = new Vector<Integer>();
        s = s.concat(" ");
        char[] c = s.toCharArray();
        int start = -1;
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                if (start == -1) {
                    start = i;
                }
            } else {
                if (start != -1) {
                    ints.add(Integer.parseInt(s.substring(start, i)));
                    start = -1;
                }
            }
        }

        return ints;

    }

    static public int sumNumbers(String s) {
        return sum(getInts(s));
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers("11a33"));
    }
}