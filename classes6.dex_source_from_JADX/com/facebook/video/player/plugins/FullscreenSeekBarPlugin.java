package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.video.player.environment.AnyPlayerEnvironment;

/* compiled from: composer_attach_movie */
public class FullscreenSeekBarPlugin<E extends AnyPlayerEnvironment> extends SeekBarBaseHDPlugin<E> {
    public FullscreenSeekBarPlugin(Context context) {
        this(context, null);
    }

    public FullscreenSeekBarPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullscreenSeekBarPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected int getContentView() {
        return 2130904555;
    }
}
