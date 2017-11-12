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

    double speed;
    public Enemy(byte clm, Color clr) {
        super(clm, clr);
        this.speed = 20;
    }
}
