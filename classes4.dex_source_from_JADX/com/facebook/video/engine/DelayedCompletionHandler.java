package com.facebook.video.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: pending_contactpoints/ */
public class DelayedCompletionHandler extends Handler {
    public static int f5270a = 0;

    /* compiled from: pending_contactpoints/ */
    public interface DelayedCompletionListener {
        void mo472a(int i);
    }

    public DelayedCompletionHandler() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        DelayedCompletionListener delayedCompletionListener = message.obj instanceof DelayedCompletionListener ? (DelayedCompletionListener) message.obj : null;
        if (delayedCompletionListener != null) {
            delayedCompletionListener.mo472a(message.arg1);
        }
    }
}
