package com.facebook.react.bridge.webworkers;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.MessageQueueThreadImpl;
import com.facebook.react.bridge.queue.ProxyQueueThreadExceptionHandler;

@DoNotStrip
/* compiled from: getLong */
public class WebWorkers {
    @DoNotStrip
    public static MessageQueueThread createWebWorkerThread(int i, MessageQueueThread messageQueueThread) {
        return MessageQueueThreadImpl.m13566a("web-worker-" + i, new ProxyQueueThreadExceptionHandler(messageQueueThread));
    }
}
