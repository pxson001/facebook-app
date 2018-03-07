package com.facebook.common.jniexecutors;

import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: album_cover_photo */
public class AndroidAsyncExecutorModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DefaultExecutorService
    @ProviderMethod
    @Singleton
    static AndroidAsyncExecutorFactory m19090a(ScheduledExecutorService scheduledExecutorService, MonotonicClock monotonicClock) {
        return new AndroidAsyncExecutorFactory(scheduledExecutorService);
    }

    @BackgroundExecutorService
    @ProviderMethod
    @Singleton
    static AndroidAsyncExecutorFactory m19091b(ScheduledExecutorService scheduledExecutorService, MonotonicClock monotonicClock) {
        return new AndroidAsyncExecutorFactory(scheduledExecutorService);
    }
}
