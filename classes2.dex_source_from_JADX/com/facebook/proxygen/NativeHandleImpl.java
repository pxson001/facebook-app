package com.facebook.proxygen;

import com.facebook.proxygen.utils.Preconditions;

/* compiled from: publish_goodwill_video */
public class NativeHandleImpl implements NativeHandle {
    private long mNativeHandle;

    public long getNativeHandle() {
        return this.mNativeHandle;
    }

    public void setNativeHandle(long j) {
        boolean z = this.mNativeHandle == 0 || j == 0;
        Preconditions.checkState(z);
        this.mNativeHandle = j;
    }
}
