package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by home on 2017.12.09..
 */

public class Game_Layout_Canvas extends View{
    Paint clr = new Paint();

    public Game_Layout_Canvas(Context context) {
        super(context);


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

        invalidate();
    }



    public void onResume() {
    }
}
