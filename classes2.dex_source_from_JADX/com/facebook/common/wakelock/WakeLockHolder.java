package com.facebook.common.wakelock;

import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;

/* compiled from: foreground_state */
public abstract class WakeLockHolder {
    public final WakeLock f23405a;

    public WakeLockHolder(FbWakeLockManager fbWakeLockManager, String str) {
        this.f23405a = fbWakeLockManager.m31680a(1, str);
    }
}
