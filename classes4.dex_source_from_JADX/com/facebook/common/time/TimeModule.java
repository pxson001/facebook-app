package com.facebook.common.time;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.GregorianCalendar;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: use_adaptive_isac */
public class TimeModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    public static CurrentThreadTimeClock m755d() {
        return new CurrentThreadTimeClock();
    }

    @ProviderMethod
    public static GregorianCalendar m756e() {
        return new GregorianCalendar();
    }
}
