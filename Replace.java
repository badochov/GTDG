class Replace {
    static public String withoutString(String base, String remove) {
        return KMP(base, remove, "");
    }

    static public String KMP(String s, String pattern, String replace) {
        int[] p = pref(pattern);
        char[] c = s.toCharArray();
        char[] pA = pattern.toCharArray();
        int j = 0;
        for (int i = 0; i <= c.length - pattern.length(); i++) {
            j = p[j];
            while (j < pattern.length() && Character.toLowerCase(pA[j]) == Character.toLowerCase(c[i + j])) {
                j++;
            }
            if (j == pattern.length()) {
                s = s.substring(0, i).concat(replace).concat(s.substring(i + j));
                c = s.toCharArray();
                i += replace.length() - 1;
                j = 0;
            } else {
                if (j > 0) {
                    i += j - p[j - 1] - 1;
                    j--;
                }
            }

        }
        return s;
    }

    static public int[] pref(String pattern) {
        char[] p = pattern.toLowerCase().toCharArray();
        int size = p.length;
        int[] moveTo = new int[size];
        int h;
        for (int i = 1; i < size; i++) {
            h = i;
            while (h > 0 && p[h] != p[i]) {
                h = moveTo[h];
            }
            if (p[h] == p[i]) {
                moveTo[i] = h;
            }
        }

        return moveTo;
    }

    public static void main(String[] args) {
        System.out.println(withoutString("Hello there", "e"));
    }

}