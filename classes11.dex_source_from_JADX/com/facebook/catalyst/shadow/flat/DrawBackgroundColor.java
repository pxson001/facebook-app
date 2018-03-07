package com.facebook.catalyst.shadow.flat;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: mReceivers */
final class DrawBackgroundColor extends AbstractDrawCommand {
    private static final Paint f5624c = new Paint();
    private final int f5625d;

    DrawBackgroundColor(int i) {
        this.f5625d = i;
    }

    public final void mo155c(Canvas canvas) {
        f5624c.setColor(this.f5625d);
        canvas.drawRect(this.f5611c, this.f5612d, this.f5613e, this.f5614f, f5624c);
    }
}
