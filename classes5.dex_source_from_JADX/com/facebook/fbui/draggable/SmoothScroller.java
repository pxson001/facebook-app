package com.facebook.fbui.draggable;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import javax.inject.Inject;

/* compiled from: requiredThread */
public class SmoothScroller extends Scroller {
    @Inject
    public SmoothScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }
}
