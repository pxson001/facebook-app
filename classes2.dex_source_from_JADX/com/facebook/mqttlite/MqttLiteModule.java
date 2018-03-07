package com.facebook.mqttlite;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.push.mqtt.external.MqttThread;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: fr */
public class MqttLiteModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @MqttThread
    static Looper m31643a(FbHandlerThreadFactory fbHandlerThreadFactory) {
        HandlerThread a = fbHandlerThreadFactory.m3580a("MqttHandler", ThreadPriority.URGENT);
        a.start();
        return a.getLooper();
    }

    @ProviderMethod
    @Singleton
    @MqttThread
    static Handler m31642a(Looper looper) {
        return new Handler(looper);
    }
}
