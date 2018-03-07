package com.facebook.springs.module;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.springs.DummyChoreographerWrapper;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringSystemFrameCallbackWrapper;

/* compiled from: connected_friends */
public class SpringSystem_NonRealTimeMethodAutoProvider extends AbstractProvider<SpringSystem> {
    public Object get() {
        return SpringModule.m10191a((Clock) SystemClockMethodAutoProvider.a(this), DummyChoreographerWrapper.m10174a((InjectorLike) this), SpringSystemFrameCallbackWrapper.a(this));
    }
}
