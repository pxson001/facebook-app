package com.facebook.messaging.threadview.titlebar;

import android.graphics.drawable.Drawable;

/* compiled from: platform/?href={%s}&bootstrap_uri={%s} */
public class ThreadTitleBarThemeBuilder {
    public Drawable f4826a;
    private int f4827b;
    private int f4828c;
    private int f4829d;
    public int f4830e;
    public int f4831f;
    public int f4832g;
    public int f4833h;

    ThreadTitleBarThemeBuilder() {
    }

    public final ThreadTitleBarThemeBuilder m4368a(int i, int i2, int i3) {
        this.f4827b = i;
        this.f4828c = i2;
        this.f4829d = i3;
        return this;
    }

    public final ThreadTitleBarTheme m4367a() {
        return new ThreadTitleBarTheme(this.f4826a, this.f4827b, this.f4828c, this.f4829d, this.f4830e, this.f4831f, this.f4832g, this.f4833h);
    }
}
