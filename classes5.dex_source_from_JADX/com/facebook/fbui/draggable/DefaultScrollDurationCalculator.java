package com.facebook.fbui.draggable;

import android.content.Context;
import android.util.DisplayMetrics;
import javax.inject.Inject;

/* compiled from: research_poll_complete_time */
public class DefaultScrollDurationCalculator {
    public float f3150a;

    @Inject
    public DefaultScrollDurationCalculator(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f3150a = 400.0f / ((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels));
    }
}
