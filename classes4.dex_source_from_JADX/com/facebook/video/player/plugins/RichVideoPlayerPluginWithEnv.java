package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import javax.annotation.Nullable;

/* compiled from: play */
public abstract class RichVideoPlayerPluginWithEnv<E extends AnyPlayerEnvironment> extends RichVideoPlayerPlugin {
    @Nullable
    public E f4500c;

    public RichVideoPlayerPluginWithEnv(Context context) {
        super(context);
    }

    public RichVideoPlayerPluginWithEnv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RichVideoPlayerPluginWithEnv(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setEnvironment(E e) {
        this.f4500c = e;
    }

    @Nullable
    public E getEnvironment() {
        return this.f4500c;
    }
}
