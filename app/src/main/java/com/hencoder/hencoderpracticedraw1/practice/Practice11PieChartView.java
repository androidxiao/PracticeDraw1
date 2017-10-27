package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.RectModel;

import java.util.ArrayList;

public class Practice11PieChartView extends View {
    public static final String TAG = "ez";
    private ArrayList<RectModel> mList;
    //扫描的角度
    private float mSweepAngle;
    //开始的角度
    private float mStartAngle;
    //圆弧中心点角度
    private float mCenterAngle;
    //线条起点x
    private float mLineStartX;
    //线条起点y
    private float mLineStartY;
    //线条终点x
    private float mLineStopX;
    //线条终点y
    private float mLineStopY;
    //percent总和
    private float mTotal;
    //percent最大值
    private float mMax;
    public Practice11PieChartView(Context context) {
        this(context, null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mList = new ArrayList<>();
        RectModel model = new RectModel("Marshmallow",22.5f, Color.YELLOW);
        mList.add(model);
        model = new RectModel("Froyo",5.5f, Color.GRAY);
        mList.add(model);
        model = new RectModel("Gingerbread",10.8f, Color.BLUE);
        mList.add(model);
        model = new RectModel("Ice Cream Sandwich",12.2f, Color.BLACK);
        mList.add(model);
        model = new RectModel("Jelly Bean",20f, Color.CYAN);
        mList.add(model);
        model = new RectModel("KitKat",19f, Color.LTGRAY);
        mList.add(model);
        model = new RectModel("Lollipop",37f, Color.RED);
        mList.add(model);

        for (RectModel rectModel : mList) {
            mTotal+=rectModel.getPercent();
            mMax = Math.max(mMax, rectModel.getPercent());
        }
    }

    /**
     * 圆点坐标：(x0,y0)
     * 半径：r
     * 角度：a0
     * <p>
     * 则圆上任一点为：（x1,y1）
     * x1   =   x0   +   r   *   cos(ao   *   3.14   /180   )
     * y1   =   y0   +   r   *   sin(ao   *   3.14   /180   )
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        canvas.translate(getWidth()/2,getHeight()/2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        RectF rectF = new RectF();
        rectF.left=-150;
        rectF.top=-150;
        rectF.right=150;
        rectF.bottom=150;
        float radius = 150;
        mStartAngle=-45;
        for (int i=0;i<mList.size();i++) {
            paint.setColor(mList.get(i).getColor());
            mSweepAngle=mList.get(i).getPercent()/mTotal*360;
            if(mMax==mList.get(i).getPercent()){
                canvas.drawArc(rectF, mStartAngle+2, mSweepAngle, true, paint);
            }else {
                canvas.drawArc(rectF, mStartAngle, mSweepAngle, true, paint);
            }
            double v = (mStartAngle + mSweepAngle / 2) / 180 * 3.14;
            mLineStartX= (float) ((radius)*Math.cos(v));
            mLineStartY= (float) ((radius)*Math.sin(v));
            mLineStopX=(float) ((radius+50)*Math.cos(v));
            mLineStopY=(float) ((radius+50)*Math.sin(v));
            Log.d(TAG, "x:---> "+mLineStopX);
            Log.d(TAG, "y:---> "+mLineStopY);
            paint.setColor(Color.WHITE);
            canvas.drawLine(mLineStartX,mLineStartY,mLineStopX,mLineStopY,paint);
            canvas.drawLine(mLineStopX,mLineStopY,mLineStopX,mLineStopY+10,paint);
            if(i!=mList.size()-1) {
                canvas.drawText(mList.get(i).getText(), mLineStopX - paint.measureText(mList.get(i).getText())/2, mLineStopY + 20, paint);
            }else{
                canvas.drawText(mList.get(i).getText(), mLineStopX - paint.measureText(mList.get(i).getText())/2, mLineStopY-10, paint);
            }
//            canvas.drawPoint(mLineStartX,mLineStartY,paint);
            mStartAngle+=mSweepAngle;
        }
        paint.setTextSize(40);
        canvas.drawText("饼图",-getWidth()/3,-getHeight()/4,paint);
    }
}
