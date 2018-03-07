package com.facebook.catalyst.shadow.flat;

import android.graphics.Canvas;

/* compiled from: mHandlerState= */
public final class DrawView extends AbstractClippingDrawCommand {
    public final int f5650c;
    boolean f5651d;

    public DrawView(int i, float f, float f2, float f3, float f4) {
        this.f5650c = i;
        m6921b(f, f2, f3, f4);
    }

    public final void mo153a(FlatViewGroup flatViewGroup, Canvas canvas) {
        if (this.d_) {
            canvas.save(2);
            m6919a(canvas);
            flatViewGroup.m7077a(canvas);
            canvas.restore();
            return;
        }
        flatViewGroup.m7077a(canvas);
    }
}
