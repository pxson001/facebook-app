package com.facebook.react.bridge.queue;

/* compiled from: getRawWidth */
public class ProxyQueueThreadExceptionHandler implements QueueThreadExceptionHandler {
    private final MessageQueueThread f11570a;

    public ProxyQueueThreadExceptionHandler(MessageQueueThread messageQueueThread) {
        this.f11570a = messageQueueThread;
    }

    public final void mo643a(final Exception exception) {
        this.f11570a.runOnQueue(new Runnable(this) {
            final /* synthetic */ ProxyQueueThreadExceptionHandler f11569b;

            public void run() {
                throw new RuntimeException(exception);
            }
        });
    }
}
