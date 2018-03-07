package com.facebook.content.event;

/* compiled from: total_ble_detection_events */
public abstract class FbEventSubscriber<T extends FbEvent> {
    public abstract Class<T> mo648a();

    public abstract void mo650b(T t);

    public boolean m4560a(T t) {
        return true;
    }
}
