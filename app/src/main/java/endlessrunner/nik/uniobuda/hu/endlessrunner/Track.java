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

    public Track(String usrName )
    {
        this.usrCar = new UserCar(usrName,(byte)1,Color.blue);
    }
}
