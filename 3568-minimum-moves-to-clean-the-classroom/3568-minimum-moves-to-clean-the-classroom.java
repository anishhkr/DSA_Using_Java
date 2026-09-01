class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startRow = -1;
        int startCol = -1;
        int litterCount = 0;
        
        int[][] litterIdx = new int[m][n];
        for (int[] row : litterIdx) {
            Arrays.fill(row, -1);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (c == 'L') {
                    litterIdx[i][j] = litterCount++;
                }
            }
        }
        
        int targetMask = (1 << litterCount) - 1;
        
        if (targetMask == 0) return 0;
        
        int[][][] maxEnergy = new int[m][n][1 << litterCount];
        for (int[][] arr2D : maxEnergy) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0, energy});
        maxEnergy[startRow][startCol][0] = energy;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int e = curr[3];
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    
                    char nextCell = classroom[nr].charAt(nc);
                    
                    if (nextCell == 'X') continue;
                    
                    int nextEnergy = e - 1;
                    
                    if (nextEnergy < 0) continue;
                    
                    // Reset energy on 'R'
                    if (nextCell == 'R') {
                        nextEnergy = energy;
                    }
                    
                    int nextMask = mask;
                    
                    // Collect litter if present
                    if (nextCell == 'L') {
                        int idx = litterIdx[nr][nc];
                        if (idx != -1) {
                            nextMask |= (1 << idx);
                        }
                    }
                    
                    if (nextMask == targetMask) {
                        return moves + 1;
                    }
                    
                    if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                        maxEnergy[nr][nc][nextMask] = nextEnergy;
                        queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                    }
                }
            }
            moves++;
        }
        
        return -1; // Path not found
    }
}