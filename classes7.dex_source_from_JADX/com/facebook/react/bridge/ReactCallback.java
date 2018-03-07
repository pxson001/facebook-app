package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: group_unsubscribe */
public interface ReactCallback {
    @DoNotStrip
    void call(ExecutorToken executorToken, int i, int i2, ReadableNativeArray readableNativeArray);

    @DoNotStrip
    void onBatchComplete();

    @DoNotStrip
    void onExecutorUnregistered(ExecutorToken executorToken);
}
