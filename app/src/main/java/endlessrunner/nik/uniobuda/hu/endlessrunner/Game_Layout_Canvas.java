package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by home on 2017.12.09..
 */

public class Game_Layout_Canvas extends View{
    Paint clr = new Paint();
    Bitmap road;
    Bitmap enemy;
    Bitmap enemy2;
    Bitmap enemy3;
    Bitmap user;
    boolean drawable = false;
    Track track;
    Point size;
    int y = 0;


    public Game_Layout_Canvas(Context context, Track trck) {
        super(context);
        this.track = trck;

        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inMutable = true;
        Bitmap temp = BitmapFactory.decodeResource(getResources(),R.mipmap.road,opt);

        Bitmap tempenemy = BitmapFactory.decodeResource(getResources(),R.mipmap.nmy1);
        Bitmap tempenemy2 = BitmapFactory.decodeResource(getResources(),R.mipmap.nmy2);
        Bitmap tempenemy3 = BitmapFactory.decodeResource(getResources(),R.mipmap.nmy3);
        Bitmap tempuser = BitmapFactory.decodeResource(getResources(),R.mipmap.user);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        size = new Point();
        display.getSize(size);

        road = Bitmap.createScaledBitmap(temp,size.x,size.y, true);
        enemy = Bitmap.createScaledBitmap(tempenemy,size.x/9,200,true);
        enemy2 = Bitmap.createScaledBitmap(tempenemy2,size.x/9,200,true);
        enemy3 = Bitmap.createScaledBitmap(tempenemy3,size.x/9,200,true);
        user = Bitmap.createScaledBitmap(tempuser,size.x/9,200,true);

        Enemy en1 = new Enemy(0,track.usrCar.usr.getHighscore());
        track.enemies.add(en1);

        Enemy en2 = new Enemy(1,track.usrCar.usr.getHighscore());
        track.enemies.add(en2);
        Enemy en3 = new Enemy(2,track.usrCar.usr.getHighscore());
        track.enemies.add(en3);

    }


    void onPause()
    {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        clr.setColor(Color.BLACK);
        clr.setStyle(Paint.Style.FILL);
        clr.setTextSize(100);
        canvas.drawPaint(clr);



        onTick();

        Enemy selected =null;
        canvas.drawBitmap(road,0,0,new Paint());
        for (Enemy item: track.enemies) {

            if (item.getY()<=canvas.getHeight())
            {
                item.move(track.usrCar.usr.getHighscore());
                switch (item.getLine()) {
                    case 0:
                        canvas.drawBitmap(enemy, canvas.getWidth() / 3 + (canvas.getWidth() / 9 * item.getLine()), item.getY(), new Paint());
                        break;
                    case 1:
                        canvas.drawBitmap(enemy2, canvas.getWidth() / 3 + (canvas.getWidth() / 9 * item.getLine()), item.getY(), new Paint());
                        break;
                    case 2:
                        canvas.drawBitmap(enemy3, canvas.getWidth() / 3 + (canvas.getWidth() / 9 * item.getLine()), item.getY(), new Paint());
                        break;

                }
            }
            else
                selected = item;
        }
        if(selected != null)
            track.enemies.remove(selected);
       canvas.drawBitmap(user,canvas.getWidth() / 3 + canvas.getWidth()/9 * track.usrCar.getLine(),canvas.getHeight()-200,new Paint());


        canvas.drawText("Score: "+track.usrCar.usr.getHighscore(),50,100,clr);

        invalidate();



    }

    final Random rnd = new Random();
    private void onTick() {
        track.usrCar.usr.highscore++;
        Enemy last = track.enemies.get(track.enemies.size()-1);
        if(last.y>600)
        {
            int rnjesus = rnd.nextInt(2);
            if(rnjesus==0) {
                Enemy enemy = new Enemy(rnd.nextInt(3), track.usrCar.usr.getHighscore());
                track.enemies.add(enemy);
            }
            else {
                Enemy enemy2 = new Enemy(rnd.nextInt(3), track.usrCar.usr.getHighscore());
                Enemy enemy3 = new Enemy(rnd.nextInt(3), track.usrCar.usr.getHighscore());
                track.enemies.add(enemy2);
                track.enemies.add(enemy3);
            }
        }


    }


    public void onResume()
    {
        drawable = true;
    }
}
