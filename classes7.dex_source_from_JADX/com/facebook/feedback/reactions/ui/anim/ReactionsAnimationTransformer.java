package com.facebook.feedback.reactions.ui.anim;

import android.graphics.Path;
import com.facebook.common.time.MonotonicClock;

/* compiled from: setMultiChoiceModeListener not supported for this version of Android */
public abstract class ReactionsAnimationTransformer {
    private final MonotonicClock f3959a;
    private final long f3960b = this.f3959a.now();
    public int f3961c = mo184b();

    public abstract void mo182a();

    public abstract void mo183a(Path path, float f, float f2);

    protected abstract int mo184b();

    public ReactionsAnimationTransformer(MonotonicClock monotonicClock) {
        this.f3959a = monotonicClock;
    }

    public final int m4616d() {
        return (int) ((this.f3959a.now() - this.f3960b) % ((long) this.f3961c));
    }
}
