class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map row -> reserved columns
        Map<Integer, Set<Integer>> reservedMap = new HashMap<>();
        for (int[] seat : reservedSeats) {
            reservedMap
                .computeIfAbsent(seat[0], k -> new HashSet<>())
                .add(seat[1]);
        }

        int count = 0;

        // Rows without any reserved seats can fit 2 families
        count += (n - reservedMap.size()) * 2;

        // Check only rows that have reserved seats
        for (int row : reservedMap.keySet()) {
            Set<Integer> reserved = reservedMap.get(row);

            boolean left = !(reserved.contains(2) || reserved.contains(3) ||
                             reserved.contains(4) || reserved.contains(5));
            boolean middle = !(reserved.contains(4) || reserved.contains(5) ||
                               reserved.contains(6) || reserved.contains(7));
            boolean right = !(reserved.contains(6) || reserved.contains(7) ||
                              reserved.contains(8) || reserved.contains(9));

            if (left && right) count += 2;
            else if (left || middle || right) count += 1;
        }

        return count;
    }
}
