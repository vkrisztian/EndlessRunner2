package endlessrunner.nik.uniobuda.hu.endlessrunner;

/**
 * Created by Noxim on 2017-11-12.
 */

public class UserCar extends Car {
    User usr;

    public UserCar(String userName,int clm,int y ){
        super(clm);
        this.usr = new User(userName);
        this.y=y;
    }


    public void MoveLeft() {
        if (this.columnPosition!= 0)
            this.columnPosition--;
    }

    public void MoveRight() {
        if (this.columnPosition != 2)
            this.columnPosition++;
    }
}
