package com.example.xingzhi.holographicteaching.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Explain
 * Created on 2020/7/16 10:05.
 */
public class ImageSpan extends android.text.style.ImageSpan {
    public ImageSpan(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    public ImageSpan(Context context, Bitmap bitmap, int verticalAlignment) {
        super(context, bitmap, verticalAlignment);
    }

    public ImageSpan(Drawable drawable) {
        super(drawable);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        try {
            Drawable d = getDrawable();
            Rect rect = d.getBounds();
            if (fm != null) {
                Paint.FontMetricsInt fmPaint = paint.getFontMetricsInt();
                int fontHeight = fmPaint.bottom - fmPaint.top;
                int drHeight = rect.bottom - rect.top;
                int top = drHeight / 2 - fontHeight / 4;
                int bottom = drHeight / 2 + fontHeight / 4;
                fm.ascent = -bottom;
                fm.top = -bottom;
                fm.bottom = top;
                fm.descent = top;
            }
            return rect.right;
        } catch (Exception e) {
            return 20;
        }
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        try {
            Drawable d = getDrawable();
            canvas.save();
            int transY = 0;
            transY = ((bottom - top) - d.getBounds().bottom) / 2 + top;
            canvas.translate(x, transY);
            d.draw(canvas);
            canvas.restore();
        } catch (Exception e) {
        }
    }
}
