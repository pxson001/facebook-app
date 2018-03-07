package com.facebook.react.cxxbridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeArray;

@DoNotStrip
/* compiled from: groups_sort_filter/ */
public class CallbackImpl implements Callback {
    @DoNotStrip
    private final HybridData mHybridData;

    private native void nativeInvoke(NativeArray nativeArray);

    @DoNotStrip
    private CallbackImpl(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final void mo642a(Object... objArr) {
        nativeInvoke(Arguments.m13387a(objArr));
    }
}
