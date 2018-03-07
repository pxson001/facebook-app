package com.facebook.mqtt.capabilities;

import com.facebook.common.util.BitmaskEnumUtil;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.EnumSet;
import java.util.Set;

@InjectorModule
/* compiled from: flattenToBuffer is not supported */
public class MqttCapabilitiesModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @MqttEndpointCapability
    public static Long m32002a(Set<RequiredMqttCapabilities> set) {
        Set noneOf = EnumSet.noneOf(MqttCapability.class);
        for (RequiredMqttCapabilities a : set) {
            noneOf.addAll(a.mo3495a());
        }
        return Long.valueOf(BitmaskEnumUtil.m32027a(noneOf));
    }
}
