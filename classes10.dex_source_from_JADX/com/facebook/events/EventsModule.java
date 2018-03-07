package com.facebook.events;

import com.facebook.events.annotation.IsNewEventCreationFlowEnabledInPMA;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: content_search_send_pressed */
public class EventsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsNewEventCreationFlowEnabledInPMA
    public static Boolean m16331a() {
        return Boolean.valueOf(false);
    }
}
