package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    Game_Layout_Canvas canvas;
    Track trck;
    String usr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            usr = extras.getString("usrname");
        }
        else {
            usr = "default";
        }
        trck = new Track(usr);
        canvas = new Game_Layout_Canvas(GameActivity.this   );

        setContentView(canvas);
    }

    @Override
    protected void onPause() {
        super.onPause();
        canvas.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        canvas.onResume();
    }
}
