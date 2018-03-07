package com.facebook.nodes.canvas;

import android.graphics.Canvas;
import android.view.View;

/* compiled from: threadFbId */
public final class DrawViewCanvasOperation implements CanvasOperation {
    private final int f3190a;
    private final int f3191b;
    private final View f3192c;

    public DrawViewCanvasOperation(int i, int i2, View view) {
        this.f3190a = i;
        this.f3191b = i2;
        this.f3192c = view;
    }

    public final void mo188a(Canvas canvas) {
        canvas.translate((float) this.f3190a, (float) this.f3191b);
        this.f3192c.draw(canvas);
        canvas.translate((float) (-this.f3190a), (float) (-this.f3191b));
    }
}
