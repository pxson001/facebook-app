package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.annotations.VisibleForTesting;

@DoNotStrip
/* compiled from: groups_app_group_purposes */
public interface CatalystInstance extends MemoryPressureListener {
    <T extends JavaScriptModule> T mo647a(ExecutorToken executorToken, Class<T> cls);

    <T extends JavaScriptModule> T mo648a(Class<T> cls);

    void mo649a();

    void mo651a(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener);

    <T extends NativeModule> T mo652b(Class<T> cls);

    void mo653b();

    void mo654b(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener);

    boolean mo655c();

    @DoNotStrip
    void callFunction(ExecutorToken executorToken, String str, String str2, NativeArray nativeArray, String str3);

    @VisibleForTesting
    void mo657d();

    ReactQueueConfiguration mo658e();

    @DoNotStrip
    void invokeCallback(ExecutorToken executorToken, int i, NativeArray nativeArray);
}
