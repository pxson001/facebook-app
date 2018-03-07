package com.facebook.http.common;

import android.os.Process;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: release() has been called with refCount == 0 */
public final class DefaultNetworkPriority {

    /* compiled from: release() has been called with refCount == 0 */
    /* synthetic */ class C03241 {
        static final /* synthetic */ int[] f7683a = new int[ThreadPriority.values().length];

        static {
            try {
                f7683a[ThreadPriority.URGENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7683a[ThreadPriority.NORMAL_NEW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7683a[ThreadPriority.FOREGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7683a[ThreadPriority.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f7683a[ThreadPriority.BACKGROUND.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private DefaultNetworkPriority() {
    }

    public static RequestPriority m12223a() {
        return m12224a(Process.getThreadPriority(Process.myTid()));
    }

    @VisibleForTesting
    private static RequestPriority m12224a(int i) {
        return m12225a(ThreadPriority.getClosestThreadPriorityFromAndroidThreadPriority(i));
    }

    private static RequestPriority m12225a(ThreadPriority threadPriority) {
        if (threadPriority != null) {
            switch (C03241.f7683a[threadPriority.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                case 3:
                    return RequestPriority.INTERACTIVE;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    return RequestPriority.NON_INTERACTIVE;
                case 5:
                    return RequestPriority.CAN_WAIT;
            }
        }
        throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("ThreadPriority %s is not supported in conversion to network priority.", threadPriority));
    }
}
