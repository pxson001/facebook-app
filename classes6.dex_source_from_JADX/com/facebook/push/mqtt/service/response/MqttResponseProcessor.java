package com.facebook.push.mqtt.service.response;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.push.mqtt.external.PublishedPayloadDescriptor;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.push.mqtt.service.ClientSubscriptionManager;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: single_state_v2 */
public abstract class MqttResponseProcessor<T> {
    public final String f4325a;
    private final BaseFbBroadcastManager f4326b;
    private final MonotonicClock f4327c;
    private final ClientSubscriptionManager f4328d;
    private T f4329e;
    private boolean f4330f;
    private SelfRegistrableReceiverImpl f4331g;

    /* compiled from: single_state_v2 */
    class C02671 implements ActionReceiver {
        final /* synthetic */ MqttResponseProcessor f4341a;

        C02671(MqttResponseProcessor mqttResponseProcessor) {
            this.f4341a = mqttResponseProcessor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1639281067);
            if ("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED".equals(intent.getAction())) {
                MqttResponseProcessor.m6416a(this.f4341a, PushStateEvent.fromValue(intent.getIntExtra("event", -1)));
            } else {
                PublishedPayloadDescriptor publishedPayloadDescriptor = new PublishedPayloadDescriptor(intent.getExtras());
                MqttResponseProcessor.m6418b(this.f4341a, publishedPayloadDescriptor.a, publishedPayloadDescriptor.b);
            }
            LogUtils.e(-2127916596, a);
        }
    }

    protected abstract void mo302a(String str, byte[] bArr);

    protected abstract boolean mo303a();

    protected abstract T mo304b();

    protected MqttResponseProcessor(String str, BaseFbBroadcastManager baseFbBroadcastManager, MonotonicClock monotonicClock, ClientSubscriptionManager clientSubscriptionManager) {
        this.f4325a = str;
        this.f4326b = baseFbBroadcastManager;
        this.f4327c = monotonicClock;
        this.f4328d = clientSubscriptionManager;
    }

    public final void m6426c() {
        C02671 c02671 = new C02671(this);
        this.f4331g = this.f4326b.a().a("com.facebook.push.mqtt.ACTION_MQTT_PUBLISH_ARRIVED", c02671).a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", c02671).a();
        this.f4331g.b();
        this.f4328d.b(ImmutableSet.of(this.f4325a), RegularImmutableSet.a);
    }

    public final void m6427d() {
        if (this.f4331g != null) {
            this.f4331g.c();
            this.f4331g = null;
        }
        this.f4328d.b(RegularImmutableSet.a, ImmutableSet.of(this.f4325a));
    }

    public final T m6428e() {
        return this.f4329e;
    }

    private boolean m6417a(String str) {
        return Objects.equal(this.f4325a, str);
    }

    private void m6419f() {
        this.f4329e = mo304b();
    }

    private boolean m6420g() {
        return this.f4330f;
    }

    private void m6421h() {
        this.f4330f = true;
    }

    public static synchronized void m6416a(MqttResponseProcessor mqttResponseProcessor, PushStateEvent pushStateEvent) {
        synchronized (mqttResponseProcessor) {
            if (PushStateEvent.CHANNEL_DISCONNECTED.equals(pushStateEvent)) {
                mqttResponseProcessor.m6421h();
                ObjectDetour.c(mqttResponseProcessor, -904260982);
            }
        }
    }

    public static synchronized void m6418b(MqttResponseProcessor mqttResponseProcessor, String str, byte[] bArr) {
        synchronized (mqttResponseProcessor) {
            if (mqttResponseProcessor.m6428e() == null && mqttResponseProcessor.m6417a(str)) {
                mqttResponseProcessor.mo302a(str, bArr);
                if (mqttResponseProcessor.mo303a()) {
                    mqttResponseProcessor.m6419f();
                }
                ObjectDetour.c(mqttResponseProcessor, 1655621417);
            }
        }
    }

    public final synchronized boolean m6424a(long j) {
        long now = this.f4327c.now() + j;
        long now2 = now - this.f4327c.now();
        while (now2 > 0 && m6428e() == null && !m6420g()) {
            ObjectDetour.a(this, now2, 442409054);
            now2 = now - this.f4327c.now();
        }
        return m6428e() != null;
    }
}
