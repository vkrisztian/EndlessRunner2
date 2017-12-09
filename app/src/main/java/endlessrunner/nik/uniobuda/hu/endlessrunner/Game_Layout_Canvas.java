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

/**
 * Created by home on 2017.12.09..
 */

public class Game_Layout_Canvas extends View{
    Paint clr = new Paint();
    Bitmap road;
    public Game_Layout_Canvas(Context context) {
        super(context);
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inMutable = true;
        Bitmap temp = BitmapFactory.decodeResource(getResources(),R.mipmap.road,opt);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        road = Bitmap.createScaledBitmap(temp,size.x,size.y, true);



    }


    void onPause()
    {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        clr.setColor(Color.BLACK);
        Rect proba = new Rect(100,100,200,200);
        canvas.drawRect(proba,clr);
        canvas.drawBitmap(road,0,0,new Paint());
        invalidate();
    }



    public void onResume() {
    }
}
