package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.EventListener;

public class GameActivity extends AppCompatActivity  {

    Game_Layout_Canvas canvas;
    Track trck;
    String usr;
    float x1,x2;
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
        canvas.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        float deltaX = x2 - x1;
                        if (deltaX > 30)
                        {
                            canvas.track.usrCar.MoveRight();
                        }
                        else if(deltaX < 30)
                        {
                            canvas.track.usrCar.MoveLeft();
                        }
                        else
                        {
                            // consider as something else - a screen tap for example
                        }
                        break;
                }
                return true;
        }});
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
