package com.facebook.widget;

import android.graphics.ColorFilter;
import android.view.View;
import com.facebook.widget.RoundedDrawSizeParams.ScaleType;

@Deprecated
/* compiled from: com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks */
public class RoundedViewHelper {
    public final View f5762a;
    public final RoundedDrawParams f5763b;
    private final ScaleType f5764c;
    public RoundedDrawHelper f5765d;
    public ColorFilter f5766e;
    public int f5767f;
    public int f5768g;
    public int f5769h;

    public RoundedViewHelper(View view, RoundedDrawParams roundedDrawParams) {
        this(view, roundedDrawParams, ScaleType.NONE);
    }

    private RoundedViewHelper(View view, RoundedDrawParams roundedDrawParams, ScaleType scaleType) {
        this.f5768g = 255;
        this.f5769h = 0;
        this.f5762a = view;
        this.f5763b = roundedDrawParams;
        this.f5764c = scaleType;
    }

    public final void m10532a() {
        RoundedDrawSizeParams roundedDrawSizeParams = new RoundedDrawSizeParams(this.f5762a.getWidth(), this.f5762a.getHeight(), this.f5762a.getPaddingLeft(), this.f5762a.getPaddingTop(), this.f5762a.getPaddingRight(), this.f5762a.getPaddingBottom(), this.f5764c);
        if (this.f5765d != null) {
            this.f5765d.m10519a();
        }
        this.f5765d = new RoundedDrawHelper(this.f5763b, roundedDrawSizeParams);
        if (this.f5766e != null) {
            this.f5765d.m10523a(this.f5766e);
        }
        if (this.f5767f != 0) {
            this.f5765d.m10520a(this.f5767f);
        }
        if (this.f5768g != 255) {
            this.f5765d.m10524b(this.f5768g);
        }
        if (this.f5769h != 0) {
            this.f5765d.m10525c(this.f5769h);
        }
    }

    public final void m10533b() {
        if (this.f5765d != null) {
            this.f5765d.m10519a();
        }
    }
}
