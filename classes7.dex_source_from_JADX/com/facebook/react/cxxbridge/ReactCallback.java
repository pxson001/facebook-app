package com.facebook.react.cxxbridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: group_unsubscribe */
interface ReactCallback {
    @DoNotStrip
    void decrementPendingJSCalls();

    @DoNotStrip
    void incrementPendingJSCalls();

    @DoNotStrip
    void onBatchComplete();

    @DoNotStrip
    void onNativeException(Exception exception);
}
