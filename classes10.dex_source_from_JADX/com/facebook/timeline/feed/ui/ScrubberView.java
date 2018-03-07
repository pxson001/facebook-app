package com.facebook.timeline.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;

/* compiled from: friends_nearby_dashboard_pull_to_refresh */
public class ScrubberView extends CustomRelativeLayout {
    public final FbTextView f11223a;
    public final ProgressBar f11224b;
    public final int f11225c;

    public ScrubberView(Context context) {
        this(context, null);
    }

    private ScrubberView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907474);
        this.f11223a = (FbTextView) a(2131567977);
        this.f11224b = (ProgressBar) a(2131567978);
        this.f11225c = getResources().getDimensionPixelSize(2131429882);
    }
}
