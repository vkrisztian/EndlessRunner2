package endlessrunner.nik.uniobuda.hu.endlessrunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noxim on 2017-11-12.
 */

public class Track
{
    UserCar usrCar;
    List<Enemy> enemies = new ArrayList<Enemy>();


    public Track(String usrName ,int y)
    {
        this.usrCar = new UserCar(usrName,1,y);
    }
}
