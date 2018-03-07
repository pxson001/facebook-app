package com.facebook.fbui.tinyclicks;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: nickname_choices */
public class TouchTarget {
    public View f10032a;
    public ViewGroup f10033b = null;
    private Rect f10034c;
    public Rect f10035d;

    public TouchTarget(View view, Rect rect, Rect rect2) {
        this.f10032a = view;
        this.f10034c = rect;
        this.f10035d = rect2;
    }

    private int m15717c(int i) {
        if (i < this.f10034c.left) {
            return this.f10034c.left;
        }
        if (i > this.f10034c.right) {
            return this.f10034c.right;
        }
        return i;
    }

    private int m15718d(int i) {
        if (i < this.f10034c.top) {
            return this.f10034c.top;
        }
        if (i > this.f10034c.bottom) {
            return this.f10034c.bottom;
        }
        return i;
    }

    public final int m15720a(int i, int i2) {
        int c = m15717c(i);
        double abs = (double) Math.abs(i - c);
        double abs2 = (double) Math.abs(i2 - m15718d(i2));
        return (int) Math.sqrt((abs2 * abs2) + (abs * abs));
    }

    public final int m15719a(int i) {
        return m15717c(i) - this.f10034c.left;
    }

    public final int m15721b(int i) {
        return m15718d(i) - this.f10034c.top;
    }
}
