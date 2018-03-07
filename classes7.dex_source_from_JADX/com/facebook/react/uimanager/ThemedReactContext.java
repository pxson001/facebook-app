package com.facebook.react.uimanager;

import android.content.Context;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;

/* compiled from: framing bit after modes not set as expected */
public class ThemedReactContext extends ReactContext {
    private final ReactApplicationContext f11769a;

    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context) {
        super(context);
        m13519a(reactApplicationContext.m13513a());
        this.f11769a = reactApplicationContext;
    }

    public final void mo745a(LifecycleEventListener lifecycleEventListener) {
        this.f11769a.mo745a(lifecycleEventListener);
    }

    public final void mo746b(LifecycleEventListener lifecycleEventListener) {
        this.f11769a.mo746b(lifecycleEventListener);
    }
}
