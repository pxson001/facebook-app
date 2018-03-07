package com.facebook.feedback.reactions.ui.anim;

import android.graphics.Matrix;
import android.graphics.Path;
import com.facebook.common.time.MonotonicClock;
import javax.inject.Inject;

/* compiled from: setJSResponder */
public class BlinkAnimationTransformer extends ReactionsAnimationTransformer {
    private final Matrix f3962a = new Matrix();
    private float f3963b;

    @Inject
    public BlinkAnimationTransformer(MonotonicClock monotonicClock) {
        super(monotonicClock);
    }

    public final void mo182a() {
        int d = m4616d();
        if (d <= 3000) {
            this.f3963b = 1.0f;
        } else {
            this.f3963b = ((1.0f - (Math.abs((((float) ((d - 3000) % 200)) / 200.0f) - 0.5f) * 2.0f)) * -0.995f) + 1.0f;
        }
    }

    public final void mo183a(Path path, float f, float f2) {
        this.f3962a.reset();
        this.f3962a.setScale(1.0f, this.f3963b, f, f2);
        path.transform(this.f3962a);
    }

    protected final int mo184b() {
        return 3400;
    }
}
