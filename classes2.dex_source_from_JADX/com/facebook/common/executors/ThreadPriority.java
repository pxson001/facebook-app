package com.facebook.common.executors;

import android.os.Process;
import com.facebook.common.util.StringUtil;
import javax.annotation.Nullable;

/* compiled from: voip_webrtc_receive_lafns */
public enum ThreadPriority {
    URGENT(5),
    NORMAL_NEW(5),
    FOREGROUND(10),
    NORMAL(14),
    BACKGROUND(19);
    
    private final int mAndroidThreadPriority;

    public final int getAndroidThreadPriority() {
        return this.mAndroidThreadPriority;
    }

    private ThreadPriority(int i) {
        this.mAndroidThreadPriority = i;
    }

    @Nullable
    public static ThreadPriority fromStringOrNull(String str) {
        if (StringUtil.m3589a((CharSequence) str)) {
            return null;
        }
        for (ThreadPriority threadPriority : values()) {
            if (threadPriority.name().equalsIgnoreCase(str)) {
                return threadPriority;
            }
        }
        return null;
    }

    public static ThreadPriority getClosestThreadPriorityFromAndroidThreadPriority(int i) {
        ThreadPriority threadPriority = null;
        ThreadPriority[] values = values();
        int length = values.length;
        int i2 = 0;
        ThreadPriority threadPriority2 = null;
        while (i2 < length) {
            ThreadPriority threadPriority3 = values[i2];
            if (threadPriority3.getAndroidThreadPriority() >= i && threadPriority3.isLessThanOrNull(threadPriority)) {
                threadPriority = threadPriority3;
            }
            if (!threadPriority3.isGreaterThanOrNull(threadPriority2)) {
                threadPriority3 = threadPriority2;
            }
            i2++;
            threadPriority2 = threadPriority3;
        }
        return threadPriority == null ? threadPriority2 : threadPriority;
    }

    public static ThreadPriority ofCurrentThread() {
        return getClosestThreadPriorityFromAndroidThreadPriority(Process.getThreadPriority(Process.myTid()));
    }

    public final boolean isHigherPriorityThan(ThreadPriority threadPriority) {
        return this.mAndroidThreadPriority < threadPriority.mAndroidThreadPriority;
    }

    public final boolean isLowerPriorityThan(ThreadPriority threadPriority) {
        return this.mAndroidThreadPriority > threadPriority.mAndroidThreadPriority;
    }

    private boolean isLessThanOrNull(@Nullable ThreadPriority threadPriority) {
        if (threadPriority != null && threadPriority.getAndroidThreadPriority() <= getAndroidThreadPriority()) {
            return false;
        }
        return true;
    }

    private boolean isGreaterThanOrNull(@Nullable ThreadPriority threadPriority) {
        if (threadPriority != null && getAndroidThreadPriority() <= threadPriority.getAndroidThreadPriority()) {
            return false;
        }
        return true;
    }
}
