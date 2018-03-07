package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: componentType */
public class Video360FullScreenPlugin extends Video360Plugin {
    public Video360FullScreenPlugin(Context context) {
        this(context, null);
    }

    private Video360FullScreenPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Video360FullScreenPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
    }
}
