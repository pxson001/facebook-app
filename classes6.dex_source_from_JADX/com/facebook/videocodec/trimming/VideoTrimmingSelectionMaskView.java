package com.facebook.videocodec.trimming;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: com.google.android.gms.maps.internal.IOnMapLoadedCallback */
public class VideoTrimmingSelectionMaskView extends View {
    private int f19775a;
    private int f19776b;
    private Paint f19777c;
    private Paint f19778d;

    public VideoTrimmingSelectionMaskView(Context context) {
        super(context);
        m28509a();
    }

    public VideoTrimmingSelectionMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28509a();
    }

    public VideoTrimmingSelectionMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28509a();
    }

    private void m28509a() {
        this.f19777c = new Paint();
        this.f19778d = new Paint();
    }

    public void setSelectedColor(int i) {
        this.f19777c.setColor(i);
    }

    public void setUnselectedColor(int i) {
        this.f19778d.setColor(i);
    }

    public final void m28510a(int i, int i2) {
        this.f19775a = i;
        this.f19776b = i2;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        canvas.drawRect(0.0f, 0.0f, (float) this.f19775a, (float) height, this.f19778d);
        canvas.drawRect((float) this.f19775a, 0.0f, (float) this.f19776b, (float) height, this.f19777c);
        canvas.drawRect((float) this.f19776b, 0.0f, (float) width, (float) height, this.f19778d);
    }
}
