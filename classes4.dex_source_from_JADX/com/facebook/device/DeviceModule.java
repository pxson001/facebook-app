package com.facebook.device;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android_src.util.MemInfoReader;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: has been set up. More than one value is not allowed from the same state type */
public class DeviceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static MemInfoReader m11329a() {
        return new MemInfoReader();
    }

    @ProviderMethod
    @SuppressLint({"ExplicitComplexProvider"})
    @Singleton
    static DeviceMemoryInfoReader m11330a(Provider<JellyBeanOrHigherDeviceMemoryInfoReader> provider, Provider<PreJellyBeanDeviceMemoryInfoReader> provider2) {
        if (VERSION.SDK_INT >= 16) {
            return (DeviceMemoryInfoReader) provider.get();
        }
        return (DeviceMemoryInfoReader) provider2.get();
    }
}
