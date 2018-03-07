package com.facebook.groups.widget.actionbuttonwithdivider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.facebook.fbui.glyph.GlyphButton;

/* compiled from: emotional_icon_scale */
public class HscrollActionButtonWithVerticalDivider extends GlyphButton {
    private int f14881b;
    private int f14882c;
    private Paint f14883d;

    public HscrollActionButtonWithVerticalDivider(Context context) {
        super(context);
        m17341a();
    }

    public HscrollActionButtonWithVerticalDivider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17341a();
    }

    public HscrollActionButtonWithVerticalDivider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17341a();
    }

    private void m17341a() {
        Resources resources = getResources();
        this.f14883d = new Paint();
        this.f14883d.setColor(resources.getColor(2131361981));
        this.f14881b = resources.getDimensionPixelSize(2131427446);
        this.f14882c = 0;
    }

    public void setDividerColor(int i) {
        this.f14883d.setColor(i);
        invalidate();
    }

    public void setDividerMarginPx(int i) {
        this.f14882c = i;
        invalidate();
    }

    public void setDividerThicknessPx(int i) {
        this.f14881b = i;
        this.f14883d.setStrokeWidth((float) this.f14881b);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = ViewCompat.h(this) == 1 ? getWidth() - this.f14881b : 0;
        canvas.drawLine((float) width, (float) this.f14882c, (float) width, (float) (getHeight() - this.f14882c), this.f14883d);
    }
}
