class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Set<Character>[] blocks = new HashSet[n];
        Set<Character>[] seenRows = new HashSet[n];
        Set<Character>[] seenColumns = new HashSet[n];

        for (int i = 0; i < n; i++) {
            blocks[i] = new HashSet<>();
            seenRows[i] = new HashSet<>();
            seenColumns[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char current = board[i][j];
                if (current == '.') continue;

                int blockNumber = (i / 3) * 3 + (j / 3);
                Set<Character> seen = blocks[blockNumber];
                Set<Character> seenRow = seenRows[i];
                Set<Character> seenCol = seenColumns[j];
                if (seen.contains(current)
                    || seenRow.contains(current)
                    || seenCol.contains(current)) return false;
                seen.add(current);
                blocks[blockNumber] = seen;
                seenRow.add(current);
                seenRows[i] = seenRow;
                seenCol.add(current);
                seenColumns[j] = seenCol;
            }
        }

        return true;
        
    }
}