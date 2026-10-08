import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.awt.Point;

class Solution {
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        List<List<Point>> holes = extractShapes(game_board, 0);
        
        List<List<Point>> pieces = extractShapes(table, 1);
        
        boolean[] used = new boolean[pieces.size()];
        
        int answer = 0;
        
        for (List<Point> hole : holes) {
            
            for (int i = 0; i < pieces.size(); i++) {
                
                if (used[i]) {
                    continue;
                }
                
                List<Point> piece = pieces.get(i);
                
                if (hole.size() != piece.size()) {
                    continue;
                }
                
                if (isSameShape(hole, piece)) {
                    used[i] = true;
                    answer += hole.size();
                    break;
                }
            }
        }
        
        return answer;
        
    }
    
    private List<List<Point>> extractShapes(int[][] board, int target) {
        
        int n = board.length;
        
        boolean[][] visited = new boolean[n][n];
        
        List<List<Point>> shapes = new ArrayList<>();
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                
                if (visited[row][col]) {
                    continue;
                }
                
                if (board[row][col] != target) {
                    continue;
                }
                
                List<Point> shape = bfs(board, visited, row, col, target);
                
                shapes.add(normalize(shape));
            }
        }
        
        return shapes;
    }
    
    private List<Point> bfs (
    
        int[][] board,
        boolean[][] visited,
        int startRow,
        int startCol,
        int target
    ) {
        
        int n = board.length;
        
        Queue<Point> queue = new ArrayDeque<>();
        List<Point> shape = new ArrayList<>();
        
        queue.offer(new Point(startRow, startCol));
        visited[startRow][startCol] = true;
        
        while (!queue.isEmpty()) {
        
            Point current = queue.poll();
            
            shape.add(current);
            
            for (int i = 0; i < 4; i++) {
                
                int nr = current.x + dr[i];
                int nc = current.y + dc[i];
                
                if (nr < 0 || nr >= n
                        || nc < 0 || nc >= n) {
                    continue;
                }
                
                if (visited[nr][nc]) {
                    continue;
                }
                
                if (board[nr][nc] != target) {
                    continue;
                }
                
                visited[nr][nc] = true;
                
                queue.offer(new Point(nr, nc));
            }
        }
        
        return shape;
    }
    
    private List<Point> normalize(List<Point> shape) {
        
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        
        for (Point point : shape) {
            minRow = Math.min(minRow, point.x);
            minCol = Math.min(minCol, point.y);
        }
        
        List<Point> normalized = new ArrayList<>();
        
        for (Point point : shape) {
            normalized.add(
                new Point(
                    point.x - minRow,
                    point.y - minCol
                )
            );
        }
        
        normalized.sort((a, b) -> {
            if (a.x != b.x) {
                return Integer.compare(a.x, b.x);
            }
            
            return Integer.compare(a.y, b.y);
        });
        
        return normalized;
    } 
    
    private List<Point> rotate(List<Point> shape) {
        List<Point> rotated = new ArrayList<>();
        
        for (Point point : shape) {
            
            int newRow = point.y;
            int newCol = -point.x;
            
            rotated.add(
                new Point(newRow, newCol)
            );
        }
        
        return normalize(rotated);
    }
    
    private boolean isSameShape(
        List<Point> hole, 
        List<Point> piece
    ) {
        
        List<Point> current = piece;
    
        for (int i = 0; i < 4; i++) {
            
            if (hole.equals(current)) {
                return true;
            }
            
            current = rotate(current);
        }
        
        return false;
        
    }
}