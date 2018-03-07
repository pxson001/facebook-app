package com.facebook.ui.choreographer;

import android.annotation.TargetApi;
import android.os.Looper;
import android.view.Choreographer;
import com.facebook.infer.annotation.Assertions;

@TargetApi(16)
/* compiled from: community_editor_game */
public class NoDIPassThruChoreographerWrapper implements ChoreographerWrapper {
    private final Choreographer f5427a;

    public NoDIPassThruChoreographerWrapper() {
        Assertions.a(Looper.getMainLooper() == Looper.myLooper(), "Expected to run on the UI thread!");
        this.f5427a = Choreographer.getInstance();
    }

    public final void m10311a(FrameCallbackWrapper frameCallbackWrapper) {
        this.f5427a.postFrameCallback(frameCallbackWrapper.a());
    }

    public final void m10312a(FrameCallbackWrapper frameCallbackWrapper, long j) {
        this.f5427a.postFrameCallbackDelayed(frameCallbackWrapper.a(), j);
    }

    public final void m10313b(FrameCallbackWrapper frameCallbackWrapper) {
        this.f5427a.removeFrameCallback(frameCallbackWrapper.a());
    }
}
