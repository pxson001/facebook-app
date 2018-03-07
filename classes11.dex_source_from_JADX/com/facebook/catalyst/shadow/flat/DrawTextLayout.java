package com.facebook.catalyst.shadow.flat;

import android.graphics.Canvas;
import android.text.Layout;

/* compiled from: mInstance */
public final class DrawTextLayout extends AbstractDrawCommand {
    public Layout f5648c;
    private float f5649d;

    DrawTextLayout(Layout layout) {
        m6961a(layout);
    }

    public final void m6961a(Layout layout) {
        this.f5648c = layout;
        float f = 0.0f;
        int lineCount = layout.getLineCount();
        for (int i = 0; i != lineCount; i++) {
            f = Math.max(f, layout.getLineMax(i));
        }
        this.f5649d = f;
    }

    public final Layout m6963e() {
        return this.f5648c;
    }

    public final float m6964f() {
        return this.f5649d;
    }

    public final float m6965g() {
        return (float) this.f5648c.getHeight();
    }

    protected final void mo155c(Canvas canvas) {
        float f = this.f5611c;
        float f2 = this.f5612d;
        canvas.translate(f, f2);
        this.f5648c.draw(canvas);
        canvas.translate(-f, -f2);
    }
}
