package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.video.player.RichVideoPlayerParams;

/* compiled from: composer_add_location_after_tag_people */
public class QuicksilverOverlayPlugin extends RichVideoPlayerPlugin {
    public View f19367a;
    public View f19368b;
    public View f19369c;
    public View f19370d;

    public QuicksilverOverlayPlugin(Context context) {
        this(context, null, 0);
    }

    private QuicksilverOverlayPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906566);
        this.f19367a = a(2131566528);
        this.f19368b = a(2131566529);
        this.f19369c = a(2131566530);
        this.f19370d = a(2131566527);
    }

    protected final void m28145a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
    }

    protected final void m28146c() {
    }
}
