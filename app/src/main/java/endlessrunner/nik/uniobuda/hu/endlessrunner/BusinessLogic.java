package endlessrunner.nik.uniobuda.hu.endlessrunner;

import java.util.Random;

/**
 * Created by Noxim on 2017-11-12.
 */

public class BusinessLogic {

    byte carPositionColumn = 2;
    boolean[][] gamePlace = new boolean[3][8];
    byte lastEnemyPos = 9;
    byte lastlastEnemyPos;
    Random rng = new Random();


    public void MoveLeft() {
        if (this.carPositionColumn != 1)
            this.carPositionColumn--;
    }

    public void MoveRight() {
        if (this.carPositionColumn != 3)
            this.carPositionColumn++;
    }

    // TODO: 2017-11-12
    public void EnemyCreate() {
        int h = rng.nextInt(100);
        //ne jöjjön minden sorban enemy, így kicsit reálisabb a dolog
        if (h < 75) {


            

        }
    }
    //amennyiben az utolsó sorban, ahol az autó van található enemy, akkor ütközés van és GameOver
    public boolean COllision() {
        if (gamePlace[carPositionColumn][7])
            return true;
        return false;
    }


}
