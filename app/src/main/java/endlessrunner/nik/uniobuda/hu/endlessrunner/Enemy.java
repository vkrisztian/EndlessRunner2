package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

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

    public Enemy(int line,int Highscore) {
        super(line);

        this.speed = 5+Highscore/100;

    }


    public void move(int Highscore)
    {
        this.y+=speed;
    }
}
