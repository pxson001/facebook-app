package com.facebook.proxygen;

/* compiled from: publish_life_event */
public class EventBase extends NativeHandleImpl {
    private long mJniEnv;

    private native void close();

    private native void init();

    public native void loopForever();

    public native void runInThread(Runnable runnable);

    public native void terminate();

    public EventBase() {
        init();
    }

    protected void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
