package com.facebook.push.mqtt.external;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.QeAccessor;

@InjectorModule
/* compiled from: sourceStoryId */
public class MqttExternalModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsWebRtcRetryEnabled
    public static Boolean m6361a(QeAccessor qeAccessor) {
        return Boolean.valueOf((qeAccessor.a(ExperimentsForMqttExternalModule.f4271a, 0) & 1) != 0);
    }

    @ProviderMethod
    @WebrtcPreemptiveReconnectTimeoutMs
    public static Integer m6362b(QeAccessor qeAccessor) {
        return Integer.valueOf(qeAccessor.a(ExperimentsForMqttExternalModule.f4272b, 0));
    }
}
