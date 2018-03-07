package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: TimelineFragmentFbInjectorInjectMe */
public class FeedbackWithCountPlugin extends FeedbackBasePlugin {
    public FeedbackWithCountPlugin(Context context) {
        this(context, null);
    }

    public FeedbackWithCountPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedbackWithCountPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected int getContentView() {
        return 2130904367;
    }
}
