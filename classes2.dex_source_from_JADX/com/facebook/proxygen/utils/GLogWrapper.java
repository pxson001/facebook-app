package com.facebook.proxygen.utils;

import com.facebook.proxygen.NativeHandleImpl;
import com.facebook.proxygen.utils.GLogHandler.GLogSeverity;

/* compiled from: publishFormat */
public class GLogWrapper extends NativeHandleImpl {
    private native void init(GLogHandler gLogHandler);

    private native void setMinLogLevel(int i);

    public native void close();

    public native void setVLogLevel(int i);

    public GLogWrapper(BLogHandler bLogHandler) {
        init(new GLogHandler(bLogHandler));
    }

    public void setMinLogLevel(GLogSeverity gLogSeverity) {
        setMinLogLevel(gLogSeverity.ordinal());
    }

    protected void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
