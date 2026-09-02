class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // quick check

        char[] c = s.toCharArray();
        char[] ct = t.toCharArray();

        Arrays.sort(c);
        Arrays.sort(ct);

        return Arrays.equals(c, ct);

    }
}