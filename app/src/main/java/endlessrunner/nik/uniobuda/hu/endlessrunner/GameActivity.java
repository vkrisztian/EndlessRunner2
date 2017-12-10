package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.EventListener;

public class GameActivity extends AppCompatActivity implements SensorEventListener  {

    Game_Layout_Canvas canvas;
    Track trck;
    String usr;
    float x1,x2;
    SensorManager sensorManager;
    Sensor mySensor;
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
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mySensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);
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


    @Override
    public void onSensorChanged(SensorEvent event) {
//        if (event.values[0] < -5)
//            trck.usrCar.MoveRight();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
