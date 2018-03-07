package com.facebook.springs;

import com.facebook.inject.InjectorLike;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import com.google.common.base.Preconditions;

/* compiled from: response_format=flatbuffer */
public class SpringSystemFrameCallbackWrapper extends FrameCallbackWrapper {
    public SpringSystem f6969a;

    public static SpringSystemFrameCallbackWrapper m11563a(InjectorLike injectorLike) {
        return new SpringSystemFrameCallbackWrapper();
    }

    public final void mo1639a(long j) {
        Preconditions.checkNotNull(this.f6969a);
        this.f6969a.m7841c();
    }
}
