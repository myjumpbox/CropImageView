package com.ipd.jumpbox.cropimageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jumpbox on 2016/11/3.
 */

public class FloatDrawableView extends View {


    public FloatDrawableView(Context context) {
        super(context);
        init();
    }

    public FloatDrawableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FloatDrawableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ViewGroup parentView = (ViewGroup) getParent();
        int size = parentView.getWidth() / 4 * 2;
        int height = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY);
        int width = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY);
        super.onMeasure(width, height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundDrawable(createBgShape());
    }

    private GradientDrawable createBgShape() {
        int strokeWidth = 2;
        int strokeColor = Color.parseColor("#ffffff");
        int fillColor = Color.parseColor("#00000000");

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(fillColor);
        gd.setStroke(strokeWidth, strokeColor);

        return gd;

    }

}
