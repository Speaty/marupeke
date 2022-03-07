import java.util.Random;

public class MarupekeGrid {
    static final int MIN = 3;
    static final int MAX = 10;
    private Random random;

    private MarukepeTile[][] grid;

    public MarupekeGrid(){
        grid = new MarukepeTile[4][4];
    }

    public MarupekeGrid(int x){
        if(x < MIN){
            x = MIN;
        } else if (x > MAX) {
            x = MAX;
        }
        grid = new MarukepeTile[x][x];
    }

    public int getGridSize(){
        return grid[0].length;
    }

    public boolean setEmpty(int x, int y){
        if(oobCheck(x, y)){
            grid[x][y].setEmpty();
            return true;
        }
        return false;
    }
    public boolean setEditTrue(int x, int y){
        if (oobCheck(x,y) && grid[x][y].isEditable()){
            grid[x][y].setEditable();
            return true;
        }
        return false;
    }

    public boolean oobCheck(int x, int y){
        if(x >= grid.length || y >= grid.length) {
            System.out.println("OUT OF BOUNDS!");
            return false;
        }
        return true;
    }

    public boolean setSolid(int x, int y){
        if(oobCheck(x, y))
            if(grid[x][y].isEditable()){
                grid[x][y].setSolid();
                return true;
            }
        return false;
    }

    public boolean setEditable(int x, int y){
        if(oobCheck(x, y)) {
            return grid[x][y].setEditable();
        }
        return false;
    }

    public void setX(int x, int y){
        if(oobCheck(x,y)){
            grid[x][y].setX();
        }
    }
    public void setO(int x, int y){
        if(oobCheck(x,y)){
            grid[x][y].setO();
        }
    }

    public char getGridItem(int x, int y){
        if(oobCheck(x,y)) {
            return grid[x][y].getTileState();
        } else {
            return '?';
        }
    }

    public MarukepeTile[][] getGrid() {
        return grid;
    }

    private static int[] getRandomCoordinate(Random random, int limit){
        int[] coord = new int[2];
        for (int i = 0; i < 2; i++) {
            coord[i] = random.nextInt(limit);
        }
        return coord;
    }

    public static MarupekeGrid randomPuzzle(int size, int numFill, int numX, int numO){
        MarupekeGrid puzzle = new MarupekeGrid(size);
        puzzle.random = new Random();
        int[] coord = new int[2];
        for (int i = 0; i < numFill; i++) {
            coord = getRandomCoordinate(puzzle.random, size);
            while(puzzle.getGridItem(coord[0], coord[1]) != '_'){
                coord = getRandomCoordinate(puzzle.random, size);
            }
            puzzle.setSolid(coord[0], coord[1]);
        }
        for (int i = 0; i < numX; i++) {
            coord = getRandomCoordinate(puzzle.random, size);
            while(puzzle.getGridItem(coord[0], coord[1]) != '_'){
                coord = getRandomCoordinate(puzzle.random, size);
            }
            puzzle.setX(coord[0], coord[1]);
        }
        for (int i = 0; i < numO; i++) {
            coord = getRandomCoordinate(puzzle.random, size);
            while(puzzle.getGridItem(coord[0], coord[1]) != '_'){
                coord = getRandomCoordinate(puzzle.random, size);
            }
            puzzle.setO(coord[0], coord[1]);
        }

        return puzzle;
    }

    public String toString(){
        String grid = "";
        int size = getGridSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid += getGridItem(i,j);
            }
            grid += '\n';
        }
        return grid;
    }

}
