package com.facebook.analytics.timespent;

import com.facebook.analytics.timespent.TimeSpentEventReporter.AuthComponent;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: system_back */
public class TimeSpentModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static AuthComponent m1622a(TimeSpentEventReporter timeSpentEventReporter) {
        return timeSpentEventReporter.c;
    }
}
