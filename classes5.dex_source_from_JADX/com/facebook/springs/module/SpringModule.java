package com.facebook.springs.module;

import com.facebook.common.time.Clock;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.springs.DummyChoreographerWrapper;
import com.facebook.springs.NonRealTime;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringSystemFrameCallbackWrapper;

@InjectorModule
/* compiled from: connection */
public class SpringModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @NonRealTime
    public static SpringSystem m10191a(Clock clock, DummyChoreographerWrapper dummyChoreographerWrapper, SpringSystemFrameCallbackWrapper springSystemFrameCallbackWrapper) {
        return new SpringSystem(clock, dummyChoreographerWrapper, springSystemFrameCallbackWrapper);
    }
}
