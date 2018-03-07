package com.facebook.reactionsanimations.data;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.List;

/* compiled from: gysj_facepile_count_param */
public class ReactionsFeatureFrame implements HasKeyFrame {
    private MoveListFeature f21437a;
    @DoNotStrip
    private List<String> mData;
    @DoNotStrip
    private int mStartFrame;

    public final int mo3165a() {
        return this.mStartFrame;
    }

    public final MoveListFeature m29162b() {
        if (this.f21437a == null) {
            this.f21437a = new MoveListFeature(this, this.mData);
        }
        return this.f21437a;
    }
}
