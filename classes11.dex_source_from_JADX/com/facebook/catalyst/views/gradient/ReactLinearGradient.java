package com.facebook.catalyst.views.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.view.View;
import javax.annotation.Nullable;

/* compiled from: later_process_count */
public class ReactLinearGradient extends View {
    public float f5833a;
    public float f5834b;
    public float f5835c;
    public float f5836d;
    public int[] f5837e = new int[]{0, 0};
    @Nullable
    public float[] f5838f;
    private final Paint f5839g = new Paint();

    public ReactLinearGradient(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f5839g.setShader(new LinearGradient(this.f5833a, this.f5834b, this.f5835c * ((float) getWidth()), this.f5836d * ((float) getHeight()), this.f5837e, this.f5838f, TileMode.CLAMP));
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f5839g);
    }
}
