package com.facebook.reactionsanimations.data;

import android.graphics.Color;
import com.facebook.proguard.annotations.DoNotStrip;

/* compiled from: h.facebook.com */
public class ReactionsColorFrame implements HasKeyFrame {
    @DoNotStrip
    private String mColor;
    @DoNotStrip
    private int mStartFrame;

    public final int mo3165a() {
        return this.mStartFrame;
    }

    public final int m29149b() {
        if (this.mColor == null) {
            return 0;
        }
        return Color.parseColor(this.mColor);
    }
}
