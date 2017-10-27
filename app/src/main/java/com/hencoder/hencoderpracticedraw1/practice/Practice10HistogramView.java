package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.RectModel;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    public static final String TAG = "ez";

    private List<RectModel> mList = new ArrayList<>();

    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        RectModel rectModel = new RectModel("PHP", 0.89f, Color.GREEN);
        mList.add(rectModel);
        rectModel = new RectModel("Swift", 1.59f, Color.GREEN);
        mList.add(rectModel);
        rectModel = new RectModel("C++", 2.89f, Color.GREEN);
        mList.add(rectModel);
        rectModel = new RectModel("Js", 1.89f, Color.GREEN);
        mList.add(rectModel);
        rectModel = new RectModel("C#", 3.89f, Color.GREEN);
        mList.add(rectModel);
        rectModel = new RectModel("Kotlin", 2.09f, Color.GREEN);
        mList.add(rectModel);
        rectModel = new RectModel("Java", 5.89f, Color.GREEN);
        mList.add(rectModel);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        canvas.translate(getWidth() * 0.1f, getHeight() * 0.8f);
        canvas.drawLine(0, 0, getWidth() * 0.8f, 0, paint);
        canvas.drawLine(0, 0, 0, -getHeight() * 0.7f, paint);
        int space=20;
        int step= (int) (getWidth()*0.7f/7);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setTextSize(20);
        for(int i=0;i<mList.size();i++) {
            RectF rectF1 = new RectF();
            rectF1.left = step*i+space;
            rectF1.top = -(getHeight()*0.7f/7*mList.get(i).getPercent());
            rectF1.right = step*(i+1);
            rectF1.bottom = 0;
            canvas.drawRect(rectF1, paint);
            canvas.drawText(mList.get(i).getText(),step*i+space+step/4-paint.measureText(mList.get(i).getText())/4,20,paint);
        }
        paint.setTextSize(40);
        paint.setColor(Color.WHITE);
        canvas.drawText("直方图",getWidth()/3,90,paint);
    }
}
