package com.facebook.common.timeformat;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.TimeZone;

@InjectorModule
/* compiled from: request_lifetime */
public class TimeFormatModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static TimeZone m11826a() {
        return TimeZone.getDefault();
    }
}
