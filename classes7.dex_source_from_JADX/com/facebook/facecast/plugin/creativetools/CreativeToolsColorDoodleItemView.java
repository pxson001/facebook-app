package com.facebook.facecast.plugin.creativetools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: beeper_caused_comment_like */
public class CreativeToolsColorDoodleItemView extends View {
    private final Paint f18682a;
    private final int f18683b;
    private final float f18684c;
    private final int f18685d;
    public int f18686e;

    public CreativeToolsColorDoodleItemView(Context context) {
        this(context, null);
    }

    private CreativeToolsColorDoodleItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CreativeToolsColorDoodleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18682a = new Paint();
        this.f18682a.setAntiAlias(true);
        this.f18684c = getResources().getDimension(2131432385);
        this.f18682a.setStrokeWidth(this.f18684c);
        this.f18683b = getResources().getColor(2131363616);
        this.f18685d = getResources().getColor(2131363617);
    }

    public void setPressed(boolean z) {
        super.setPressed(z);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        float min = ((float) Math.min(width, width)) / 2.0f;
        float f = ((float) width) / 2.0f;
        float height = ((float) canvas.getHeight()) / 2.0f;
        this.f18682a.setStyle(Style.FILL);
        this.f18682a.setColor(this.f18686e);
        canvas.drawCircle(f, height, min, this.f18682a);
        if (isSelected()) {
            float f2 = min - (this.f18684c / 2.0f);
            this.f18682a.setStyle(Style.STROKE);
            this.f18682a.setColor(this.f18683b);
            canvas.drawCircle(f, height, f2, this.f18682a);
        }
        if (isPressed()) {
            this.f18682a.setStyle(Style.FILL);
            this.f18682a.setColor(this.f18685d);
            canvas.drawCircle(f, height, min, this.f18682a);
        }
    }
}
