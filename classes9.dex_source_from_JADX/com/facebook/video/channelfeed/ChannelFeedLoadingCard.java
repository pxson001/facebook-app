package com.facebook.video.channelfeed;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: t_ */
public class ChannelFeedLoadingCard extends CustomRelativeLayout implements CanFocusDim {
    private final ValueAnimator f2351a;
    private boolean f2352b;

    public ChannelFeedLoadingCard(Context context) {
        this(context, null);
    }

    private ChannelFeedLoadingCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ChannelFeedLoadingCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2351a = new ValueAnimator();
        this.f2352b = false;
        setContentView(2130903541);
        this.f2351a.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public final void mo66a() {
        if (!this.f2352b) {
            this.f2352b = true;
            ChannelFeedDimmingUtil.m2139a(this.f2352b, this.f2351a, this);
        }
    }

    public final void mo67b() {
        if (this.f2352b) {
            this.f2352b = false;
            ChannelFeedDimmingUtil.m2139a(this.f2352b, this.f2351a, this);
        }
    }
}
