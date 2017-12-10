package endlessrunner.nik.uniobuda.hu.endlessrunner;

/**
 * Created by Noxim on 2017-11-12.
 */

public class User
{
    String userName;
    int highscore;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public User(String userName) {
        this.userName = userName;
        this.highscore=0;
    }

    public User(String usrname,int Hs)
    {
        this.userName = usrname;
        this.highscore = Hs;
    }
}
