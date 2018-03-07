package com.facebook.feed.fragment.debug;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* compiled from: group_record_notification_nux_display */
public class FreshFeedView extends View {
    public int f11890a = 0;
    public int f11891b = 0;
    public int f11892c = 0;
    public int f11893d = 0;
    public int f11894e = 0;
    private final Paint f11895f = new Paint();

    public FreshFeedView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append("ui p:").append(String.valueOf(this.f11893d));
        stringBuilder.append(" s:").append(String.valueOf(this.f11894e));
        stringBuilder.append("  col s:").append(String.valueOf(this.f11890a));
        stringBuilder.append(" f:").append(String.valueOf(this.f11891b));
        stringBuilder.append(" a:").append(String.valueOf(this.f11892c));
        String stringBuilder2 = stringBuilder.toString();
        this.f11895f.setColor(-16711936);
        canvas.drawRect(((float) canvas.getWidth()) - this.f11895f.measureText(stringBuilder2), 0.0f, (float) canvas.getWidth(), 30.0f, this.f11895f);
        this.f11895f.setColor(-16777216);
        this.f11895f.setTextSize(24.0f);
        canvas.drawText(stringBuilder2, ((float) canvas.getWidth()) - this.f11895f.measureText(stringBuilder2), 24.0f, this.f11895f);
    }

    public final void m13992a(int i, int i2, int i3, int i4, int i5) {
        this.f11890a = i;
        this.f11891b = i2;
        this.f11892c = i3;
        this.f11893d = i4;
        this.f11894e = i5;
        invalidate();
    }
}
