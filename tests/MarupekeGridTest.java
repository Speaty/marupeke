import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarupekeGridTest {
    private MarupekeGrid g2;

    @Before
    public void setUp(){
        g2 = new MarupekeGrid();
    }

    @Test // set non-solid grid square solid test
    public void setSolidTest1(){
        System.out.println(g2.toString());
        assertTrue(g2.setSolid(0,0));
    }

    @Test // set solid grid square solid test
    public void setSolidTest2(){
        g2.setSolid(0,1);
        assertFalse(g2.setSolid(0,1));
    }

    @Test // set out of bounds grid square solid
    public void setSolidTest3(){
        assertFalse(g2.setSolid(4,4));
    }

    @Test // set out of bounds grid square uneditable
    public void setEditableTest1(){
        assertFalse(g2.setEditable(4,4));
    }

    @Test // set out of bounds grid square uneditable
    public void setEditableTest2(){
        assertTrue(g2.setEditable(1,1));
    }

    @Test // set out of bounds grid square uneditable
    public void setEditableTest3(){
        g2.setEditable(1,2);
        assertFalse(g2.setEditable(1,2));
    }

    @Test // set X use case test
    public void setXTest1(){
        g2.setX(2,2);
        assertEquals('X', g2.getGridItem(2,2));
    }

    @Test // set X on solid tile
    public void setXTest2(){
        g2.setSolid(3,3);
        g2.setX(3,3);
        assertEquals('#', g2.getGridItem(3,3));
    }

    @Test // set X on oob tile
    public void setXTest3(){
        g2.setX(7,14);
        assertEquals('_', g2.getGridItem(3,3));
    }

    @Test // random puzzle is correct size
    public void randomPuzzleTest(){
        MarupekeGrid randomTest = MarupekeGrid.randomPuzzle(5,0,0,0);
        assertEquals(5, randomTest.getGridSize());
    }

    @Test // random puzzle has specified solid elems
    public void randomPuzzleFillTest(){
        MarupekeGrid randomTest = MarupekeGrid.randomPuzzle(5,5, 0,0);
        MarukepeTile grid[][] = randomTest.getGrid();
        int solid = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(grid[i][j].matches('#')){
                    ++solid;
                }
            }
        }
        assertEquals(5, solid);
    }

    @Test // toString use case test
    public void toStringTest(){
        MarupekeGrid g4 = MarupekeGrid.randomPuzzle(7, 6, 7, 2);
        g4.toString();
    }
}