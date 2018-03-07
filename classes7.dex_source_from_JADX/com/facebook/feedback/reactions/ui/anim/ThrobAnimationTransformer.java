package com.facebook.feedback.reactions.ui.anim;

import android.graphics.Matrix;
import android.graphics.Path;
import com.facebook.common.time.MonotonicClock;
import javax.inject.Inject;

/* compiled from: sessionId */
public class ThrobAnimationTransformer extends ReactionsAnimationTransformer {
    private final Matrix f3966a = new Matrix();
    private float f3967b;

    @Inject
    public ThrobAnimationTransformer(MonotonicClock monotonicClock) {
        super(monotonicClock);
    }

    public final void mo182a() {
        this.f3967b = (((((float) Math.sin(((double) (((float) m4616d()) / ((float) this.f3961c))) * 6.283185307179586d)) * 0.5f) + 0.5f) * 0.29999995f) + 1.0f;
    }

    public final void mo183a(Path path, float f, float f2) {
        this.f3966a.reset();
        this.f3966a.setScale(this.f3967b, this.f3967b, f, f2);
        path.transform(this.f3966a);
    }

    protected final int mo184b() {
        return 400;
    }
}
