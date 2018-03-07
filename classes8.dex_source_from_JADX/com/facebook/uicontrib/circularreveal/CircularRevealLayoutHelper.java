package com.facebook.uicontrib.circularreveal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.ViewGroup;

/* compiled from: mComposerTitle */
public class CircularRevealLayoutHelper<T extends ViewGroup & Client> {
    public final T f9534a;
    public final Path f9535b = new Path();
    public float f9536c = Float.NaN;
    public float f9537d = Float.NaN;
    public float f9538e = Float.NaN;

    public CircularRevealLayoutHelper(T t) {
        this.f9534a = t;
        this.f9534a.setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            this.f9534a.setLayerType(1, null);
        }
    }

    public final void m11217a(Canvas canvas) {
        if (m11216a()) {
            int save = canvas.save();
            canvas.clipPath(this.f9535b);
            ((Client) this.f9534a).a(canvas);
            canvas.restoreToCount(save);
            return;
        }
        ((Client) this.f9534a).a(canvas);
    }

    public final void m11218b(Canvas canvas) {
        if (!m11216a()) {
            ((Client) this.f9534a).b(canvas);
        }
    }

    private boolean m11216a() {
        return (VERSION.SDK_INT < 11 || Float.isNaN(this.f9536c) || Float.isNaN(this.f9537d) || Float.isNaN(this.f9538e)) ? false : true;
    }
}
