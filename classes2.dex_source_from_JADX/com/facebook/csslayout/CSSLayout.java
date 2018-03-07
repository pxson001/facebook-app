package com.facebook.csslayout;

import java.util.Arrays;

/* compiled from: fullscreen_userpaused */
public class CSSLayout {
    public float[] f22825a = new float[4];
    public float[] f22826b = new float[2];
    public CSSDirection f22827c = CSSDirection.LTR;

    public final void m30948a() {
        Arrays.fill(this.f22825a, 0.0f);
        Arrays.fill(this.f22826b, Float.NaN);
        this.f22827c = CSSDirection.LTR;
    }

    public final void m30949a(CSSLayout cSSLayout) {
        this.f22825a[0] = cSSLayout.f22825a[0];
        this.f22825a[1] = cSSLayout.f22825a[1];
        this.f22825a[2] = cSSLayout.f22825a[2];
        this.f22825a[3] = cSSLayout.f22825a[3];
        this.f22826b[0] = cSSLayout.f22826b[0];
        this.f22826b[1] = cSSLayout.f22826b[1];
        this.f22827c = cSSLayout.f22827c;
    }

    public String toString() {
        return "layout: {left: " + this.f22825a[0] + ", top: " + this.f22825a[1] + ", width: " + this.f22826b[0] + ", height: " + this.f22826b[1] + ", direction: " + this.f22827c + "}";
    }
}
