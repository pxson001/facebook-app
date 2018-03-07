package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: composer */
public class VerticalOverflowMenuPlugin extends OverflowMenuPlugin {
    public VerticalOverflowMenuPlugin(Context context) {
        this(context, null);
    }

    public VerticalOverflowMenuPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalOverflowMenuPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected int getContentViewResource() {
        return 2130907650;
    }
}
