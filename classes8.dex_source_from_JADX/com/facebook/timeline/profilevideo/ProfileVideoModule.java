package com.facebook.timeline.profilevideo;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.timeline.profilevideo.service.ForProfileVideoWorker;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: mPulsarLastSeenAt */
public class ProfileVideoModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @ForProfileVideoWorker
    static ListeningExecutorService m11056a() {
        return MoreExecutors.a(Executors.newSingleThreadExecutor());
    }
}
