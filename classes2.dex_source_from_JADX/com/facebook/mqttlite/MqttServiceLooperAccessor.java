package com.facebook.mqttlite;

import android.content.Context;
import android.os.Looper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.push.mqtt.external.MqttThread;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fragment coordinator */
public class MqttServiceLooperAccessor implements InjectableComponentWithoutContext, Provider<Looper> {
    @Inject
    @MqttThread
    public Looper f23375a;

    private static <T extends InjectableComponentWithoutContext> void m31637a(Class<T> cls, T t, Context context) {
        m31638a(t, context);
    }

    public static void m31638a(Object obj, Context context) {
        ((MqttServiceLooperAccessor) obj).f23375a = Looper_MqttThreadMethodAutoProvider.m31640a(FbInjector.get(context));
    }

    private void m31636a(Looper looper) {
        this.f23375a = looper;
    }

    public MqttServiceLooperAccessor(Context context) {
        Class cls = MqttServiceLooperAccessor.class;
        m31638a(this, context);
    }

    public final Looper m31639a() {
        return this.f23375a;
    }

    public /* synthetic */ Object get() {
        return this.f23375a;
    }
}
