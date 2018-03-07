package com.facebook.react.uimanager;

import android.view.Choreographer.FrameCallback;
import com.facebook.react.bridge.ReactContext;

/* compiled from: friend_finder_phonebook_read */
public abstract class GuardedChoreographerFrameCallback implements FrameCallback {
    private final ReactContext f11712a;

    protected abstract void mo750a(long j);

    protected GuardedChoreographerFrameCallback(ReactContext reactContext) {
        this.f11712a = reactContext;
    }

    public final void doFrame(long j) {
        try {
            mo750a(j);
        } catch (RuntimeException e) {
            this.f11712a.m13523a(e);
        }
    }
}
