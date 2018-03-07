package com.facebook.push.mqtt.service.response;

import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.push.mqtt.service.ClientSubscriptionManager;

/* compiled from: simplesearch_typeahead */
public final class ThriftMqttResponseProcessor<T> extends MqttResponseProcessor<T> {
    private final Callback<T> f4342b;

    /* compiled from: simplesearch_typeahead */
    public interface Callback<T> {
        void m6436a(byte[] bArr);

        boolean m6437a();

        T m6438b();
    }

    ThriftMqttResponseProcessor(String str, FbBroadcastManager fbBroadcastManager, MonotonicClock monotonicClock, ClientSubscriptionManager clientSubscriptionManager, Callback<T> callback) {
        super(str, fbBroadcastManager, monotonicClock, clientSubscriptionManager);
        this.f4342b = callback;
    }

    protected final void mo302a(String str, byte[] bArr) {
        this.f4342b.m6436a(bArr);
    }

    protected final boolean mo303a() {
        return this.f4342b.m6437a();
    }

    protected final T mo304b() {
        return this.f4342b.m6438b();
    }
}
