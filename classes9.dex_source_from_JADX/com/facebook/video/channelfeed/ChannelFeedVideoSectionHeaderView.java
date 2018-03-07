package com.facebook.video.channelfeed;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: suggest_large_icon */
public class ChannelFeedVideoSectionHeaderView extends CustomFrameLayout implements CanFocusDim {
    private final ValueAnimator f2594a;
    private boolean f2595b;

    public ChannelFeedVideoSectionHeaderView(Context context) {
        this(context, null);
    }

    private ChannelFeedVideoSectionHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ChannelFeedVideoSectionHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2594a = new ValueAnimator();
        setContentView(2130903548);
        this.f2594a.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public final void mo66a() {
        if (!this.f2595b) {
            this.f2595b = true;
            ChannelFeedDimmingUtil.m2139a(this.f2595b, this.f2594a, this);
        }
    }

    public final void mo67b() {
        if (this.f2595b) {
            this.f2595b = false;
            ChannelFeedDimmingUtil.m2139a(this.f2595b, this.f2594a, this);
        }
    }
}
