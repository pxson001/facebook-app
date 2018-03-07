package com.facebook.push.mqtt.service.response;

import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.MonotonicClock;
import com.facebook.push.mqtt.service.ClientSubscriptionManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/* compiled from: sister */
public final class JsonMqttResponseProcessor<T> extends MqttResponseProcessor<T> {
    private final ObjectMapper f4332b;
    private final AbstractFbErrorReporter f4333c;
    private final Callback<T> f4334d;
    private JsonNode f4335e;

    /* compiled from: sister */
    public interface Callback<T> {
        boolean m6414a(JsonNode jsonNode);

        T m6415b(JsonNode jsonNode);
    }

    JsonMqttResponseProcessor(String str, FbBroadcastManager fbBroadcastManager, MonotonicClock monotonicClock, ClientSubscriptionManager clientSubscriptionManager, ObjectMapper objectMapper, FbErrorReporter fbErrorReporter, Callback<T> callback) {
        super(str, fbBroadcastManager, monotonicClock, clientSubscriptionManager);
        this.f4332b = objectMapper;
        this.f4333c = fbErrorReporter;
        this.f4334d = callback;
    }

    protected final void mo302a(String str, byte[] bArr) {
        try {
            this.f4335e = this.f4332b.a(bArr);
        } catch (JsonProcessingException e) {
            this.f4333c.a("json_parse_error", e);
        } catch (Throwable e2) {
            this.f4333c.a("json_parse_error", e2);
        }
    }

    protected final boolean mo303a() {
        return this.f4334d.m6414a(this.f4335e);
    }

    protected final T mo304b() {
        return this.f4334d.m6415b(this.f4335e);
    }
}
