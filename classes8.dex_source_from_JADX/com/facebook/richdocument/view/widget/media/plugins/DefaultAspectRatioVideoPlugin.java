package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.video.player.plugins.VideoPlugin;

/* compiled from: num_profiles */
public class DefaultAspectRatioVideoPlugin extends VideoPlugin {
    public DefaultAspectRatioVideoPlugin(Context context) {
        this(context, null);
    }

    private DefaultAspectRatioVideoPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private DefaultAspectRatioVideoPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void m7904a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            p();
        }
    }
}
