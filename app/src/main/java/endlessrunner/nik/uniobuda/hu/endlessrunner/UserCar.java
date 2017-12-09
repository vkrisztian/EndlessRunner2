package endlessrunner.nik.uniobuda.hu.endlessrunner;

/**
 * Created by Noxim on 2017-11-12.
 */

public class UserCar extends Car {
    byte carPositionColumn;
    User usr;

    public UserCar(String userName,int clm,int y ){
        super(clm);
        this.usr = new User(userName);
        this.y=y;
    }


    public void MoveLeft() {
        if (this.carPositionColumn != 0)
            this.carPositionColumn--;
    }

    public void MoveRight() {
        if (this.carPositionColumn != 2)
            this.carPositionColumn++;
    }
}
