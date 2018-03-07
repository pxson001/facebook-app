package com.facebook.feed.spannable;

import android.text.Spannable;
import com.facebook.common.lifecycle.AttachDetachListener;

/* compiled from: gravity_learn_more_link */
public final class PersistentSpannable {
    public final Spannable f21833a;
    public final boolean f21834b;
    public final AttachDetachListener f21835c;

    public PersistentSpannable(Spannable spannable, boolean z) {
        this(spannable, z, null);
    }

    public PersistentSpannable(Spannable spannable, boolean z, AttachDetachListener attachDetachListener) {
        this.f21833a = spannable;
        this.f21834b = z;
        this.f21835c = attachDetachListener;
    }
}
