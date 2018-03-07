package com.facebook.photos.tagging.shared.layout;

import android.graphics.Rect;

/* compiled from: has_approximate_count_results */
public class InsetContainerBounds {
    public Rect f13387a = new Rect();
    public Rect f13388b = new Rect();

    public final int m21056a() {
        return this.f13387a.left - this.f13388b.left;
    }

    public final int m21057b() {
        return this.f13387a.top - this.f13388b.top;
    }

    public final int m21058c() {
        return this.f13388b.right - this.f13387a.right;
    }

    public final int m21059d() {
        return this.f13388b.bottom - this.f13387a.bottom;
    }
}
