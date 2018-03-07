package com.facebook.friendsharing.meme.prompt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.widget.FbImageView;

/* compiled from: RippleAndroid */
public class MemePromptImageView extends FbImageView {
    private int f23957a;

    public MemePromptImageView(Context context) {
        super(context);
    }

    public MemePromptImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MemePromptImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23957a >= 2) {
            Paint paint = new Paint();
            paint.setColor(-16777216);
            paint.setAlpha(170);
            paint.setStyle(Style.FILL);
            int width = canvas.getWidth();
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) width, paint);
            m26074a(canvas);
        }
    }

    private void m26074a(Canvas canvas) {
        Paint textPaint = new TextPaint(1);
        textPaint.setTextSize((float) getResources().getDimensionPixelSize(2131432478));
        textPaint.setTypeface(Typeface.create("Roboto", 0));
        textPaint.setColor(-1);
        Rect rect = new Rect();
        canvas.getClipBounds(rect);
        int width = rect.width();
        textPaint.setTextAlign(Align.LEFT);
        String str = "+" + this.f23957a;
        textPaint.getTextBounds(str, 0, StringLengthHelper.a(str), rect);
        canvas.drawText(str, ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) width) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), textPaint);
    }

    protected void setCount(int i) {
        this.f23957a = i;
        invalidate();
    }
}
