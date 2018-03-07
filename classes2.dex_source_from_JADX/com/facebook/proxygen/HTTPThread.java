package com.facebook.proxygen;

import com.facebook.proxygen.utils.Preconditions;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;

/* compiled from: profileshare/immersive */
public class HTTPThread implements Runnable {
    private EventBase mEventBase;
    private EvbExceptionHandler mExHandler;

    public HTTPThread setExceptionHandler(EvbExceptionHandler evbExceptionHandler) {
        this.mExHandler = evbExceptionHandler;
        return this;
    }

    public void run() {
        synchronized (this) {
            try {
                this.mEventBase = new EventBase();
                ObjectDetour.c(this, 827971026);
            } catch (Throwable th) {
                ObjectDetour.c(this, 610339371);
            }
        }
        try {
            if (this.mEventBase != null) {
                this.mEventBase.loopForever();
            }
        } catch (Throwable th2) {
            if (this.mExHandler != null) {
                this.mExHandler.handle(th2);
            }
        }
    }

    public synchronized void waitForInitialization() {
        while (this.mEventBase == null) {
            try {
                ObjectDetour.a(this, -1304140244);
            } catch (InterruptedException e) {
            }
        }
    }

    public EventBase getEventBase() {
        Preconditions.checkNotNull(this.mEventBase, "EventBase has not been created yet");
        return this.mEventBase;
    }
}
