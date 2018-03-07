package com.facebook.common.init;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventBus;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.inject.Lazy;

/* compiled from: total_ble_devices_found */
public abstract class INeedInitForEventBusSubscription<E extends FbEvent, T> extends FbEventSubscriber<E> {
    private final FbEventBus f2386a;
    private final Lazy<T> f2387b;

    protected abstract void mo649a(E e, T t);

    protected INeedInitForEventBusSubscription(FbEventBus fbEventBus, Lazy<T> lazy) {
        this.f2386a = fbEventBus;
        this.f2387b = lazy;
    }

    public final FbEventBus m4557b() {
        return this.f2386a;
    }

    public final void mo650b(E e) {
        mo649a(e, this.f2387b.get());
    }
}
