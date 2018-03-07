package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import javax.annotation.Nullable;

/* compiled from: is_dg_flow */
public class MontageProgressIndicatorView extends View {
    private final Paint f12598a;
    private final Paint f12599b;
    private final Paint f12600c;
    @Nullable
    public LayoutCoordinator f12601d;

    /* compiled from: is_dg_flow */
    public interface LayoutCoordinator {
        int mo498a(int i);

        int mo499b(int i);

        int mo500c(int i);
    }

    public MontageProgressIndicatorView(Context context) {
        this(context, null);
    }

    public MontageProgressIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MontageProgressIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12598a = new Paint();
        this.f12599b = new Paint();
        this.f12600c = new Paint();
        this.f12598a.setColor(-1);
        this.f12599b.setColor(-1);
        this.f12600c.setColor(-1);
        setWillNotDraw(false);
    }

    public void setLayoutCoordinator(@Nullable LayoutCoordinator layoutCoordinator) {
        this.f12601d = layoutCoordinator;
    }

    public void setActiveRemainingPaintAlpha(int i) {
        this.f12600c.setAlpha(i);
    }

    protected void setTrackPaintAlpha(int i) {
        this.f12598a.setAlpha(i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12601d != null) {
            int width = getWidth();
            int height = getHeight();
            int a = this.f12601d.mo498a(width);
            int c = this.f12601d.mo500c(width);
            int b = this.f12601d.mo499b(width);
            canvas.drawRect(0.0f, 0.0f, (float) a, (float) height, this.f12598a);
            canvas.drawRect((float) a, 0.0f, (float) c, (float) height, this.f12599b);
            canvas.drawRect((float) c, 0.0f, (float) b, (float) height, this.f12600c);
            canvas.drawRect((float) b, 0.0f, (float) width, (float) height, this.f12598a);
        }
    }
}
