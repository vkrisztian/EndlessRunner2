package endlessrunner.nik.uniobuda.hu.endlessrunner;

/**
 * Created by Noxim on 2017-11-12.
 */

public class Enemy extends Car {

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getLine() {
        return line;
    }

    int line;

    double speed;
    public Enemy(byte clm, Color clr, int line) {
        super(clm, clr);
        this.speed = 20;
        this.line = line;
    }
}
