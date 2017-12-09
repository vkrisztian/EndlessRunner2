package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.EventListener;

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

        canvas = new Game_Layout_Canvas(GameActivity.this,usr);
        canvas.setEndsListener(new EndsListener() {
            @Override
            public void onEnd(User usr) {
               Intent intent = new Intent();
               intent.putExtra("usr",usr.getUserName());
               intent.putExtra("high",usr.getHighscore());
               setResult(RESULT_OK,intent);
               finish();
            }
        });
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
