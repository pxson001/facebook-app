package com.facebook.events.dateformatter;

import com.facebook.events.dateformatter.annotation.EventsTimeZone;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.TimeZone;

@InjectorModule
/* compiled from: option_display_styles */
public class EventsDateFormatterModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @EventsTimeZone
    public static TimeZone m6489a() {
        return TimeZone.getDefault();
    }
}
