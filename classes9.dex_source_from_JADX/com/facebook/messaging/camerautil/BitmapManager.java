package com.facebook.messaging.camerautil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.facebook.bitmaps.FbBitmapFactory;
import java.io.FileDescriptor;
import java.util.WeakHashMap;

/* compiled from: messenger_transcode_started */
public class BitmapManager {
    private static final Class<?> f9603a = BitmapManager.class;
    private static BitmapManager f9604c = null;
    private final WeakHashMap<Thread, ThreadStatus> f9605b = new WeakHashMap();

    /* compiled from: messenger_transcode_started */
    enum State {
        CANCEL,
        ALLOW
    }

    /* compiled from: messenger_transcode_started */
    class ThreadStatus {
        public State f9601a = State.ALLOW;
        public Options f9602b;

        public String toString() {
            String str;
            if (this.f9601a == State.CANCEL) {
                str = "Cancel";
            } else if (this.f9601a == State.ALLOW) {
                str = "Allow";
            } else {
                str = "?";
            }
            return "thread state = " + str + ", options = " + this.f9602b;
        }
    }

    private BitmapManager() {
    }

    private synchronized ThreadStatus m10201a(Thread thread) {
        ThreadStatus threadStatus;
        threadStatus = (ThreadStatus) this.f9605b.get(thread);
        if (threadStatus == null) {
            threadStatus = new ThreadStatus();
            this.f9605b.put(thread, threadStatus);
        }
        return threadStatus;
    }

    private synchronized void m10203a(Thread thread, Options options) {
        m10201a(thread).f9602b = options;
    }

    private synchronized void m10204b(Thread thread) {
        ((ThreadStatus) this.f9605b.get(thread)).f9602b = null;
    }

    private synchronized boolean m10205c(Thread thread) {
        boolean z = true;
        synchronized (this) {
            ThreadStatus threadStatus = (ThreadStatus) this.f9605b.get(thread);
            if (threadStatus != null) {
                z = threadStatus.f9601a != State.CANCEL;
            }
        }
        return z;
    }

    public static synchronized BitmapManager m10202a() {
        BitmapManager bitmapManager;
        synchronized (BitmapManager.class) {
            if (f9604c == null) {
                f9604c = new BitmapManager();
            }
            bitmapManager = f9604c;
        }
        return bitmapManager;
    }

    public final Bitmap m10206a(FileDescriptor fileDescriptor, Options options) {
        if (options.mCancel) {
            return null;
        }
        Thread currentThread = Thread.currentThread();
        if (m10205c(currentThread)) {
            m10203a(currentThread, options);
            Bitmap a = FbBitmapFactory.a(fileDescriptor, null, options);
            m10204b(currentThread);
            return a;
        }
        new StringBuilder("Thread ").append(currentThread).append(" is not allowed to decode.");
        return null;
    }
}
