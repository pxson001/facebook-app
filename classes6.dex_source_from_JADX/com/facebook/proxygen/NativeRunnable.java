package com.facebook.proxygen;

/* compiled from: spouse */
public class NativeRunnable extends NativeHandleImpl implements Runnable {
    public native void close();

    public native void run();

    protected void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
