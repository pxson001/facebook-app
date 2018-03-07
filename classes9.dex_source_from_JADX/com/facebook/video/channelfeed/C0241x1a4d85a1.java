package com.facebook.video.channelfeed;

import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.video.engine.ExitFullScreenResult;
import javax.annotation.Nullable;

/* compiled from: success_update_dropoff_location */
public abstract class C0241x1a4d85a1 implements FullscreenTransitionListener {
    @Nullable
    private FullscreenTransitionListener f2619a;

    protected abstract void mo77a();

    public C0241x1a4d85a1(FullscreenTransitionListener fullscreenTransitionListener) {
        this.f2619a = fullscreenTransitionListener;
    }

    public final void m2526a(ExitFullScreenResult exitFullScreenResult) {
        mo77a();
        if (this.f2619a != null) {
            this.f2619a.a(exitFullScreenResult);
        }
    }
}
