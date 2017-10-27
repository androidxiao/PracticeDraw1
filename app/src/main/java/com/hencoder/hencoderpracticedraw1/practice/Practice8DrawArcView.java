package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        RectF rectF = new RectF();
        rectF.left=getWidth()/3;
        rectF.top=getHeight()/3;
        rectF.right=getWidth()/4*3;
        rectF.bottom=getHeight()/3*2;
        canvas.drawArc(rectF,-110,90,true,paint);
        canvas.drawArc(rectF, 0, 180, true, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF,190,40,false,paint);
    }
}
