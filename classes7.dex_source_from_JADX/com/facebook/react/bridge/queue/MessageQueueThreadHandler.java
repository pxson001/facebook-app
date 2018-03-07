package com.facebook.react.bridge.queue;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: get_notified_impression */
public class MessageQueueThreadHandler extends Handler {
    private final QueueThreadExceptionHandler f11550a;

    public MessageQueueThreadHandler(Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        super(looper);
        this.f11550a = queueThreadExceptionHandler;
    }

    public void dispatchMessage(Message message) {
        try {
            super.dispatchMessage(message);
        } catch (Exception e) {
            this.f11550a.mo643a(e);
        }
    }
}
