package com.facebook.debug.feed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* compiled from: open_channel_feed */
public class HomeStoriesView extends View {
    public int f8653a = 0;
    public int f8654b = 0;
    public int f8655c = 0;
    public int f8656d = 0;
    public int f8657e = 0;
    private final Paint f8658f = new Paint();

    public HomeStoriesView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        StringBuilder stringBuilder = new StringBuilder(21);
        stringBuilder.append("u:").append(String.valueOf(this.f8653a)).append(" s:").append(String.valueOf(this.f8654b)).append(" g:").append(String.valueOf(this.f8655c)).append(" si:").append(String.valueOf(this.f8656d)).append(" ui:").append(String.valueOf(this.f8657e));
        String stringBuilder2 = stringBuilder.toString();
        this.f8658f.setColor(-16711936);
        canvas.drawRect(0.0f, 0.0f, this.f8658f.measureText(stringBuilder2), 30.0f, this.f8658f);
        this.f8658f.setColor(-16777216);
        this.f8658f.setTextSize(24.0f);
        canvas.drawText(stringBuilder2, 0.0f, 24.0f, this.f8658f);
    }

    public final void m12465a(int i, int i2, int i3, int i4, int i5) {
        this.f8653a = i;
        this.f8654b = i2;
        this.f8655c = i3;
        this.f8656d = i4;
        this.f8657e = i5;
        invalidate();
    }
}
