package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        Path path = new Path();
        RectF rectF = new RectF();
        rectF.left=getWidth()/2-150;
        rectF.top=getHeight()/4;
        rectF.right=getWidth()/2;
        rectF.bottom=getHeight()/4*2;
        path.addArc(rectF,-225,225);
        RectF rectF1 = new RectF();
        rectF1.left=getWidth()/2;
        rectF1.top=getHeight()/4;
        rectF1.right=getWidth()/2+150;
        rectF1.bottom=getHeight()/4*2;
        //为true时，不会连接上一个图形的重点和当前图形的起点
        //为false时，上一个图形的重点会连接当前图形的起点
        path.arcTo(rectF1,-180,225,false);
        path.lineTo(getWidth()/2,350);
        canvas.drawPath(path,paint);
    }
}
