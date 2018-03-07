package com.facebook.mqtt.debug;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@InjectorModule
/* compiled from: top_message */
public class MqttStatsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static MqttStats getInstanceForTest_MqttStats(FbInjector fbInjector) {
        return MqttStats.a(fbInjector);
    }
}
